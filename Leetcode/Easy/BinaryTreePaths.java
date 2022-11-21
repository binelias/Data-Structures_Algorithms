// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

// Example 1:

// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
// Example 2:

// Input: root = [1]
// Output: ["1"]

// Constraints:

// The number of nodes in the tree is in 

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

// dfs recursively
class Solution {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ret = new LinkedList<>();
    dfs(new Pair(root, ""), ret);
    return ret;
  }

  private void dfs(Pair<TreeNode, String> p, List<String> ret) {
    TreeNode n = p.getKey();
    String str = p.getValue();
    if (n != null) {
      if (n.left == null && n.right == null) {
        str += n.val;
        ret.add(str);
        // return;
      }
      dfs(new Pair(n.left, str + n.val + "->"), ret);
      dfs(new Pair(n.right, str + n.val + "->"), ret);
    }
  }
}

// dfs iteratively
class Solution {
  public List<String> binaryTreePaths2(TreeNode root) {
    Stack<Pair<TreeNode, String>> stack = new Stack<>();
    stack.push(new Pair(root, ""));
    List<String> ret = new ArrayList<>();
    while (!stack.isEmpty()) {
      Pair<TreeNode, String> p = stack.pop();
      TreeNode n = p.getKey();
      String str = p.getValue();
      if (n != null) {
        if (n.left == null && n.right == null) {
          str += Integer.toString(n.val);
          ret.add(str);
        }
        stack.push(new Pair(n.right, str + n.val + "->"));
        stack.push(new Pair(n.left, str + n.val + "->"));
      }
    }
    return ret;
  }

  public List<String> binaryTreePaths(TreeNode root) {
    Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
    queue.add(new Pair(root, ""));
    List<String> ret = new LinkedList<>();
    while (!queue.isEmpty()) {
      Pair<TreeNode, String> p = queue.poll();
      TreeNode n = p.getKey();
      String str = p.getValue();
      if (n != null) {
        if (n.left == null && n.right == null) {
          str += n.val;
          ret.add(str);
          // continue;
        }
        queue.add(new Pair(n.left, str + n.val + "->"));
        queue.add(new Pair(n.right, str + n.val + "->"));
      }
    }
    return ret;
  }
}