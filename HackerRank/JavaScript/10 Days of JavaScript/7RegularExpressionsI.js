// Sample Input 0
// bcd

// Sample Output 0
// false

// Explanation 0
// This string starts with (and ends in) a consonant, so it cannot start and end with the same vowel.

// Sample Input 1
// abcd

// Sample Output 1
// false

// Explanation 1
// This string ends in a consonant, so it cannot start and end with the same vowel.

// Sample Input 2
// abcda

// Sample Output 2
// true

// Explanation 2
// This string starts and ends with the same vowel (a).

// Sample Input 3
// abcdo

// Sample Output 3
// false

// Explanation 3
// This string starts with the vowel a but ends in the vowel o.

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
     * It must match a string that starts and ends with the same vowel (i.e., {a, e, i, o, u})
     */
    
    return new RegExp(/^([aeiou]).*\1$/);
    /*
     * Do not remove the return statement
     */
    return re;
}


function main() {
    const re = regexVar();
    const s = readLine();
    
    console.log(re.test(s));
}