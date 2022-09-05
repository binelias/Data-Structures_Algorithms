// Given the head of a linked list, remove the nth node from the end of the list and return its head.


// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

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
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode start = new ListNode(0);
      start.next = head;
      ListNode slow = start, fast = start;
      
      //Move fast in front so that the gap between slow and fast becomes n
      for(int i=1; i <= n+1; i++) fast = fast.next;
      
      //Move fast to the end, maintaining the gap
      while(fast != null) {
          slow = slow.next;
          fast = fast.next;
      }
      
      //Skip the desired node
      slow.next = slow.next.next;
      return start.next;
  }
}