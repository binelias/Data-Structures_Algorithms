// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

// Constraints:
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

// Follow up: Could you do it in O(n) time and O(1) space?

// Reverse without a copy
// What if we could mark the middle point of the list, and then reverse only the second half.

// But how do we find the middle point? let's use slow and fast pointers

// The fast pointer goes twice the speed of the slow pointer, whenever fast passes the whole list, the slow is located in the middle (left skewed for even length lists).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  // Floyd's Cycle Detection Algorithm
  public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head, prev, temp;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    prev = slow;
    slow = slow.next;
    prev.next = null;
    while (slow != null) {
      temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }
    fast = head;
    slow = prev;
    while (slow != null) {
      if (fast.val != slow.val)
        return false;
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }
}