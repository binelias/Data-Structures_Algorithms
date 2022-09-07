// You are given two binary trees root1 and root2.

// Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

// Return the merged tree.

// Note: The merging process must start from the root nodes of both trees.


// Example 1:
// Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
// Output: [3,4,5,5,4,null,7]

// Example 2:
// Input: root1 = [1], root2 = [1,2]
// Output: [2,2]

// Approach #1 Using Recursion
// We can traverse both the given trees in a preorder fashion. At every step, we check if the current node exists(isn't null) for both the trees. If so, we add the values in the current nodes of both the trees and update the value in the current node of the first tree to reflect this sum obtained. At every step, we also call the original function mergeTrees() with the left children and then with the right children of the current nodes of the two trees. If at any step, one of these children happens to be null, we return the child of the other tree(representing the corresponding child subtree) to be added as a child subtree to the calling parent node in the first tree. At the end, the first tree will represent the required resultant merged binary tree.

// The following animation illustrates the process.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //Base case
    if(root1 == null) return root2;
    if(root2 == null) return root1;
    
    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right,root2.right);
    return root1;
  }
}//T: O(n), S:O(n) or O(logn)


// 
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
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      //Base case
      if(root1 == null) return root2;
      
      Stack<TreeNode[]> stack = new Stack<>();
      stack.push(new TreeNode[] {root1, root2});
      while(!stack.isEmpty()) {
          TreeNode[] t = stack.pop();
          if(t[0] == null || t[1] == null) continue;
          t[0].val += t[1].val;
          
          if(t[0].left == null) t[0].left = t[1].left;
          else stack.push(new TreeNode[] {t[0].left, t[1].left});
          
          if(t[0].right == null) t[0].right = t[1].right;
          else stack.push(new TreeNode[] {t[0].right, t[1].right}); 
      }
      return root1;
  } 
}