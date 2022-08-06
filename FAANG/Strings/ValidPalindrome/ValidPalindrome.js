// Palindrome
// - reads the same forwards and backwards

// Given a string, find the length of the longest substring w/out repeating char

// main problem: find lenght of longest unique substring

// subproblem: pattern matching - unique substring
// left pointer from beginning of string and right pointer from end of the string if string of the length is even 
// left and right pointer start from center of string moving from center to both end ifthe string of the length is odd

//3 diff soln
//start both from ends
// start both from center
// create 1 for and 1 back given string and compare


//Leetcode problem
// Given a string, determine if it is a palindrome, considering only alphanumeric char and ignoring case sensitivity

// Step1 verify the constraints

// step2 write out testcases
// odd length 
// even length
// fail case
// 1 char
// empty String
// sentence containing comma, colon and upper cases

//2 pointers from outside
const isValidPalindrome = function(s) {
  //remove none alphanumeric characters
  //regex expressions
  s = s.replace(/[^A-Z a-z 0-9]/g,"").toLowerCase();

  // initialize left/right pointers at start and end of string respectively
  let left = 0; right = s.length - 1;
  
  // loop through string characters while comparing them, then move the pointers closer to the center
  while(left < right) {
    if(s[left] !== s[right]) {
        return false
    }
    
    left++;
    right--;
  }
  return true;
};


//2 pointers from center
const isValidPalindrome2 = function(s) {
  s = s.replace(/[^A-Za-z0-9]/g, '').toLowerCase();
  
  // initialize left/right pointers to point at the middle index of the string. Remember, indexes start at 0 meaning that we have to floor() the value from dividing length by 2 in order to get the index of the center.
  let left = Math.floor(s.length / 2), right = left;
  
  // if the string is even, move left pointer back by 1 so left/right are pointing at the 2 middle values respectively.
  if(s.length % 2 === 0) {
      left--;
  }
  
  // loop through the string while expanding pointers outwards comparing the characters.
  while(left >= 0 && right < s.length) {
      if(s[left] !== s[right]) {
          return false
      }
      
      left--;
      right++;
  }
  
  return true;
};

// compare against reverse
const isValidPalindrome3 = function(s) {
  s = s.replace(/[^A-Za-z0-9]/g, '').toLowerCase();
  let rev = "";
  
  // generate a reverse string using a reverse for loop.
  for(let i = s.length - 1; i >= 0; i--) {
      rev += s[i];
  }

  return rev === s;
};
