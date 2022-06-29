//Linked lists are, as the name suggests, a list which is linked.
//It consists of nodes which contain data and a pointer to the next node in the list.
//The list is connected with the help of these pointers.
//These nodes are scattered in memory, quite like the buckets in a hash table.
//The node where the list starts is called the head of theblist and the node where it ends, or last node, is called the tail of the list.
//The average time complexity of some operations invloving linked lists are as follows:
//Look-up : O(n)
//Insert : O(n)
//Delete : O(n)
//Append : O(1)
//Prepend : O(1)
//JS doesn't have a built-in implementation of linked lists, we have to build it on our own
//So, here we go.
//Singly Linked Lists


// Create the below linked list:
// let myLinkedList = {
//   head: {
//     value: 10,
//     next: {
//       value: 5,
//       next: {
//         value: 16,
//         next: null
//       }
//     }
//   }
// };//10-->5-->16

// add a method append() to the linked list that adds a node to the end of the list
class LinkedList {
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
}

let myLinkedList = new LinkedList(10);
myLinkedList.append(5);
myLinkedList.append(16);//10-->5-->16



// add a method prepend() to the linked list that adds a node to the beginning of the list
class LinkedList2 {
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
}

let myLinkedList2 = new LinkedList2(10);
myLinkedList2.append(5);
myLinkedList2.append(16);
myLinkedList.prepend(1);//1-->10-->5-->16


// add a method insert() that insert in between head and tails to the linked list 
class LinkedList3 {
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
  printList() {//print all value in an array
    const array = [];
    let currentNode = this.head;
    while(currentNode !== null){
        array.push(currentNode.value)
        currentNode = currentNode.next
    }
    return console.log(array);
  }
  insert(index, value){
    if(index >= this.length) {
      return this.append(value);
    } else if(index === 0) {
      this.prepend(value);
      return this.printList();
    }
    
    const newNode = {
      value: value,
      next: null
    }
    const leader = this.traverseToIndex(index-1);
    const holdingPointer = leader.next;
    leader.next = newNode;
    newNode.next = holdingPointer;
    this.length++;
    return this.printList();
  }
  traverseToIndex(index) {
    //find the index
    let counter = 0;
    let currentNode = this.head;
    while(counter !== index){
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }
}

let myLinkedList3 = new LinkedList3(10);
myLinkedList3.append(5);
myLinkedList3.append(16);
myLinkedList3.prepend(1);
myLinkedList3.printList();// [ 1, 10, 5, 16 ]
myLinkedList3.insert(2, 99);// [ 1, 10, 99, 5, 16 ]
myLinkedList3.insert(20, 88);
myLinkedList3.printList();// [ 1, 10, 99, 5, 16, 88 ]


// add a method remove() to the linked list that deletes a node to the specified index.
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
}

let myLinkedList4 = new LinkedList4(10);
myLinkedList4.append(5);
myLinkedList4.append(16);
myLinkedList4.prepend(1);
myLinkedList4.printList();// [ 1, 10, 5, 16 ]
myLinkedList4.insert(2, 99);// [ 1, 10, 99, 5, 16 ]
myLinkedList4.insert(20, 88);
myLinkedList4.printList();// [ 1, 10, 99, 5, 16, 88 ]
myLinkedList4.remove(2);//[ 1, 10, 5, 16, 88 ]













