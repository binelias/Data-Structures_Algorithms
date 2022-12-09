// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

// Two binary trees are considered leaf-similar if their leaf value sequence is the same.

// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

// Example 1:

// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:

// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false

// Approach 1: Depth First Search
// Intuition and Algorithm

// Let's find the leaf value sequence for both given trees. Afterwards, we can compare them to see if they are equal or not.

// To find the leaf value sequence of a tree, we use a depth first search. Our dfs function writes the node's value if it is a leaf, and then recursively explores each child. This is guaranteed to visit each leaf in left-to-right order, as left-children are fully explored before right-children.

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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList();
    List<Integer> leaves2 = new ArrayList();
    dfs(root1, leaves1);
    dfs(root2, leaves2);
    return leaves1.equals(leaves2);
  }

  public void dfs(TreeNode node, List<Integer> leafValues) {
    if (node != null) {
      if (node.left == null && node.right == null)
        leafValues.add(node.val);
      dfs(node.left, leafValues);
      dfs(node.right, leafValues);
    }
  }// T:O(n1 + n2), S:(n1+n2)
}
