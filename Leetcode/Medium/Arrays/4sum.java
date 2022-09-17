// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]

class Solution {
  // Two Pointers
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }// T:O(n^3), S: O(n)

  public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();

    // if run out of nums to add then return res
    if (start == nums.length)
      return res;

    // There are k remaining val to add to sum, ave is at least target/k
    long ave_val = target / k;

    // cannot obtain sum of target if smallest val in nums is > than targer/k or if
    // largest val in nums is < than target/k
    if (nums[start] > ave_val || ave_val > nums[nums.length - 1])
      return res;

    if (k == 2)
      return twoSum(nums, target, start);

    for (int i = start; i < nums.length; ++i) {
      if (i == start || nums[i - 1] != nums[i]) {
        for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(subset);
        }
      }
    }
    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, long target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;

    while (lo < hi) {
      int currSum = nums[lo] + nums[hi];
      if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
        ++lo;
      } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
        --hi;
      } else {
        res.add(Arrays.asList(nums[lo++], nums[hi--]));
      }
    }

    return res;
  }
}

// Soln 2
// Intuition

// Since elements must sum up to the exact target value, we can also use the Two
// Sum: One-pass Hash Table approach.

// In 3Sum: Hash Set, we solved the problem without sorting the array. To do
// that, we needed to sort values within triplets, and track them in a hash set.
// Doing the same for k values could be impractical.

// So, for this approach, we will also sort the array and skip duplicates the
// same way as in the Two Pointers approach above. Thus, the code will only
// differ in the twoSum implementation.

// Algorithm

// twoSum implementation here is almost the same as in Two Sum: One-pass Hash
// Table. The only difference is the check to avoid duplicates. Since the array
// is sorted, we can just compare the found pair with the last one in the result
// res.
class Solution {
  // HashSet
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }

  public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();

    // If we have run out of numbers to add, return res.
    if (start == nums.length) {
      return res;
    }

    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    long average_value = target / k;

    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
      return res;
    }

    if (k == 2) {
      return twoSum(nums, target, start);
    }

    for (int i = start; i < nums.length; ++i) {
      if (i == start || nums[i - 1] != nums[i]) {
        for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(subset);
        }
      }
    }

    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, long target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Long> s = new HashSet<>();

    for (int i = start; i < nums.length; ++i) {
      if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
        if (s.contains(target - nums[i])) {
          res.add(Arrays.asList((int) target - nums[i], nums[i]));
        }
      }
      s.add((long) nums[i]);
    }

    return res;
  }// T: O(n^3), S: O(n)
}
