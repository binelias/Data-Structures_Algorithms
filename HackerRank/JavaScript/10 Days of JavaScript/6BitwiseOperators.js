// Sample Input 0
// 3
// 5 2
// 8 5
// 2 2

// Sample Output 0
// 1
// 4
// 0

// Explanation 0
// a&b<k
// q=3
// n=5
// k=2

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
function getMaxLessThanK(n, k) {
    let max = 0;

    for (let a = 1; a < n; a++) {
        for (let b = a + 1; b <= n; b++) {
            let bitwiseAnd = a & b;
            (bitwiseAnd < k && max < bitwiseAnd) && (max = bitwiseAnd)
        }
    }

    return max;
}

function main() {
    const q = +(readLine());
    
    for (let i = 0; i < q; i++) {
        const [n, k] = readLine().split(' ').map(Number);
        
        console.log(getMaxLessThanK(n, k));
    }
}