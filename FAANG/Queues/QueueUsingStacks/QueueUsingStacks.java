// Example 1:
// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false

package FAANG.Queues.QueueUsingStacks;

class MyQueue {
  private int front;
  private Stack<Integer> s1 = new Stack<>();
  private Stack<Integer> s2 = new Stack<>();
  
  public MyQueue() {
      
  }
  
  public void push(int x) {
      if (s1.empty())
      front = x;
      s1.push(x);
  }
  
  public int pop() {
      if (s2.isEmpty()) {
          while (!s1.isEmpty()){
              s2.push(s1.pop());
          }
      }
      return s2.pop();  
  }
  
  public int peek() {
      if (!s2.isEmpty()) {
          return s2.peek();
      }
      return front;
  }
  
  public boolean empty() {
      return s1.isEmpty() && s2.isEmpty();
  }
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/
