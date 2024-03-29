// Given the root of a binary tree, invert the tree, and return its root.

// Example 1:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

// Example 2:
// Input: root = [2,1,3]
// Output: [2,3,1]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100


// Approach 1: Recursive

// This is a classic tree problem that is best-suited for a recursive approach.

// Algorithm

// The inverse of an empty tree is the empty tree. The inverse of a tree with root rrr, and subtrees right\text{right}right and left\text{left}left, is a tree with root rrr, whose right subtree is the inverse of left\text{left}left, and whose left subtree is the inverse of right\text{right}right.

// Complexity Analysis

// Since each node in the tree is visited only once, the time complexity is O(n), where n is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.

// Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n)

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
  // recursive
  public TreeNode invertTree(TreeNode root) {
    // base case
    if (root == null)
      return null;

    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);

    root.left = right;
    root.right = left;

    return root;
  }
}

// Approach 2: Iterative

// Alternatively, we can solve the problem iteratively, in a manner similar to breadth-first search.

// Algorithm

// The idea is that we need to swap the left and right child of all nodes in the tree. So we create a queue to store nodes whose left and right child have not been swapped yet. Initially, only the root is in the queue. As long as the queue is not empty, remove the next node from the queue, swap its children, and add the children to the queue. Null nodes are not added to the queue. Eventually, the queue will be empty and all the children swapped, and we return the original root.

// Complexity Analysis

// Since each node in the tree is visited / added to the queue only once, the time complexity is O(n), where nnn is the number of nodes in the tree.

// Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. For a full binary tree, the leaf level has ⌈n2⌉=O(n) leaves.

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
  //recursive
  public TreeNode invertTree(TreeNode root) {
      //base case
      if(root == null) return null;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while(!queue.isEmpty()){
          TreeNode current = queue.poll();
          TreeNode temp = current.left;
          current.left = current.right;
          current.right = temp;

          if(current.left != null) queue.add(current.left);
          if(current.right != null) queue.add(current.right);
      }
      return root;
  }
}