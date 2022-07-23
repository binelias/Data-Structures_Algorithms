// Sample Input 0
// 4
// 5

// Sample Output 0
// 4
// 5
// 18
// 20

// Explanation 0
// Given a length of a=4  and a width of b=5, the Rectangle objects  is 4+4+5+5=18 and its area is 4*5=20 is.


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
 * Complete the Rectangle function
 */
function Rectangle(a, b) {
    this.length = a,
    this.width = b,
    this.perimeter = 2*(a+b),
    this.area = a*b
}


function main() {
    const a = +(readLine());
    const b = +(readLine());
    
    const rec = new Rectangle(a, b);
    
    console.log(rec.length);
    console.log(rec.width);
    console.log(rec.perimeter);
    console.log(rec.area);
}