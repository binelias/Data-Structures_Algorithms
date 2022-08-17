// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]

const reverseBetween = function(head, left, right) {
  //BaseCase
  if(!head) return;
  
  let currPos = 1, currNode = head, start = head;
  //Traverse to start of reverse list start=left-1
  while(currPos < left) {
      start = currNode;
      currNode = currNode.next;
      currPos++;
  }
  
  //Start reversing
  let newList = null, tail = currNode;
  while(currPos >= left && currPos <= right) {
      let next = currNode.next;
      currNode.next = newList;
      newList = currNode;
      currNode= next;
      currPos++;
  }
  start.next = newList;
  tail.next = currNode;
  
  if(left > 1) return head;
  else return newList;
};
//T: O(n)
//S: O(1)