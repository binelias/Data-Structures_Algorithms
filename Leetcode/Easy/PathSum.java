// 

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
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return check(root, targetSum, 0);
  }

  static boolean check(TreeNode t, int target, int sum) {
    if (t == null) {// if there is no element in linked list, it is not possible to make target sum
      return false;
    }
    sum += t.val; // adding to sum while moving forward in recursion

    if (t.left == null && t.right == null && sum == target)
      return true;
    else {// if any branch makes the target sum we return true else false;
      return check(t.left, target, sum) || check(t.right, target, sum);
    }
  }
}