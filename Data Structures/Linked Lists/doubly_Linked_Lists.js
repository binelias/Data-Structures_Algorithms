//Doubly linked lists are just normal, singly linked lists with one added feature,
//a link to the previous node as well in addition to a link to the next node.
//Although the worst case time complexities of all operations in a doubly linked list are same as that of a singly linked list,
//Some operations are technically faster. For example, lookup or searching, is O(n/2) as search can begin from both ends
//But O(n/2) = O(n), so it is still the same as that for a singly linked list.

//Implementation of doubly linked list is almost exactly the same as that for singly linked list,
//With just the added feature of the pointer to the previous node.
//So lets implement it.

class DoublyLinkedList {
  constructor(value) {
    this.head = {
      value: value,
      next: null,
      prev: null
    }
    this.tail = this.head;
    this.length = 1;
  }
  append(value) {
    const newNode = {
      value: value,
      next: null,
      prev: null
    }
    newNode.prev = this.tail;
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
    return this;
  }
  prepend(value) {
    const newNode = {
      value: value,
      next: null,
      prev: null
    }
    newNode.next = this.head;
    this.head.prev = newNode
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
      next: null,
      prev: null
    }
    const leader = this.traverseToIndex(index-1);//10
    const follower = leader.next;//5
    leader.next = newNode;//10 points to 99
    newNode.prev = leader;//99 prev 10
    newNode.next = follower;//99 points to 5
    follower.prev = newNode;//5 prev 99
    this.length++;
    return this.printList();
  }
  traverseToIndex(index) {
    let counter = 0;
    let currentNode = this.head;
    while(counter !== index){
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }
    remove(index) {    
    const leader = this.traverseToIndex(index-1);//10 as index1
    const unwantedNode = leader.next;//5 right of 10 
    leader.next = unwantedNode.next;//10 points to 5
    unwantedNode.prev = leader;//5 prev 10
    this.length--;
    return this.printList();
  }
}

let myLinkedList = new DoublyLinkedList(10);
myLinkedList.append(5)
myLinkedList.append(16)
myLinkedList.prepend(1)
myLinkedList.printList()// [ 1, 10, 5, 16 ]
myLinkedList.insert(2, 99)// [ 1, 10, 99, 5, 16 ]
myLinkedList.insert(20, 88)
myLinkedList.printList()// [ 1, 10, 99, 5, 16, 88 ]
myLinkedList.remove(2)// [ 1, 10, 5, 16, 88 ]




