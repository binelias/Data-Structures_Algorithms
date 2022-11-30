// number of occurrences of each value in the array is unique, or false otherwise.

// Example 1:

// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
// Example 2:

// Input: arr = [1,2]
// Output: false
// Example 3:

// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true

// HashMap&HashSet Intuition If we have the frequencies of all elements,we can put them in a hash set.If the size of the hash set is equal to the number of elements,it implies that the frequencies are unique.Hence,we will find the frequencies of all elements in a hash map and then put them in a hash set.

// Algorithm Store the frequencies of elements in the array arr in the hash map freq.Iterate over the hash map freq and insert the frequencies of all unique elements of array arr in the hash set freqSet.Return true if the size of hash set freqSet is equal to the size of hash map freq,otherwise return false.

class Solution {
  public boolean uniqueOccurrences(int[] arr) {
      // Store the frequency of elements in the unordered map.
      Map<Integer, Integer> freq = new HashMap<>();
      for (int num : arr) {
          freq.put(num, freq.getOrDefault(num, 0) + 1);
      }
      
      // Store the frequency count of elements in the unordered set.
      Set<Integer> freqSet = new HashSet<>(freq.values());
      
      // If the set size is equal to the map size, 
      // It implies frequency counts are unique.
      return freq.size() == freqSet.size();
  }
}//T: O(n), S: O(n)