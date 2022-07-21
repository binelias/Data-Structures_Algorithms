// Sample Input 0
// 2.6

// Sample Output 0
// 21.237166338267002
// 16.336281798666924

// Explanation 0
// Given the radius r = 2.6, we calculate the following:
  // area =pi* r^2 = 21.237166338267002
  // perimeter = 2*pi*r = 16.336281798666924 
// We then print  as our first line of output and  as our second line of output.

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

function main() {
  // Write your code here. Read input using 'readLine()' and print output using 'console.log()'.
  let r = parseFloat(readLine());
  let PI = Math.PI;
  // Print the area of the circle:
  console.log(PI * r * r);
  // Print the perimeter of the circle:
  return console.log(PI * 2 * r);
  try {    
      // Attempt to redefine the value of constant variable PI
      PI = 0;
      // Attempt to print the value of PI
      console.log(PI);
  } catch(error) {
      console.error("You correctly declared 'PI' as a constant.");
  }
}