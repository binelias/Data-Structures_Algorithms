// Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

// A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

// Example 1:

// Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
// Output: 7
// Explanation: We have various ancestor-node differences, some of which are given below :
// |8 - 3| = 5
// |3 - 7| = 4
// |8 - 1| = 7
// |10 - 13| = 3
// Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
// Example 2:

// Input: root = [1,null,2,null,0,3]
// Output: 3

// Approach: Maximum Minus Minimum
// Intuition

// An insight is that:

// Given any two nodes on the same root-to-leaf path, they must have the required ancestor relationship.
// Therefore, we just need to record the maximum and minimum values of all root-to-leaf paths and return the maximum difference.

// To achieve this, we can record the maximum and minimum values during the recursion and return the difference when encountering leaves.

// Algorithm

// Step 1: Define a function helper, which takes three arguments as input and returns an integer.

// The first argument node is the current node, and the second argument cur_max and third argument cur_min are the maximum and minimum values along the root to the current node, respectively.

// Function helper returns cur_max - cur_min when encountering leaves. Otherwise, it calls helper on the left and right subtrees and returns their maximum.

// Step 2: Run helper on the root and return the result.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root, root.val, root.val);
  }

  public int helper(TreeNode node, int curMax, int curMin) {
    // if encounter leaves, return the max-min along the path
    if (node == null) {
      return curMax - curMin;
    }
    // else, update max and min
    // and return the max of left and right subtrees
    curMax = Math.max(curMax, node.val);
    curMin = Math.min(curMin, node.val);
    int left = helper(node.left, curMax, curMin);
    int right = helper(node.right, curMax, curMin);
    return Math.max(left, right);
  }
}
