// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

// Example 1:
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

// Example 2:
// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.

class Solution {
  public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
      if(k == 0) {
          combs.add(new ArrayList<Integer>(comb));
          return;
      }
      for(int i = start; i <= n; i++) {
          comb.add(i);
          combine(combs, comb, i + 1, n, k - 1);
          comb.remove(comb.size() - 1);
      }
  }
  
  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> combs = new ArrayList<List<Integer>>();
      combine(combs, new ArrayList<Integer>(), 1, n, k);
      return combs;
  }
}
