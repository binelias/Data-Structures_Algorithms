// Sample Input 0
// 3
// 1
// 2
// 3

// Sample Output 0
// YES
// YES
// YES

// Explanation 0
// Each of the given values is positive, so we return YES each time. The value returned during each function call is printed on a new line by locked stub code in the editor.

// Sample Input 1
// 3
// 2
// 0
// 6

// Sample Output 1
// YES
// Zero Error
// YES

// Explanation 1
// Locked stub code in the editor makes the following three calls to the isPositive function:
// 1. isPositive(2): This returns YES because 2 is positive.
// 2. isPositive(0): Because a = 0, we throw an Error with message =  Zero Error. This is caught by the locked stub code and the value of its message is printed.
// 3. isPositive(6): This returns YES because 6 is positive.

// Sample Input 2
// 2
// -1
// 20

// Sample Output 2
// Negative Error
// YES

// Explanation 2
// Locked stub code in the editor makes the following two calls to the isPositive function:
// 1. isPositive(-1): Because a = -1, we throw an Error with message = Negative Error. This is caught by the locked stub code and the value of its message is printed.
// 2. isPositive(20): This returns YES because 20 is positive


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
 * Complete the isPositive function.
 * If 'a' is positive, return "YES".
 * If 'a' is 0, throw an Error with the message "Zero Error"
 * If 'a' is negative, throw an Error with the message "Negative Error"
 */
function isPositive(a) {
    let positive = 'YES';

    if (a < 0) {
        throw ({ message: 'Negative Error' });
    }else if (a === 0) {
        throw ({ message: 'Zero Error' });
    }else {
        return positive;  
    }
    
}


function main() {
    const n = +(readLine());
    
    for (let i = 0; i < n; i++) {
        const a = +(readLine());
      
        try {
            console.log(isPositive(a));
        } catch (e) {
            console.log(e.message);
        }
    }
}