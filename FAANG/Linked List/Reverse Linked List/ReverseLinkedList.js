// Example 1
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2
// Input: head = [1,2]
// Output: [2,1]

// Example 3:
// Input: head = []
// Output: []

const reverseList = function(head) {
  let prev = null;
  let curr = head;
  while(curr) {
      let next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
  }
  return prev;
};

//T: O(n)
//S: O(1)