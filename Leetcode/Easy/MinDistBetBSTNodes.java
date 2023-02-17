// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.


// Example 1:


// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:


// Input: root = [1,0,48,null,null,12,49]
// Output: 1

// Constraints:

// The number of nodes in the tree is in the range [2, 100].
// 0 <= Node.val <= 105



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
  public int minDiffInBST(TreeNode root) {
      ArrayDeque<TreeNode> stack = new ArrayDeque<>();
      int minDiff = Integer.MAX_VALUE;
      stack.push(root);
      TreeNode currNode = root.left;
      TreeNode prevNode = null;
      while(currNode != null || !stack.isEmpty()){
          while(currNode != null){
              stack.push(currNode);
              currNode = currNode.left;
          }
          currNode = stack.pop();
          if(prevNode != null)
              minDiff = Math.min(minDiff, currNode.val - prevNode.val);
          prevNode = currNode;
          currNode = currNode.right;
      }
      return minDiff;
  }
}