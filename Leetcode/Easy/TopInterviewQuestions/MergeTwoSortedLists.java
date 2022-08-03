package Leetcode.Easy.TopInterviewQuestions;
import java.util.*;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //Base Case
    if(list1 == null) return list2;
    if(list2 == null) return list1;
    
    ListNode node = new ListNode(0);
    ListNode head = node;
    while(list1 != null || list2 != null){
        if(list2 == null || (list1 !=null && list1.val <= list2.val)) {
            head.next = list1;
            list1 = list1.next;
        }else {
            head.next = list2;
            list2 = list2.next;
        }
        head = head.next;
    } 
    return node.next;
  }
}
