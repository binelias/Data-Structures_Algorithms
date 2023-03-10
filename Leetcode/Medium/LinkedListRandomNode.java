// Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

// Implement the Solution class:

// Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
// int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 

// Example 1:


// Input
// ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
// [[[1, 2, 3]], [], [], [], [], []]
// Output
// [null, 1, 3, 2, 2, 3]

// Explanation
// Solution solution = new Solution([1, 2, 3]);
// solution.getRandom(); // return 1
// solution.getRandom(); // return 3
// solution.getRandom(); // return 2
// solution.getRandom(); // return 2
// solution.getRandom(); // return 3
// // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.

// Reservoir sampling and K == 1
// Reservoir sampling Wikipedia

// this is a conditional probability problem.

// The key point is before we process the N-th element, the probability of each previous N-1 element is equal to each other. This is very important.
// so after processing N-th element, the probability of each previous N-1 element is still equal to each other.
// At this time, the probability of N-th element is 1/N with no doubt, and the rest (1 - 1 / N) = (N - 1) / N will be shared equally by previous N - 1 elements, that is (1 - 1 / N) / (N - 1) = K(N - 1) / N / (N - 1) = 1 / N
// cost O(N) for getRandom every time
// You may wonder since the time complexity is still O(N), why do we have to spend so much.
// In the case of streaming data, we cannot traverse all the data to obtain the length, and then traverse the data again.

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
  int N = 0;
  ListNode head = null;
  
  public Solution(ListNode head) {
      this.head = head;
  }
  
  public int getRandom() {
      ListNode p = this.head;
      int i = 1, ans = 0;
      while (p != null) {
          if (Math.random() * i < 1) ans = p.val; // replace ans with i-th node.val with probability 1/i
          p = p.next;
          i ++;
      }
      return ans;
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(head);
* int param_1 = obj.getRandom();
*/