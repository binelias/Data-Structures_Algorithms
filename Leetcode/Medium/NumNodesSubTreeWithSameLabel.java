// You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

// The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.

// Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.

// A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.


// Example 1:


// Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
// Output: [2,1,1,1,1,1,1]
// Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
// Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
// Example 2:


// Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
// Output: [4,2,1,1]
// Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
// The sub-tree of node 3 contains only node 3, so the answer is 1.
// The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
// The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.
// Example 3:


// Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
// Output: [3,2,1,1,1]

// Constraints:

// 1 <= n <= 105
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// labels.length == n
// labels is consisting of only of lowercase English letters.

// Approach: Depth First Search
// Intuition
// One brute force approach that we might think of is to explore every subtree of each node and count how many labels similar to the node exist in its subtree. However, this would take O(N2)O(N^2)O(N 
// 2
//  ) time because we would have to traverse the entire subtree of each node.

// Intuitively, we can consider computing the answer of a parent node from its child nodes. Let's say there is a node p, that has two children, c1 and c2. If nodes c1 and c2 have the total count of each label (a to z) in their respective subtrees, then it would be easy to compute the answer for node p. Using the count of each label in c1 and c2, we can compute the count in p's subtree.

// So, to compute the answer of a node, first we have to find the count of each label in every child node subtree. Then, we use it to find the answer for the parent node.

// A depth-first search is a good algorithm for such a situation. In DFS, we explore nodes as far as possible along each branch. Upon reaching the end of the current branch, we backtrack to the next possible branch and continue exploring.

// Once we encounter an unvisited node, we will take one of its neighbor nodes (if exists) as the next node on this branch. Recursively call the function to take the next node as the 'starting node' and solve the subproblem. If we reach the end of this branch, we backtrack to the previous node and visit the next neighbor node (if exists), and repeat the process.

// If you are new to DFS, please see our Leetcode Explore Card for more information on it!

// Following from the above discussion, the idea is to visit all the children of every node recursively, compute the count of each label in every child's subtree, and use it to compute the answer of the parent node.

// Let's take an example. Let's say we have a node c which is a child of a node p. Let's also create an array nodeCount[26] to store the count of each label in the subtree of p. nodeCount[0] will store the count of label a, nodeCount[1] will store the count for b and so on. We count one for the node label itself, i.e., nodeCount[labels[p] - a] = 1.

// Now, we iterate over the child c and get the count of each label in the subtree of c, let's store it in another array childCount[26]. For each label, we add the count in the subtree of c to the count in the subtree of p i.e., nodeCount[i] += childCount[i]. After iterating over all the children (if there are more) of p, the answer of node p would be nodeCount[labels[p] - 'a'].

// Refer to the following slides for a step-by-step visual example:

// Current

// Algorithm
// Create an adjacency list where adj[X] contains all the neighbors of node X.
// Initialize an array ans, storing the answer of each node. Initialize it with 0 for every node.
// Start a DFS traversal.
// We use a dfs function to perform the traversal. For each call, pass node, parent, adj, labels and ans as the parameters. It returns an array which stores the count of each label in the node's subtree. We start with node 0. We also keep track of the parent node of the current node so that we don’t visit the node’s parent as it has already been visited.
// Initialize an array nodeCounts to store the count of each label in the node's subtree. Initialize it with 0 except for the node label, which should be 1.
// Iterate over all the children of the node (nodes that share an edge) and check if any child is equal to the parent. If the child is equal to the parent, we will not visit it again.
// If the child is not equal to the parent, recursively call the dfs function with the node as child and the parent as node. Store the count of all labels in its subtree in childCounts.
// Add childCounts to nodeCounts.
// After looping through all the children, set the ans[node] to ans[node] = nodeCounts[labels[node]].
// Return nodeCounts.
// Return ans.

class Solution {
  public int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
        char[] labels, int[] ans) {
    // Store count of all alphabets in the subtree of the node.
    int[] nodeCounts = new int[26];
    nodeCounts[labels[node] - 'a'] = 1;

    if (!adj.containsKey(node))
        return nodeCounts;
    for (int child : adj.get(node)) {
        if (child == parent) {
            continue;
        }
        int[] childCounts = dfs(child, node, adj, labels, ans);
        // Add frequencies of the child node in the parent node's frequency array.
        for (int i = 0; i < 26; i++) {
            nodeCounts[i] += childCounts[i];
        }
    }

    ans[node] = nodeCounts[labels[node] - 'a'];
    return nodeCounts;
}

public int[] countSubTrees(int n, int[][] edges, String labels) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
        int a = edge[0], b = edge[1];
        adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
        adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
    }

    int[] ans = new int[n];
    char[] label = labels.toCharArray();
    dfs(0, -1, adj, label, ans);
    return ans;
}
}