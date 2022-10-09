// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false

// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100

// Follow up: Could you solve it both recursively and iteratively?

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

// Recursive
class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    if (root.left != null && root.right != null) {
      if (root.left.val != root.right.val)
        return false;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return true;
    if (t1 == null || t2 == null)
      return false;

    boolean isLeftSymmetric = isSymmetric(t1.left, t2.right);
    boolean isRightSymmetric = isSymmetric(t1.right, t2.left);

    return (t1.val == t2.val) && isLeftSymmetric && isRightSymmetric;
  }
}

// Iterative
class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;

    Queue<TreeNode> left = new LinkedList<>();
    Queue<TreeNode> right = new LinkedList<>();

    left.add(root.left);
    right.add(root.right);

    while (!left.isEmpty() && !right.isEmpty()) {
      TreeNode l = left.poll();
      TreeNode r = right.poll();

      if (l == null && r == null)
        continue;
      if (l == null || r == null)
        return false;
      if (l.val != r.val)
        return false;

      left.add(l.left);
      right.add(r.right);

      left.add(l.right);
      right.add(r.left);
    }

    if (left.isEmpty() && right.isEmpty())
      return true;
    else
      return false;
  }
}