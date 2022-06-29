//Stacks are linear data-structures which can be implemented using either stacks or linked lists
//Insertion and deletion of elements in a stack take place from one end only.
//Stacks follow the LIFO rule - Last In First Out, where the last element that is inserted, is the first element that comes out.
//The main operations that can be performed on a stack , with their time complexities are as follows:
//Push (Insert) - O(1)
//Pop (Remove) - O(1)
//Peek (Retrieve the top element) - O(1)

//Here we'll implement a stack using linked lists

//Linked Lists are made of nodes. So we create a node class.
//It will contain the data and the pointer to the next node.

class Node {
  constructor(value){
    this.value = value;
    this.next = null;
  }
}


//Now we create the Stack class
//It will consist of a constructor having the top pointer, i.e., the pointer which points to the top element of the stack at any given time
//The length variable which keeps track of the length of the stack, and a bottom pointer which points to bottom most element of the stack
//After this will come the methods associated with a stack
class Stack {
  constructor(){
  this.top = null;
  this.bottom = null;
  this.length = 0;
  }

  //The peek method will allow us to peek at the top element,i.e
  //It will return the element at the top of the stack without removing it from the stack.
  //Since for this we only need to see what the top pointer points at, the time complexity will be O(1)
  peek() {
    return this.top;
  }

  //Next comes the push operation, where we insert an element at the top of the stack
  //Again this only requires access to the top pointer and inl=volves no looping.
  //So time complexity is O(1)
  push(value){
    const newNode = new Node(value);
    if (this.length === 0) {//If the stack is empty, we make the top and bottom pointer both point to the new node
      this.top = newNode;
      this.bottom = newNode;
    } else {//Otherwise, we make the next of the new node, which was pointing to None, point to the present top and then update the top pointer
      const holdingPointer = this.top;
      this.top = newNode;
      this.top.next = holdingPointer;
    }
    this.length++;
    return this;
  } 

  //Next comes the pop operation wehere we remove the top element from the stack
  //Its time complexity is O(1) as well   
  pop(){
    if (!this.top) {//If the stack is empty, we print an appropriate message
      return null;
    }else if (this.top === this.bottom) {
      this.bottom = null;//We make the bottom pointer None if there was only 1 element in the stack and that gets popped
    }
    //Else we make the top pointer point to the next of the top pointer and decrease the length by 1, effectively deleting the top element.
    const holdingPointer = this.top;
    this.top = this.top.next;
    this.length--;
    return this;
  }
  //Finally we'll implement a print method which prints the elements of the stack from top to bottom
  //This will be an O(n) operation as we'll obviously have to traverse the entire linked list to print all elelments
}



const mystack = new Stack();
mystack.peek();
mystack.push('google');
mystack.push('udemy');
mystack.push('discord');
mystack.peek();
mystack.pop();
mystack.pop();
mystack.pop();




