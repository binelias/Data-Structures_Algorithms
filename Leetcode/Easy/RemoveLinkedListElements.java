// 

// Approach 1: Iterative Solution without using a Previous Pointer

// In this solution, we create a dummy node and set dummy.next = head. This node helps us keep track of the new head in case the existing head has to be removed.
// Since we are not using a previous pointer, we will set the current (cur) node to the dummy node.
// The list on the left side, including the cur node, has been solved. We now need to solve the list on the right side of the cur node.

// We will check the following two conditions while iterating over the list:

// If cur.next.val == val, then we will remove the cur.next node by setting cur.next = cur.next.next. Please note, we will not move the current pointer in this step as new cur.next has not be validated yet.
// If cur.next.val != val, then we can safely move the cur pointer to next node, as next node is a valid node. cur = cur.next.
// Time Complexity: O(N) --> Each Node in the list is visited once.
// Space Complexity: O(1) --> Contant space is used for this solution
// Where, N = Length of the input list.

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
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode cur = dummy;

    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
        // Here cannot move cur to cur.next as we need to validate the next node.
      } else {
        cur = cur.next;
      }
    }

    return dummy.next;
  }
}

// Approach 2: Iterative Solution using a Previous Pointer

// Same as in the previous solution, we create a dummy node and set dummy.next =
// head. This node helps us keep track of the new head in case the existing head
// has to be removed.
// We will initialize, prev node to dummy node and cur node to head node.
// The list on the left side, including the prev node, has been solved. We now
// need to solve the list starting from the cur node.

// We will check the following two conditions while iterating over the list:

// If cur.val == val, then we will remove the cur node by setting prev.next =
// cur.next.
// If cur.val != val, then we can safely move the prev pointer to cur node, as
// cur node is a valid node. prev = cur.
// Time Complexity: O(N) --> Each Node in the list is visited once.
// Space Complexity: O(1) --> Contant space is used for this solution
// Where, N = Length of the input list.

class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode cur = head;
    ListNode prev = dummy;

    while (cur != null) {
      if (cur.val == val) {
        prev.next = cur.next;
      } else {
        prev = cur;
      }
      cur = cur.next;
    }

    return dummy.next;
  }
}

// Approach 3: Recursive Solution

// In this solution, removeElements function returns the head of the solved list
// (nodes with val are removed).
// Once we get the solved rightSideHead from the recursion call, rightSideHead
// node will point to the solved list.
// Now, we have two choices:

// If head.val == val --> Current node needs to be removed, so return the
// rightSideHead as it points to the solved rigth side list.
// If head.val != val --> Update the next pointer of current list, as the next
// node might have been removed. And then return the current node.
// Time Complexity: O(N) --> Each Node in the list is visited once.
// Space Complexity: O(N) --> Recursion Stack space
// Where, N = Length of the input list.

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
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    // Once removeElements call is done, right side of the list is solved.
    ListNode rightSideHead = removeElements(head.next, val);
    if (head.val == val) {
      return rightSideHead;
    }
    head.next = rightSideHead;
    return head;
  }
}