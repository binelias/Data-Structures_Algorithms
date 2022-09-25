// Given an integer n, return a string array answer (1-indexed) where:

// answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
// answer[i] == "Fizz" if i is divisible by 3.
// answer[i] == "Buzz" if i is divisible by 5.
// answer[i] == i (as a string) if none of the above conditions are true.

// Example 1:
// Input: n = 3
// Output: ["1","2","Fizz"]

// Example 2:
// Input: n = 5
// Output: ["1","2","Fizz","4","Buzz"]

// Example 3:
// Input: n = 15
// Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

// Constraints:
// 1 <= n <= 104

class Solution {
  public List<String> fizzBuzz(int n) {
      //Ans array list
      List<String> ans = new ArrayList<>();
      
      for(int num = 1; num <= n; num++) {
          boolean divBy3 = (num%3 == 0);
          boolean divBy5 = (num%5 == 0);
          
          if(divBy3 && divBy5) ans.add("FizzBuzz");
          else if(divBy3) ans.add("Fizz");
          else if(divBy5) ans.add("Buzz");
          else ans.add(Integer.toString(num));
      }
      return ans;
  }
}