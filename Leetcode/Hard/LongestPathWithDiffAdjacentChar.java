// You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

// You are also given a string s of length n, where s[i] is the character assigned to node i.

// Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

// Example 1:
// Input: parent = [-1,0,0,1,1,2], s = "abacbe"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3 is returned.
// It can be proven that there is no longer path that satisfies the conditions. 

// Example 2:
// Input: parent = [-1,0,0,0], s = "aabc"
// Output: 3
// Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.

// Constraints:
// n == parent.length == s.length
// 1 <= n <= 105
// 0 <= parent[i] <= n - 1 for all i >= 1
// parent[0] == -1
// parent represents a valid tree.
// s consists of only lowercase English letters.

// Overview
// The problem presents an undirected tree with n nodes. Each node of the tree has a character associated with it. Our task is to find the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

// Approach: Depth First Search
// Intuition
// Intuitively, we can think that for any parent node, the longest path will be formed by choosing at most the two longest chains of its child nodes. Here's a visual explanation of the two scenarios that could occur where node p is the parent node:

// img

// So, for a node p if we find the two longest chains of its child nodes, say L1 and L2 we can compute the longest path centered at node p. For each node, we can find the maximum of value 1 + L1 + L2 to find the answer. The addition of one comes for the node p itself.

// Let's take an example to understand this better. Consider the following subtree, where each node has a character and the length of the longest chain starting from the node (including it). Assume, we have visited all the children of node a and are yet to compute the answer for the longest path centered at node a.

// img

// We pick up the two longest chains, which have characters different from those of node a. In this case, these are the nodes with the characters b and d. It should be noted, that depending on the children of a node and the characters associated with the children and the node, we might not be unable to pick up any chains or might only be able to pick up one chain. We will not be able to pick up any chains centered at the node when it does not have any children or all its children have the same character as the node. In such cases, we will consider the length of the longest and second longest chains amongst its children as 0.

// img

// The longest path centered at node a will be 1 + 2 + 3 = 6.

// Going forward, we also need the length of the longest chain starting from a to be used by its parent. It would be 1 + L1, where L1 is the length of the longest chain of a child, which leads to 1 + 3 = 4.

// img

// This way we can figure out the length of the longest path by selecting each node as the center and using the two longest chains of its children.

// A good algorithm to pass the information from the children to their parents is a depth-first search (DFS). In DFS, we explore nodes as far as possible along each branch. Upon reaching the end of the current branch, we backtrack to the next possible branch and continue exploring.

// Following the above approach, the idea is to visit all the children of every node recursively, get the length of the longest chain starting from the child, and use the longest and second longest chains to get the longest path centered at that node.

// We initialize the answer variable longestPath = 1, since a single node can always be taken as its own path. We implement a DFS traversal algorithm for a node that returns the length of longest chain starting from the node and begin with the root 0. We initialize two variables, say longestChain = 0 and secondLongestChain = 0 to store the longest and second longest chains amongst its children.

// We recursively iterate over each child of the node. We store the longest chain starting from child in another variable, say longestChainStartingFromChild. Using longestChainStartingFromChild, we update longestChain and secondLongestChain to store the longest and second longest chains amongst the children of the currentNode.

// The answer variable is updated to longestPath = max(longest, longestChain + secondLongestChain + 1). In the end, we return the longest chain starting from the node (including it) which is 1 + longestChain. The answer is updated with both chains because we are treating the current node as the center. But when we return, we can only include one chain, otherwise there would be three branches at the current node which is not a valid path.

// Algorithm
// Initialize an array children, where children[X] contains all the children of node X.
// Initialize the answer variable longestPath = 1 (a single node can always be selected).
// Start a DFS traversal.
// We use a dfs function to perform the traversal. For each call, pass currentNode, children, s, and longestPath as the parameters. It returns the length of the longest chain starting from that currentNode.
// Initialize two integers longestChain = 0 and secondLongestChain = 0, to store the longest and the second longest chains across all the children of the currentNode.
// Iterate over all the children and for every child, recursively call the dfs function with child, children, s, longestPath as the parameters. This call returns the length of longest path longestChainStartingFromChild starting from child.
// Use longestChainStartingFromChild to update longestChain and secondLongestChain.
// After iterating over all the children, use longestChain and secondLongestChain to update the longestPath to max(longestPath, longestChain + secondLongestChain + 1). The +1 comes from the currentNode which connects the two chains.
// Return the length of the longest chain including the currentNode which is longestChain + 1.
// Return longestPath.

class Solution {
  private int longestPath = 1;

 public int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
     // If the node is the only child, return 1 for the currentNode itself.
     if (!children.containsKey(currentNode)) {
         return 1;
     }

     // Longest and second longest path starting from currentNode (does not count the
     // currentNode itself).
     int longestChain = 0, secondLongestChain = 0;
     for (int child : children.get(currentNode)) {
         // Get the number of nodes in the longest chain starting from the child,
         // including the child.
         int longestChainStartingFromChild = dfs(child, children, s);
         // We won't move to the child if it has the same character as the currentNode.
         if (s.charAt(currentNode) == s.charAt(child)) {
             continue;
         }
         // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
         // is bigger.
         if (longestChainStartingFromChild > longestChain) {
             secondLongestChain = longestChain;
             longestChain = longestChainStartingFromChild;
         } else if (longestChainStartingFromChild > secondLongestChain) {
             secondLongestChain = longestChainStartingFromChild;
         }
     }

     // Add "1" for the node itself.
     longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
     return longestChain + 1;
 }

 public int longestPath(int[] parent, String s) {
     int n = parent.length;
     Map<Integer, List<Integer>> children = new HashMap<>();
     // Start from node 1, since root node 0 does not have a parent.
     for (int i = 1; i < n; i++) {
         children.computeIfAbsent(parent[i], value -> new ArrayList<Integer>()).add(i);
     }

     dfs(0, children, s);

     return longestPath;
 }
}