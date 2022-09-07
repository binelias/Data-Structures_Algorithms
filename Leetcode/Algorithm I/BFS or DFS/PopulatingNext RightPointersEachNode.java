// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.


// Example 1:
// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]
// Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

// Example 2:
// Input: root = []
// Output: []


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//BFS
class Solution {
  public Node connect(Node root) {
      //Corner Case
      if (root == null) return root;
      
      Queue<Node> curr = new LinkedList<>();
      Queue<Node> next = new LinkedList<>();
      curr.add(root);
      while(!curr.isEmpty()) {
          Node node = curr.poll();
          if(node != null && node.left != null) next.add(node.left);
          if(node != null && node.right != null) next.add(node.right);
          if(curr.isEmpty()) {
              if(node != null) node.next = null;
              curr = next;
              next = new LinkedList<Node>();
          }else {
              node.next = curr.peek();
          }   
      }
      return root;
  }
}
