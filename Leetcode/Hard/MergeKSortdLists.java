// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []

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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0)
      return null;

    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    for (ListNode node : lists)
      if (node != null)
        queue.add(node);

    while (!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;

      if (tail.next != null)
        queue.add(tail.next);
    }
    return dummy.next;
  }
}