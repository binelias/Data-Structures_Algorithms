// Given a String,  det if it is almost a isValidPalindrome. A string is almost a palindrome if it becomes a palindrome by removin 1 letter Consider only alphanumeric characters and ignor case sensitivity

//Step1: constraints
// palindorome as almost palindrome? yes

// Step2: cases
// abccdba -> abccba so true
// raceacar -> racacar so true
// abcdefdba -> abdefdba so false
// "" true
// "a" true
// "ab" true

//2 pointers from outside
const validSubPalindrome = function(s, left, right) {
  while(left < right) {
    if(s[left] !== s[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
};

const isAlmostPalindrome = function(s) {
  // initialize left/right pointers at start and end of string respectively
  let left = 0; right = s.length - 1;
  
  // loop through string characters while comparing them, then move the pointers closer to the center
  while(left < right) {
    if(s[left] !== s[right]) {
      return validSubPalindrome(s, left+1, right) || validSubPalindrome(s, left, right-1);
    }
    left++;
    right--;
  }
  return true;
};