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

const isValidPalindrome = function(s) {
  //remove none alphanumeric characters
  //regex expressions
  s = s.replace(/[^A-Z a-z 0-9]/g,"").toLowerCase();

}


