// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

// Example 1:
// Input: nums = [-10,-3,0,5,9]

// Output: [0,-3,9,-10,null,5]

// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:
// Input: nums = [1,3]

// Output: [3,1]

// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

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
  // Recursion
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(0, nums.length - 1, nums);
  }

  public TreeNode dfs(int start, int end, int[] nums) {
    if (start > end)
      return null;

    int mid = start + (end - start) / 2;

    TreeNode root = new TreeNode(nums[mid]);
    root.left = dfs(start, mid - 1, nums);
    root.right = dfs(mid + 1, end, nums);

    return root;
  }
}
