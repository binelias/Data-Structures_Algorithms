// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

class Solution {
  private  boolean checkForBst(TreeNode node, double min, double max) {
      // check for duplicates in the node value. BST should not have duplicate node values
      if(node.val<=min || node.val>=max) return false;


      if(node.left!=null){
        // traverse the left side of the tree. min param will always stay same for the left.
        // Max will be replaced with node.val for the right side.
        if(!checkForBst(node.left,min,node.val)) return false;

      }

      if(node.right!=null){
        // traverse the right side of the tree .
        // min param will be replaced by node.val
        // max will remain the same
        if(!checkForBst(node.right,node.val,max)) return false;
      }
      return true;
  }
  
  public boolean isValidBST(TreeNode root) {
      if (root == null) return true;
      return checkForBst(root, -9999999999999.99,99999999999.99);
  }
  
}

class Solution {
  public boolean isValidBST(TreeNode root) {
      if(root == null) return true;
      Stack<TreeNode> stack = new Stack<>();
      TreeNode pre = null;
      while(root != null || !stack.isEmpty()) {
          while(root != null) {
              stack.push(root);
              root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.val <= pre.val) return false;
          pre = root;
          root = root.right;
      }
      return true;
  }
}