// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// Example 2:
// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.

// Example 3:
// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.

//naive soln
const hasCycle2 = function(head) {
  //Edge case
  if(!head) return null;
  
  let currNode = head;
  const seenNode= new Set();
  
  while(!seenNode.has(currNode)) {
      if(currNode.next === null) return null;
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
  if(!head) return null;

  let fast = head, slow = head;
  while(true) {
    fast = fast.next;
    slow = slow.next;
    if(fast === null || fast.next === null) return null;
    else fast = fast.next;

    if(slow === fast) break;
  }
  
  let p1 = head, p2 = slow;
  while(p1 !== p2 ) {
      p1 = p1.next;
      p2 = p2.next;
  }
  return p1;
};
//T: O(n)
//S: O(1)