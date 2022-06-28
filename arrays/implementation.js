//Here, we will implement our own array with some common methods such as access, push, pop, insert, delete

class MyArray() {
  constructor() {
    this.length = 0;//We initialize the array's length to be zero
    this.data = {};//We initialize the data of the array using an empty dictionary. The keys will correspond to the index and the values to the data
  } 

  get(index) {
    return this.data[index]//This method takes in the index of the element as a parameter and returns the corresponding element in O(1) time.
  }

  push(item) {
    this.data[this.length] = item;
    this.length++;
    return this.length;//Adds the item provided to the end of the array
  }
  pop() {
    const lastItem = this.data[this.length - 1]; //Collects the last element
    delete this.data[this.length - 1];//Deletes the last element from the array
    this.length--;//Decrements the length attribute of the array by 1
    return lastItem;//Returns the popped element. O(1) time
  }
  delete(index) {
    const item = this.data[index];
    this.shiftItems(index);
    return item;
    
  }
  shiftItems(index) {
    for (let i = index; i < this.length - 1; i++) {
      this.data[i] = this.data[i + 1];//Shifts elements from the given index by one place towards righy
    }
    delete this.data[this.length - 1];//The last element which remains two times in the array is deleted
    this.length--;//The length is decremented by 1. O(n) operation
  }
}

const newArray = new MyArray();
newArray.push('hi');
newArray.push('you');
newArray.push('!');
newArray.pop();
newArray.pop();
console.log(newArray);//MyArray { length: 1, data: { '0': 'hi' } }



const newArray1 = new MyArray();
newArray1.push('hi');
newArray1.push('you');
newArray1.push('!');
newArray1.delete(1);
console.log(newArray1);//MyArray { length: 1, data: { '0': 'hi', 1: '!' } }



  




