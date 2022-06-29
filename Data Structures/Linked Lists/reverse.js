//Given a linked list we have to reverse it.

//It will take the linked list as an argument and return the reversed list.
//If the list is empty or consists of 1 item only we return the list as it is.
//Otherwise, we create two nodes first and second which point to the first/head and second nodes of the list respectively
//Then we update the tail of the list to point to the head as after reversing the present head will become the last node
//Then we run a loop until second becomes None

//Inside the loop we create a temporary node which points to the node beside second node
//Then we update the 'next' of the second node to point to the first node so that the link is now reversed (2nd node points to 1st node instead of 3rd).
//then switch first and second node and this two node will be treated as first node
//then third node will be treated as second node then next iteration starts again
//And this will go on till 'second' value becomes None and by then all the links will be reversed.
//Finally, we will update the 'next' of the original head value points to None as it is effectively located in the last node
//And then we will update the head to be equal to 'first', which by now points to the last node of the original list, and return the now reversed linked list
//Time complexity pretty clearly will be O(n)
class LinkedList4 {
  constructor(value) {
    this.head = {
      value: value,
      next: null
    };
    this.tail = this.head;
    this.length = 1;
  }
  append(value) {
    const newNode = {
      value: value,
      next: null
    }
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
    return this;
  }
  prepend(value) {
    const newNode = {
      value: value,
      next: null
    }
    newNode.next = this.head;
    this.head = newNode;
    this.length++;
    return this;
  }
  printList() {
    const array = [];
    let currentNode = this.head;
    while(currentNode !== null){
        array.push(currentNode.value)
        currentNode = currentNode.next
    }
    return console.log(array);
  }
  insert(index, value){
    //Check for proper parameters;
    if(index >= this.length) {
      return this.append(value);
    }else if(index === 0) {
      this.prepend(value);
    }
    
    const newNode = {
      value: value,
      next: null
    }
    const leader = this.traverseToIndex(index-1);//10
    const holdingPointer = leader.next;//5
    leader.next = newNode;//10 points to 99
    newNode.next = holdingPointer;//99 points to 5
    this.length++;
    return this.printList();
  }
  traverseToIndex(index) {
    //Check parameters
    let counter = 0;
    let currentNode = this.head;
    while(counter !== index){
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }
  remove(index) {
    // Check Parameters      
    const leader = this.traverseToIndex(index-1);//10 as index1
    const unwantedNode = leader.next;//5 right of 10 
    leader.next = unwantedNode.next;//10 points to 5
    this.length--;
    return this.printList();
  }
  reverse() {
    if (!this.head.next) {
      return this.head;
    }
    let first = this.head;//1
    let second = first.next;//10
    while(second) {//second has value then loop this
      const temp = second.next;//5
      second.next = first;//10 points to 1
      first = second;//1 switch w/ 10
      second = temp;//{10,1} as first then 5 as second
    }
    
    this.head.next = null;//1 index4
    this.head = first;//88 index0
    return this.printList()
  }
}
//[10,1,5,16,88]
//[5,10,1,16,88]
//[16,5,10,1,88]
//[88,16,5,10,1]
let myLinkedList4 = new LinkedList4(10);
myLinkedList4.append(5);
myLinkedList4.append(16);
myLinkedList4.prepend(1);
myLinkedList4.printList();// [ 1, 10, 5, 16 ]
myLinkedList4.insert(2, 99);// [ 1, 10, 99, 5, 16 ]
myLinkedList4.insert(20, 88);
myLinkedList4.printList();// [ 1, 10, 99, 5, 16, 88 ]
myLinkedList4.remove(2);//[ 1, 10, 5, 16, 88 ]
myLinkedList4.reverse();//[ 88, 16, 5, 10, 1 ]
