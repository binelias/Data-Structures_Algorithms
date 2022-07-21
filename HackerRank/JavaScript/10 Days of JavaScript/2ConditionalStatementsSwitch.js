// Sample Input 0
// adfgt

// Sample Output 0
// A

// Explanation 0

// The first character of string s = adfgt is a. Because the given criteria stipulate that we print A any time the first character is in {a,e,i,o,u} , we return A as our answer.

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

function getLetter(s) {
  let letter;
  // Write your code here
  switch (s[0]) {
    case ('a' || 'e' || 'o' || 'i' || 'u'):
      letter = 'A';
      break;

    case ('b' || 'c' || 'd' || 'f' || 'g'):
      letter = 'B';
      break;

    case ('h' || 'j' || 'k' || 'l' || 'm'):
      letter = 'C';
      break;

    case ('z' || 'n' || 'p' || 'q' || 'r' || 's' || 't' || 'v' || 'w' || 'x' || 'y'):
      letter = 'D';

  }

  return letter;
}


function main() {
  const s = readLine();
  
  console.log(getLetter(s));
}