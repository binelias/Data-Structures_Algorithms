// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      
      if(root == null) return res;
      queue.add(root);

      while(!queue.isEmpty()) {
          List<Integer> currLvlVal = new ArrayList<>();
          int length = queue.size();

          for(int i = 0; i< length; i++) {
              TreeNode currNode = queue.remove();
              currLvlVal.add(currNode.val);

              if(currNode.left != null) queue.add(currNode.left);
              if(currNode.right != null) queue.add(currNode.right);
          }
          res.add(currLvlVal);
      }
      return res;
  }
}