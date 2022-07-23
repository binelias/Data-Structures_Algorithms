// Sample Input 0
// 5
// 1 2 3 4 5

// Sample Output 0
// 3 4 9 8 15

// Explanation 0
// Given nums= [1,2,3,4,5], we modify each element so that all even elements are multiplied by 2 and all odd elements are multipled by 3. In other words, [1,2,3,4,5] => [1*3. 2*2, 3*3, 4*2, 5*3] = > [3,4,9,8,15]. We then return the modified array as our answer.


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
 * Modify and return the array so that all even elements are doubled and all odd elements are tripled.
 * 
 * Parameter(s):
 * nums: An array of numbers.
 */
function modifyArray(nums) {
    return nums.reduce((target, num) => {
        target.push(
            num % 2 === 0
                ? num * 2
                : num * 3
        );
        return target;
    },[])
}


function main() {
    const n = +(readLine());
    const a = readLine().split(' ').map(Number);
    
    console.log(modifyArray(a).toString().split(',').join(' '));
}