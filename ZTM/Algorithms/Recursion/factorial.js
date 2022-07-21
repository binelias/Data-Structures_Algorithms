// Write two functions that finds the factorial of any number. One should use recursive, the other should just use a for loop
//Given a number, we have to return its factorial.
//For example, factorial(5) should return 5! = 5*4*3*2*1 = 120
//We can solve this recursively, or iteratively.
//First we are going to solve it iteratively.

function findFactorialIterative(number) {//O(n)
  let answer = 1;
  for (let i = 2; i <= number; i++) {
    answer = answer * i;
  }
  return answer;
}

function findFactorialRecursive(number) {//O(n)
  if(number === 2) {
    return 2;
  }else if (number<2) {
    return number;
  }
  return number * findFactorialRecursive(number - 1)
}

findFactorialIterative(5);//120
findFactorialRecursive(5);//120
