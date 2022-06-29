//using array in stacks
class Stack2 {
  constructor(){
    this.array = [];
  }
  peek() {
    return console.log(this.array[this.array.length-1]);
  }
  push(value){
    this.array.push(value);
    return console.log(this);
  }
  pop(){
    this.array.pop();
    return console.log(this);
  }
}

const mystack2 = new Stack2();
mystack2.peek();// undefined
mystack2.push('google');// Stack { array: [ 'google' ] }
mystack2.push('udemy');// Stack { array: [ 'google', 'udemy' ] }
mystack2.push('discord');// Stack { array: [ 'google', 'udemy', 'discord' ] }
mystack2.peek();//discord
mystack2.pop();// Stack { array: [ 'google', 'udemy' ] }
mystack2.pop();// Stack { array: [ 'google' ] }
mystack2.pop();// Stack { array: [] }

//Using both linked list and array in stacks
class Node {
  constructor(value){
    this.value = value;
    this.next = null;
  }
}

class Stack3 {
  constructor(){
    this.top = null;
    this.bottom = null;
    this.length = 0;
    this.array = [];
  }
  peek() {
    //return console.log(this);
    return console.log(this.array[this.array.length-1]);
  }
  push(value){
    const newNode = new Node(value);
    if (this.length === 0) {
      this.top = newNode;//google
      this.bottom = newNode;//google
      this.array.push(value);
    } else {
      const holdingPointer = this.top;//google
      this.top = newNode;//udemy
      this.array.push(value);//udemy index1
      this.top.next = holdingPointer;//udemy points to google
    }
    this.length++;
    //return console.log(this);
    return console.log(this.array);
  }
  pop(){
    if (!this.top) {//check if there's a value in stack
      return null;
    }
    if (this.top === this.bottom) {//one item in the list
      this.bottom = null;
    }
    // const holdingPointer = this.top;//incase you need discord
    this.top = this.top.next;
    this.length--;
    this.array.pop();
    //return console.log(this);
    return console.log(this.array);
  }
}

const mystack3 = new Stack3();
mystack3.peek();//undefined
mystack3.push('google');//[ 'google' ]
mystack3.push('udemy');//[ 'google', 'udemy' ]
mystack3.push('discord');//[ 'google', 'udemy', 'discord' ]
mystack3.peek();//discord
mystack3.pop();//[ 'google', 'udemy' ]
mystack3.pop();//[ 'google' ]
mystack3.pop();//[]
