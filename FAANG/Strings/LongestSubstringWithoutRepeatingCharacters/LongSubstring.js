// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. 

//Brute Force
const lengthOfLongestSubstring = function(s) {
  if(s.length <= 1) return s.length;
  
  let longest = 0;
  
  for(let left = 0; left < s.length; left++) {
    let seenChars = {}, currentLength = 0;

    for(let right = left; right < s.length; right++) {
      const currentChar = s[right];

      if(!seenChars[currentChar]) {
        currentLength++;
        seenChars[currentChar] = true;
        longest = Math.max(longest, currentLength);
      } else {
        break;
      }
    }
  }
  return longest;
};


//optimal soln
//use left and right pointer and hashmap using  key:currentchar and value:index
const lengthOfLongestSubstring2 = function(s) {
  //Base Case
  if(s.length <= 1) return s.length;
  //object
  const seenChar = {};
  let left = 0, longest = 0;

  for(let right = 0; right < s.length; right++) {
      const currentChar = s[right];
      const prevSeenChar = seenChar[currentChar];

      if(prevSeenChar >= left) {
        left = prevSeenChar + 1;
      }
      seenChar[currentChar] = right;
      longest = Math.max(longest, right-left + 1);  
  }
  return longest;
};//T: O(n), S: O(n);

//optimal soln
//use left and right pointer and hashmap using  key:currentchar and value:index
const lengthOfLongestSubstring3 = function(s) {
  //Base Case
  if(s.length <= 1) return s.length;
  //hashmap of char and index
  const seenChar =  new Map();
  let left = 0, longest = 0;

  for(let right = 0; right < s.length; right++) {
      const currentChar = s[right];
      const prevSeenChar = seenChar.get(currentChar);

      if(prevSeenChar >= left) {
        left = prevSeenChar + 1;
      }
      seenChar.set(currentChar, right);
      longest = Math.max(longest, right-left + 1);  
  }
  return longest;
};//T: O(n), S: O(n);
