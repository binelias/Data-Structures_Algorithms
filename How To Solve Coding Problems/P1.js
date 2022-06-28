// Write down the key points at the top
/* Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
For Example:
const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'i'];
should return false.
-----------
const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'x'];
should return true.
*/

// What are the inputs? What are the outputs? main goal(memory and speed)?
// Ans. 2 parameters - arrays - no size limit so speed is priority
// return true or false 

// Start with the naive/brute force approach. Tell them why this approach is not the best
// Before you start coding,walk through your code and write down the steps you are going to follow.add comments
// Ans. We can solve it by a nested loop where we're comparing a with Z and then a with Y then a with I and then we go to be with Z B with Y B with I and then so on and so forth so it is a Big O(a*b) so it's not the fastest sol'n

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'x'];

function containsCommonItem(arr1, arr2) {
  for(let i=0; i<arr1.length; i++) {
    for(let j=0; i<arr2.length;j++) {
      if(arr1[i] === arr2[j]) {
        return console.log('true');
      }  
    }
  }
  return console.log('false')
}
// containsCommonItem(array1,array2);
//O(a*b)

// Finally talk to the interviewer where you would improve the code. Does it work?
// array1 => obj {
//   a:true,
//   b:true,
//   b:true
// }
// array2[index] === obj.properties

function containsCommonItem2(arr1, arr2) {
  //loop through first array and create obejct where properties === items in the array
  let map = {};
  for (let i=0; i<arr1.length;i++) {
    if(!map[array1[i]]) {
      const item = array1[i];
      map[item] = true;
    }
  }
  // loop through second array and checkif itemin second array exists on created object
  for (let j=0; j<arr2.length;j++) {
    if(map[array2[j]]) {
      return console.log('true');
    }
  }
  return console.log('false');
  //2 loops so Big O becomes O(a+b)
}
// containsCommonItem2(array1,array2);

//False inputs scenario like no second array input
//testing parts
//don't use i and j
//make it JS readable

function containsCommonItem3(arr1,arr2) {
  if(arr1.some(item => arr2.includes(item))) {
    return console.log('True')
  }
  return console.log('False')
};

containsCommonItem3(array1,array2)


















































