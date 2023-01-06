// It is a sweltering summer day, and a boy wants to buy some ice cream bars.

// At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

// Return the maximum number of ice cream bars the boy can buy with coins coins.

// Note: The boy can buy the ice cream bars in any order.

 

// Example 1:

// Input: costs = [1,3,2,4,1], coins = 7
// Output: 4
// Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.
// Example 2:

// Input: costs = [10,6,8,7,7,8], coins = 5
// Output: 0
// Explanation: The boy cannot afford any of the ice cream bars.
// Example 3:

// Input: costs = [1,6,3,1,2,5], coins = 20
// Output: 6
// Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 + 3 + 1 + 2 + 5 = 18.

// Constraints:

// costs.length == n
// 1 <= n <= 105
// 1 <= costs[i] <= 105
// 1 <= coins <= 108

// Approach: Counting Sort (Greedy)
// Intuition
// We can further optimize the previous approach by using counting sort.
// A comparison-based sorting method (like heapsort, mergesort, etc.) takes $(n \log n)$ time. However, using counting sort, we can access the elements in sorted order in linear time.

// Counting sort is a sorting technique that is based on the keys between specific ranges. We store each element's frequency in an array and thus using this new array we can access all elements in sorted order.
// As the input array's element's range is not very large, we can use counting sort here. If you are new to counting sort, then we recommend you take a look at it in our Sorting Explore Card.

// The idea behind counting sort is that in an additional array arrayFreq we store the frequency of each element of the input array where arrayFreq's index denotes the element of the input array. Thus, in an indirect way when the indices of arrayFreq are accessed in increasing order, we also access the element of the input array in sorted order. You can get a brief idea from the following image.

// counting_sort

// Thus, instead of using a comparison-based sorting method to sort the costs array, we can sort it using counting sort, then buy the cheapest ice creams in order.

// Algorithm
// Initialize variables:

// n, length of the input array.
// m, maximum cost in the costs array.
// icecreams, number of ice creams we picked.
// costsFrequency, to store the frequency of each cost from the costs array.
// Iterate over the costs array and store each element's frequency costsFrequency.

// Iterate over each cost from 1 to m.

// For each cost, if there are ice creams and we have enough coins, then count the maximum number of ice creams we can pick.
// Reduce the cost of those picked ice creams from our coins.
// Add the count of those picked ice creams in the icecreams variable.
// Return the number of ice creams we picked, i.e. the icecreams variable.


class Solution {
  public int maxIceCream(int[] costs, int coins) {
      int n = costs.length;
      int icecreams = 0;

      int m = costs[0];
      for (int cost : costs) {
          m = Math.max(m, cost);
      }

      int[] costsFrequency = new int[m + 1];
      for (int cost : costs) {
          costsFrequency[cost]++;
      }

      for (int cost = 1; cost <= m; ++cost) {
          // No ice cream is present costing 'cost'.
          if (costsFrequency[cost] == 0) {
              continue;
          }
          // We don't have enough 'coins' to even pick one ice cream.
          if (coins < cost) {
              break;
          }
          
          // Count how many icecreams of 'cost' we can pick with our 'coins'.
          // Either we can pick all ice creams of 'cost' or we will be limited by remaining 'coins'.
          int count = Math.min(costsFrequency[cost], coins / cost);
          // We reduce price of picked ice creams from our coins.
          coins -= cost * count;
          icecreams += count;
      }

      return icecreams;
  }
}