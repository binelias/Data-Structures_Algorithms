// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


// Example 1:
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Example 2:
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// Example 3:
// Input: root = [2,1], p = 2, q = 1
// Output: 2

// Solution 1: Iterate in BST

// Let large = max(p.val, q.val), small = min(p.val, q.val).
// We keep iterate root in our BST:
// If root.val > large then both node p and q belong to the left subtree, go to left by root = root.left.
// If root.val < small then both node p and q belong to the right subtree, go to right by root = root.right.
// Now, small <= root.val <= large the current root is the LCA between q and p.

public class LowestCommonAncestorBinarySearchTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int small = Math.min(p.val, q.val);
    int large = Math.max(p.val, q.val);
    while(root != null) {
        if(root.val > large) root = root.left;// p, q belong to the left subtree
        else if(root.val < small) root = root.right;// p, q belong to the right subtree
        else return root;// Now, small <= root.val <= large -> This root is the LCA between p and q
    }
    return null;//T: O(H), S: O(1)
