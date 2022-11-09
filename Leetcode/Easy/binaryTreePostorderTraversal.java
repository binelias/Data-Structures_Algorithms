// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:

// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Follow up: Recursive solution is trivial, could you do it iteratively?

// 1. Recursive approach:
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
  List<Integer> ans = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    traverse(root);
    return ans;
  }

  public void traverse(TreeNode root) {
    if (root == null)
      return;
    traverse(root.left);
    traverse(root.right);
    ans.add(root.val);
  }
}// T: O(n), S: O(n)

// 2. Iterative approach:

class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null)
      return ans;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      ans.add(curr.val);

      if (curr.left != null)
        stack.push(curr.left);
      if (curr.right != null)
        stack.push(curr.right);
    }

    Collections.reverse(ans);
    return ans;
  }
}// T: O(n), S: O(n)