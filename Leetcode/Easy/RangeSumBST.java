// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

 

// Example 1:


// Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
// Output: 32
// Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
// Example 2:


// Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
// Output: 23
// Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

// Approach 1: Depth First Search
// Intuition and Algorithm

// We traverse the tree using a depth first search. If node.val falls outside the range [low, high], (for example node.val < low), then we know that only the right branch could have nodes with value inside [low, high].

// We showcase two implementations - one using a recursive algorithm, and one using an iterative one.

// Recursive Implementation

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int ans;
  public int rangeSumBST(TreeNode root, int low, int high) {
      ans = 0;
      dfs(root, low, high);
      return ans;
  }
  
  public void dfs(TreeNode node, int low, int high) {
      if (node != null) {
          if (low <= node.val && node.val <= high)
              ans += node.val;
          if (low < node.val)
              dfs(node.left, low, high);
          if (node.val < high)
              dfs(node.right, low, high);
      }
  }
}

// Iterative Implementation

class Solution {
  public int rangeSumBST(TreeNode root, int low, int high) {
      int ans = 0;
      Stack<TreeNode> stack = new Stack();
      stack.push(root);
      while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          if (node != null) {
              if (low <= node.val && node.val <= high)
                  ans += node.val;
              if (low < node.val)
                  stack.push(node.left);
              if (node.val < high)
                  stack.push(node.right);
          }
      }
      return ans;
  }
}