'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'gameOfStones' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER n as parameter.
 */

function gameOfStones(n) {
    // Write your code here
    var ar = Array(n);

    ar[1] = 0,
    ar[2] = 1,
    ar[3] = 1,
    ar[4] = 1,
    ar[5] = 1,
    ar[6] = 1;

    for(let i=7; i<=n; i++){
        if (ar[i-2] && ar[i-3] && ar[i-5]) ar[i] = 0;
        else ar[i] = 1;
        }
    return ar[n] ? 'First' : 'Second';
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const t = parseInt(readLine().trim(), 10);

    for (let tItr = 0; tItr < t; tItr++) {
        const n = parseInt(readLine().trim(), 10);

        const result = gameOfStones(n);

        ws.write(result + '\n');
    }

    ws.end();
}

