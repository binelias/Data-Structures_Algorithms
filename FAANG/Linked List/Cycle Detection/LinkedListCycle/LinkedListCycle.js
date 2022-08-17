// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed)

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

//Naive soln
const hasCycle = function(head) {
  //Edge case
  if(!head) return false;
  
  let currNode = head;
  const seenNode= new Set();
  
  while(!seenNode.has(currNode)) {
      if(currNode.next === null) return false;
      seenNode.add(currNode);
      currNode = currNode.next;
  }
  return currNode;
};
//T: O(n)
//S: O(n)

//optimal soln
//floyd's turtle and hare algo
const hasCycle2 = function(head) {
  //Edge case
  if(!head) return false;
  
  let fast = head, slow = head;
  while(true) {
      fast = fast.next;
      slow = slow.next;
      if(fast === null || fast.next === null) return false;
      else fast = fast.next;

      if(slow === fast) break;
  }
  return true;
};
//T: O(n)
//S: O(1)


