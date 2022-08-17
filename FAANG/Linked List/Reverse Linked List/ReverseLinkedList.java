// Example 1
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2
// Input: head = [1,2]
// Output: [2,1]

// Example 3:
// Input: head = []
// Output: []

package FAANG.Linked List;
import java.util.*;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr!=null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
  }
}
//T: O(n)
//S: O(1)
