//Queues are another form of linear data structure very similar to stacks.
//The difference is queues follow the FIFO rule - First In First Out, much like real life queues,
//Where the person gets in first, gets to leave first.
//Quesues can be implemented with both arrays and linked lists but the array implementation is not eficient
//Because for removing an element from the queues, which happens from the front of the array(queue),
//the indices of the array have to be updated every time, essentially making it an O(n) operation,
//Whereas the same operation can be done in O(1) time with linked lists.
//Queues have enqueue and dequeue operations which correspond to the push and pop operations of stacks , only difference being dequeue removes element from the front
//Time complexities are as follows:
//Peek - O(1)
//Enqueue - O(1)
//Dequeue - o(1)


//Like for stacks, we need a node class which will contain the data and a pointer to the next node
//linked lists as queues
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor(){
    this.first = null;
    this.last = null;
    this.length = 0;
  }
  peek() {
    return console.log(this.first);
  }
  enqueue(value){
    const newNode = new Node(value);
    if (this.length === 0) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;//joy points to matt
      this.last = newNode;//matt
    }
    this.length++;
    return console.log(this);
  }
  dequeue(){
    if (!this.first) {
      return null;
    }
    if (this.first === this.last) {//delete last one value
      this.last = null;
    }
    //const holdingPointer = this.first;//for undo
    this.first = this.first.next;//joy as first
    this.length--;
    return console.log(this);
  }
}

const myQueue = new Queue();
myQueue.peek();
myQueue.enqueue('Joy');
myQueue.enqueue('Matt');
myQueue.enqueue('Pavel');
myQueue.peek();
myQueue.dequeue();
myQueue.dequeue();
myQueue.dequeue();
myQueue.peek();

