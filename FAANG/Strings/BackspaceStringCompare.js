// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Example 3:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

//Step1: contstraint
// "ab##"
// ""
// What happen to # when no char to remove?
// "a###b"
// "b"
// Are two empty strings as equal to each other?
// yes
// Does case sensitivity matter?
// yes, "a" does not equal "A"


//Step2: write some testCases
// s:"ab#z" t:"az#z" true
// s:"abc#d" t:"acc#c" false
// s:"x#y#z#" t:"a#" true
// s:"a###b" t:"b" true
// s:"Ab#z" t:"az#z" false

//Step3: soln draft
//   put in array list and pop when encounter #

//step4: code the soln
//Brute Force

const buildStr = function(str) {//O(n)
  const builtArr = [];
  for (let i = 0; i < str.length; i++) {
    if(str[i] !== '#') {
      builtArr.push(str[i]);
    }else {
      builtArr.pop();
    }
  }
  return builtArr;
}

let backspaceCompare = function(s, t) {
  const finalS = buildStr(s); //O(s)
  const finalT = buildStr(t); //O(t)
  if(finalS.length !== finalT.length) {
    return false;
  }else {
    for(let i = 0; i < finalS.length; i++) {//O(s+t)
      if(finalS[i] !== finalT[i]) {
        return false;
      }
    }
  }
  return true;
}; //t:O(n) s:O(s+t)

//Step5: can we optimize our soln

//Optimal soln
//using 2 pointers from moving char left to right technique
let backspaceCompare2 = function(s, t) {
  let p1 = s.length-1, p2 = t.length-1;
  while(p1>=0 || p2>=0) {
    if(s[p1]==='#' || t[p2]=== '#') {
      if(s[p1]==='#'){
        let backCount=2;
        while(backCount>0){
          p1--;
          backCount--;
          if(s[p1]==='#'){
            backCount+=2;
          }
        }
      }
      if(t[p2] === '#') {
        let backCount=2;
        while(backCount>0){
          p2--;
          backCount--;
          if(t[p2]==='#'){
            backCount+=2;
          }
        }
      }
    }else {
      if(s[p1] !== t[p2]){
        return false;
      }else {
        p1--;
        p2--;
      }
    }
  }
  return true;
}//t:O(s+t), s:O(n)