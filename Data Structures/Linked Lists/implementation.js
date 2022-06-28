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


//First we define a class Node which will act as a blueprint for each of our nodes


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
myLinkedList.append(16);



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
    console.log(newNode)
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
myLinkedList.prepend(1);










