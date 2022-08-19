package FAANG.Binary Trees.RightSideView;
import java.util.*;

class TreeNode { 
  int value; 
  Queue<TreeNode> queue = new ArrayDeque<>();

  TreeNode left;
  TreeNode right;
  
  TreeNode(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
  }
  
  @Override
  public String toString() {
      return "TreeNode{" +
              "value=" + value +
              ", left=" + left +
              ", right=" + right +
              '}';
  }
  
  public TreeNode insert(Integer[] values) {
      queue.add(this);
      int i = 0;
      while (queue.size() > 0) {
          TreeNode current = queue.poll();
          if (current.left == null) {
              if (values[i] != null) {
                  current.left = new TreeNode(values[i]);
              }
              i++;
              if (i >= values.length) return this;
          }
          if (current.left != null)
              queue.add((current.left));
          if (current.right == null) {
              if (values[i] != null) {
                  current.right = new TreeNode(values[i]);
              }
              i++;
              if (i >= values.length) return this;
          }
          if (current.right != null)
              queue.add((current.right));
  
      }
      return this;
  }
}
  
public class RightSideView { 
  public static void main(String[] args) { 
    TreeNode tree = new TreeNode(1); 
    Integer[] values = new Integer[]{2, 3, 4, 5, null, 6, null, 7, null, null, null, null, 8, null, null, null}; 
    tree.insert(values); 
    System.out.println(tree); 
    List result = rightSideViewBFS(tree); 
    System.out.println(result); 
  }
  
  public static List<Integer> rightSideViewBFS(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null)
          return result;
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
  
      while (queue.size() > 0) {
          int length = queue.size(), count = 0;
          TreeNode currentNode = null;
  
          while (count < length) {
              currentNode = queue.poll();
  
              if (currentNode.left != null) {
                  queue.add(currentNode.left);
              }
  
              if (currentNode.right != null) {
                  queue.add(currentNode.right);
              }
  
              count++;
          }
  
          result.add(currentNode.value);
      }
      return result;
  }

}
