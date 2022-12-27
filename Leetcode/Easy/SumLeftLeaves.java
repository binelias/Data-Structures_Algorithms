// Given the root of a binary tree, return the sum of all left leaves.

// A leaf is a node with no children. A left leaf is a leaf that is the left
// child of another node.

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and
// 15 respectively.
// Example 2:

// Input: root = [1]
// Output: 0

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -1000 <= Node.val <= 1000

// Recursive method. For given node we check whether its left child is a leaf. If it is the case, we add its value to answer, otherwise recursively call method on left child. For right child we call method only if it has at least one nonnull child.

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    // corner case
    if (root == null)
      return 0;

    int ans = 0;
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null)
        ans += root.left.val;
      else
        ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);

    return ans;
  }
}

// Iterative method. Here for each node in the tree we check whether its left
// child is a leaf. If it is true, we add its value to answer, otherwise add
// left child to the stack to process it later. For right child we add it to
// stack only if it is not a leaf.

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    // corner case
    if (root == null)
      return 0;

    int ans = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode node = stack.pop();
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null)
          ans += node.left.val;
        else
          stack.push(node.left);
      }
      if (node.right != null) {
        if (node.right.left != null || node.right.right != null)
          stack.push(node.right);
      }
    }
    return ans;
  }
}