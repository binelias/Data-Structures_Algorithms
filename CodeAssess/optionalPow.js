//Write a function optionalPow that will receive two numeric arguments. The function is require to create some confirmation logic, where if the user agrees with the question(presses OK), then the function is required to compute the result of raising the first argument to the power determined by the second argument. if the user does not agree with the question(pressess Cancel), then it should compute the power of the second argument raised to the first one. In both cases, the function must return the computed value.

//optionalPow(2,3) return 8 if pressed OK
//optionalPow(2,3) return 9 if pressed Cancel

//both arguments range [-50, 50]

function optionalPow(a,b) {
  if (confirm('Are you sure?')) {
    console.log(Math.pow(a,b));
  } else {
    console.log(Math.pow(b,a));
  }
}
