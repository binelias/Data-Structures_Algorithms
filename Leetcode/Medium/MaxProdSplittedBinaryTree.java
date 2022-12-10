// Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

// Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

// Note that you need to maximize the answer before taking the mod and not after taking it.

// Example 1:

// Input: root = [1,2,3,4,5,6]
// Output: 110
// Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
// Example 2:

// Input: root = [1,null,2,3,4,null,null,5,6]
// Output: 90
// Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)

// PostOrder Traverse

// Firstly, I use post-order to accumulate the node val, including left subtree and right subtree
// And generate the 1-D array to put the accumulated sum into this array
// Then, the final value of this accumulated array is the total sum of the binary tree
// Furthermore, I use Long type to avoid the integer overflow

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
  List<Long> list;
  long mod = 1000000007;

  public int maxProduct(TreeNode root) {
    list = new ArrayList<>();
    long total = postOrder(root);
    long max = 0;
    long prod = 0;

    for (int i = 0; i < list.size() - 1; i++) {
      prod = (list.get(i)) * ((total - list.get(i)));
      max = Math.max(prod, max);
    }

    return (int) (max % mod);
  }

  public long postOrder(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // fetch the left subtree sum
    long leftChild = postOrder(root.left);
    // fetch the right subtree sum
    long rightChild = postOrder(root.right);
    long curSum = leftChild + rightChild + root.val;
    // record the current subtree sum
    list.add(curSum);
    return curSum;

  }
}