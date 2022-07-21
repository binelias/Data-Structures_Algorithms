// Sample Input 0

// javascriptloops

// Sample Output 0
// a
// a
// i
// o
// o
// j
// v
// s
// c
// r
// p
// t
// l
// p
// s


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

/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonants(s) {
  const Arr = [...s];
  let result = [];

  const newArr = Arr.reduce((target, item) => {
    switch(item) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
          target['vowel'].push(item);
          break;
      default:
        target['consonant'].push(item);
        break;
    }
    return target;
  }, {vowel:[], consonant:[]});
  result = [...newArr['vowel'], ...newArr['consonant']].map(item => console.log(item))
}


function main() {
    const s = readLine();
    
    vowelsAndConsonants(s);
}