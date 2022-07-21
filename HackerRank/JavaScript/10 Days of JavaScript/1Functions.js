// Sample Input 0
// 4

// Sample Output 0
// 24

// Explanation 0
// We return the value of 4! = 4x3x2x1 =24;

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
 * Create the function factorial here
 */
const factorial = (n) => (n - 1) > 0 ? n * factorial(n - 1) : 1;

function main() {
    const n = +(readLine());
    
    console.log(factorial(n));
}