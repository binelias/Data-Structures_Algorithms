// Sample Input 0
// 102, 1948948 and 1.3 and 4.5

// Sample Output 0
// 102
// 1948948
// 1
// 3
// 4
// 5

// Explanation 0
// When we call match on string s and pass the correct RegExp as our argument, it returns the following array of results: [ '102', '1948948', '1', '3', '4', '5' ].

// Sample Input 1
// 1 2 3

// Sample Output 1
// 1
// 2
// 3

// Explanation 1
// When we call match on string s and pass the correct RegExp as our argument, it returns the following array of results: [ '1', '2', '3' ].
// https://stackoverflow.com/questions/49209362/what-is-the-meaning-of-s-s-gm-in-javascript#:~:text=It%20is%20a%20regular%20expression.,t%20return%20after%20first%20match.

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

function regexVar() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match ALL occurrences of numbers in a string.
     */
    
    const re = new RegExp(/[0-9]+/gm);
    /*
     * Do not remove the return statement
     */
    return re;
}


function main() {
    const re = regexVar();
    const s = readLine();
    
    const r = s.match(re);
    
    for (const e of r) {
        console.log(e);
    }
}
