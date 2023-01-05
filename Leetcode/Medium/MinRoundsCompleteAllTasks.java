// You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.

// Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

 

// Example 1:

// Input: tasks = [2,2,3,3,2,4,4,4,4,4]
// Output: 4
// Explanation: To complete all the tasks, a possible plan is:
// - In the first round, you complete 3 tasks of difficulty level 2. 
// - In the second round, you complete 2 tasks of difficulty level 3. 
// - In the third round, you complete 3 tasks of difficulty level 4. 
// - In the fourth round, you complete 2 tasks of difficulty level 4.  
// It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
// Example 2:

// Input: tasks = [2,3,3]
// Output: -1
// Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.

// Approach: Counting
// Intuition
// We are given NNN integers, we can group them with sizes of two or three. We need to find out if it's possible to group them and if we can what is the minimum number of groups needed.

// First, let's check when we won't be able to group the integers. Since the minimum size of the group is 222, we cannot cover the integer with frequency 111. To find the minimum number of groups for other integers, we can divide the integers into three groups:

// Integers that are multiples of 333 i.e., of the form 3∗K3*K3∗K.
// Integers that leaves remainder of 111 when divided by 333 i.e., of the form 3∗K+13 * K + 13∗K+1.
// Integers that leaves remainder of 222 when divided by 333 i.e., of the form 3∗K+23 * K + 23∗K+2.
// We need to represent each frequency in the form of 3x+2y3x + 2y3x+2y, where xxx is the number of groups with size 333 and yyy is the number of groups with size 222. The total number of groups needed is x+yx + yx+y, and we need to minimize the value of x+yx + yx+y. In order to minimize the value we need to maximize the value of xxx. Because the groups with size 333 would contribute more to make the total value equal to the frequency compared to the group of size 222.

// The below figure shows the general representation of the group division for the above three types of integers.

// fig

// Algorithm
// Iterate over the integers in the array tasks, and for each integer store the frequency in the map freq.

// Initialize the answer variable minimumRounds to 0.

// Iterate over the frequencies in the map freq and for each frequency count:

// If count is 1, then we should stop and return -1.
// Add count / 3 to the answer variable minimumRounds, if count is divisible by 333.
// Otherwise, add count / 3 + 1 to minimumRounds.
// Return minimumRounds.

class Solution {
  public int minimumRounds(int[] tasks) {
      Map<Integer, Integer> freq = new HashMap();
      // Store the frequencies in the map.
      for (int task : tasks) {
          freq.put(task, freq.getOrDefault(task, 0) + 1);
      }

      int minimumRounds = 0;
      // Iterate over the task's frequencies.
      for (int count : freq.values()) {
          // If the frequency is 1, it's not possible to complete tasks.
          if (count == 1) {
              return - 1;
          }

          if (count % 3 == 0) {
              // Group all the task in triplets.
              minimumRounds += count / 3;
          } else {
              // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
              // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
              minimumRounds += count / 3 + 1;
          }
      }

      return minimumRounds;
  }
}
