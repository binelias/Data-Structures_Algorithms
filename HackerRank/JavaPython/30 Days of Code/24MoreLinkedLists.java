// Sample Input
// 6
// 1
// 2
// 2
// 3
// 3
// 4

// Sample Output
// 1 2 3 4

// Explanation
// N = 6, and our non-decreasing list is {1,2,2,3,3,4}. The values 2 and 3 both occur twice in the list, so we remove the two duplicate nodes. We then return our updated (ascending) list, which is {1,2,3,4}.
import java.io.*;
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }

}

class Solution {

  public static Node removeDuplicates(Node head) {
    // Write your code here
    // Base Case
    if (head == null)
      return null;

    Node n = head;
    while (n.next != null) {
      if (n.data == n.next.data)
        n.next = n.next.next;
      else
        n = n.next;
    }
    return head;
  }

  public static Node insert(Node head, int data) {
    Node p = new Node(data);
    if (head == null)
      head = p;
    else if (head.next == null)
      head.next = p;
    else {
      Node start = head;
      while (start.next != null)
        start = start.next;
      start.next = p;

    }
    return head;
  }

  public static void display(Node head) {
    Node start = head;
    while (start != null) {
      System.out.print(start.data + " ");
      start = start.next;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Node head = null;
    int T = sc.nextInt();
    while (T-- > 0) {
      int ele = sc.nextInt();
      head = insert(head, ele);
    }
    head = removeDuplicates(head);
    display(head);

  }
}
