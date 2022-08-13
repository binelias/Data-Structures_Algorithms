// Sample Input
// 6
// 3
// 5
// 4
// 7
// 2
// 1

// Sample Output
// 3 2 5 1 4 7 

// Explanation
// The input forms the following binary search tree:
// We traverse each level of the tree from the root downward, and we process the nodes at each level from left to right. The resulting level-order traversal is 3 -> 2 -> 5 -> 1 -> 4 -> 7 , and we print these data values as a single line of space-separated integers.

import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

static void levelOrder(Node root){
      //Write your code here
      //Base Case
      if(root == null) return;
      
      ArrayDeque<Node> deque = new ArrayDeque<>();
      deque.add(root);
      while(!deque.isEmpty()) {
        Node n = deque.removeFirst();
        System.out.print(n.data +" ");
        if(n.left != null) deque.addLast(n.left);
        if(n.right != null) deque.addLast(n.right);
      }
      
    }

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
