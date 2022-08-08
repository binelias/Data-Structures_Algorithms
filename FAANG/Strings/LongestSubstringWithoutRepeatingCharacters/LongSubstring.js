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

