// Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

// Example 1:

// Input: nums = [4,6,7,7]
// Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// Example 2:

// Input: nums = [4,4,3,2,1]
// Output: [[4,4]]

// Constraints:

// 1 <= nums.length <= 15
// -100 <= nums[i] <= 100

// Backtracking
// Intuition
// Whenever you have a problem where you need to check the subsequences/combinations/permutations of some group of letters/numbers, the first thought you should have is backtracking. If you are new to backtracking, check out our backtracking explore card. Backtracking algorithms can often keep the space complexity linear with the input size.

// There are not any tricks needed for this problem – the hard part is just figuring out how to generate all possible increasing subsequences, and to do this using a standard backtracking algorithm template.

// Example. nums=[1,5,2,4,8,5,4,7,9]nums = [1, 5, 2, 4, 8, 5, 4, 7, 9]nums=[1,5,2,4,8,5,4,7,9]. Consider the first 777 elements of the array numsnumsnums and the subsequence [1,2,4,4][1, 2, 4, 4][1,2,4,4]. Then we look at the next element nums[7]=7nums[7] = 7nums[7]=7. We have two options: either append this element to the sequence and obtain a new sequence [1,2,4,4,7][1, 2, 4, 4, 7][1,2,4,4,7] or skip it and proceed with the original sequence. By skipping it, at the next element, we can create a new subsequence [1,2,4,4,9][1, 2, 4, 4, 9][1,2,4,4,9]. By taking it, we can create [1,2,4,4,7,9][1, 2, 4, 4, 7, 9][1,2,4,4,7,9] as well, so we should try both options.

// And what if nums[7]nums[7]nums[7] is 333 instead of 777? Then we do not have an option to append because the sequence [1,2,4,4,3][1, 2, 4, 4, 3][1,2,4,4,3] is not increasing. In this case, we must skip the element.

// Each time we have two options: add the current element to the sequence (if it is possible) or not.

// Note that there might be duplicates among the found subsequences, and we do not want to include the same subsequence more than once. We can achieve this by maintaining them in a set.

// Algorithm
// The easiest way to implement this algorithm is to use recursion. Our algorithm will be as follows:

// Use a backtracking function backtrackbacktrackbacktrack to generate all possible subsequences.

// The function takes the (0-based) indexindexindex we are currently checking and the current increasing sequencesequencesequence.

// The base case is index=nums.lengthindex = nums.lengthindex=nums.length, i.e. we have run out of elements. If the length of the current subsequence is at least 222, add it to the answer.

// Otherwise, try to append nums[index]nums[index]nums[index] to the sequencesequencesequence if it remains increasing after this. If we appended the element, call backtrack(index+1)backtrack(index + 1)backtrack(index+1) recursively and delete nums[index]nums[index]nums[index] from the end of the sequencesequencesequence after that (backtrack). We should always recursively call backtrack(index+1)backtrack(index + 1)backtrack(index+1) without appending the element (the second option).

class Solution {
  private void backtrack(int[] nums, int index, List<Integer> sequence,
      Set<List<Integer>> result) {
    // if we have checked all elements
    if (index == nums.length) {
      if (sequence.size() >= 2) {
        result.add(new ArrayList<>(sequence));
      }
      return;
    }
    // if the sequence remains increasing after appending nums[index]
    if (sequence.isEmpty() ||
        sequence.get(sequence.size() - 1) <= nums[index]) {
      // append nums[index] to the sequence
      sequence.add(nums[index]);
      // call recursively
      backtrack(nums, index + 1, sequence, result);
      // delete nums[index] from the end of the sequence
      sequence.remove(sequence.size() - 1);
    }
    // call recursively not appending an element
    backtrack(nums, index + 1, sequence, result);
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();
    backtrack(nums, 0, sequence, result);
    return new ArrayList(result);
  }
}