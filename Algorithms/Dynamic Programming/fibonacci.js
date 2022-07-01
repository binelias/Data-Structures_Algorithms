//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233...
//recursion
let calculations = 0;
function fibonacci(n) { //O(2^n)
  if (n < 2) {
    return n
  }
  return fibonacci(n-1) + fibonacci(n-2);
}

//recursion with memoization
function fibonacciMaster() { //O(n)
  let cache = {};
  return function fib(n) {//closure tech to lessen global var
    calculations++;
    if (n in cache) {
      return cache[n];
    } else {
      if (n < 2) {
        return n;
      } else {
        cache[n] = fib(n-1) + fib(n-2);
        return cache[n];
      }
    }
  }
}

//iteration DP bottom up approach
function fibonacciMaster2(n) {//O(n)
  let answer = [0,1];
  if(n === 0) {
    return n;
  } else {
    for ( let i = 2; i <= n; i++) {
      answer.push(answer[i-2]+ answer[i-1]);
    }
    return answer.pop();
  }
  
}

const fasterFib = fibonacciMaster();

console.log('Slow', fibonacci(10));//177 times
console.log('DP', fasterFib(10));//19 times
console.log('DP2', fibonacciMaster2(10));//9 times
console.log('we did ' + calculations + ' calculations');

