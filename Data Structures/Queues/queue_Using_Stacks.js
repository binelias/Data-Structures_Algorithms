//use stacks as queues
class CrazyQueue2 {
  constructor() {
    this.first = [];
    this.last = [];
  }

  enqueue(value) {
    const length = this.first.length;
    for (let i = 0; i < length; i++) {
      this.last.push(this.first.pop());
    }
    this.last.push(value);
    return console.log(this);
  }

  dequeue() {
    const length = this.last.length;
    for (let i = 0; i < length; i++) {
      this.first.push(this.last.pop());
    }
    this.first.pop();
    return console.log(this);
  }
  peek() {
    if (this.last.length > 0) {
      return console.log(this.last[0]);
    }
  }
}

const myQueue2 = new CrazyQueue2();
myQueue2.peek();// undefined
myQueue2.enqueue('Joy');// CrazyQueue2 { first: [], last: [ 'Joy' ] }
myQueue2.enqueue('Matt');// CrazyQueue2 { first: [], last: [ 'Joy', 'Matt' ] }
myQueue2.enqueue('Pavel');// CrazyQueue2 { first: [], last: [ 'Joy', 'Matt', 'Pavel' ] }
myQueue2.peek();//Joy
myQueue2.dequeue();// CrazyQueue2 { first: [ 'Pavel', 'Matt' ], last: [] }
myQueue2.dequeue();// CrazyQueue2 { first: [ 'Pavel' ], last: [] }
myQueue2.dequeue();//CrazyQueue2 { first: [], last: [] }
myQueue2.peek();// undefined








