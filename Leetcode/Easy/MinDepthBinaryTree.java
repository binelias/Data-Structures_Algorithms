// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 2

// Example 2:
// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5

// Constraints:
// The number of nodes in the tree is in the range [0, 105].
// -1000 <= Node.val <= 1000

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
  // BFS/Level Order Traversal
  public int minDepth(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    if (root == null)
      return 0;
    int minDepth = 0;
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left == null && node.right == null)
          return minDepth + 1;
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
      }
      minDepth++;

    }
    return minDepth;
  }
}

// Approach 2: The usual DFS/recursive: FInd the height of left subtree and
// right subtree and take minimum of the two. One edge case if all that if
// either of left node/right node is completely null like below.
// In that case we the length of left subtree will be 0 and assuming right
// substree is non zero. min(left,right) will give 0+1 =1 which is WA. To avoid
// that case we are doing ( left == 0 || right == 0)? right + left+1.

class Solution {
  // DFS
  public int minDepth(TreeNode root) {
    return cal(root);
  }

  public int cal(TreeNode root) {
    if (root == null)
      return 0;
    int left = cal(root.left);

    int right = cal(root.right);

    return (left == 0 || right == 0) ? right + left + 1 : 1 + Math.min(left, right);
  }
}