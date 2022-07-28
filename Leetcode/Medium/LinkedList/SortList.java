package Leetcode.Medium.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;

class Solution {
  public ListNode sortList(ListNode head) {
      ArrayList<Integer> list = new ArrayList<>();
      ListNode extract =head;
      while(extract != null) {
        list.add(extract.val);
        extract=extract.next;
      }

      Collections.sort(list);
      ListNode current = head;
      int i = 0;
      while(current != null) {
        current.val = list.get(i);
        i++;
        current = current.next;
      }
      return head;
  }
}
