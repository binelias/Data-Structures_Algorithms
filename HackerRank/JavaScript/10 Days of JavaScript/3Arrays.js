// Sample Input 0
// 5
// 2 3 6 6 5

// Sample Output 0
// 5

// Explanation 0
// Given the array nums= [2,3,6,6,5] , we see that the largest value in the array is 5 and the second largest value is 5. Thus, we return 5 as our answer.

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
  inputString += inputStdin;
});

process.stdin.on('end', _ => {
  inputString = inputString.trim().split('\n').map(string => {
    return string.trim();
  });
  
  main();    
});

function readLine() {
  return inputString[currentLine++];
}

/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
  // Complete the function
  const max = Math.max(...nums);
  nums = nums.filter(num => num !== max);
  return Math.max(...nums);
}


function main() {
  const n = +(readLine());
  const nums = readLine().split(' ').map(Number);
  
  console.log(getSecondLargest(nums));
}