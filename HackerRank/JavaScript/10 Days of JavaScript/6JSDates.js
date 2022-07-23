// Sample Input 0
// 2
// 10/11/2009
// 11/10/2010

// Sample Output 0
// Sunday
// Wednesday

// Explanation 0
// The function is called for the following d=2dates:
//   The date 10/11/2009 was a Sunday, so we return Sunday.
//   The date 11/10/2010 was a Wednesday, so we return Wednesday.

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

// The days of the week are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
function getDayName(dateString) {
    // Write your code here
    let dayName = {weekday: 'long'};
    return new Date(dateString).toLocaleDateString('en-us', dayName);
}


function main() {
    const d = +(readLine());
    
    for (let i = 0; i < d; i++) {
        const date = readLine();
        
        console.log(getDayName(date));
    }
}