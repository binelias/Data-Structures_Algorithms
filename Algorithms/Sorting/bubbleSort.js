const numbers = [99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0];

function bubbleSort(array) {//O(n^2)
  const length = array.length;
  for (let i = 0; i < length; i++) {//loop from 99 to 0
    for (let j = 0; j < length; j++) {//loop 99 with 44 and so on.....
      if(array[j] > array[j+1]) {//if i1 is >i2...
        //Swap the numbers
        let temp = array[j]
        array[j] = array[j+1];
        array[j+1] = temp;
      }
    }        
  }
}

bubbleSort(numbers);
console.log(numbers);