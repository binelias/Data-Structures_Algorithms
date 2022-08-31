// You are given an array of integers stones where stones[i] is the weight of the ith stone.

// We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

// If x == y, both stones are destroyed, and
// If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// At the end of the game, there is at most one stone left.

// Return the weight of the last remaining stone. If there are no stones left, return 0.

// Example 1:
// Input: stones = [2,7,4,1,8,1]

// Output: 1
// Explanation: 
// We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
// we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
// we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
// we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

// Example 2:
// Input: stones = [1]
// Output: 1
import java.util.*;

class Solution {
  // PriorityQueue (max head) solutions
  // The most efficient way to retrieve the max for large input sizes is to use a
  // max heap, which in Java is a PriorityQueue (min heap) with a reverse
  // comparator:
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : stones) {
      queue.add(i);
    }
    int x, y;
    while (queue.size() > 1) {
      y = queue.poll();
      x = queue.poll();
      if (y > x)
        queue.offer(y - x);
    }
    return queue.isEmpty() ? 0 : queue.poll();
  } // O(n log (n)) time O(n) space

  // Bucketsort
  // However, it is more accurate to say the time would be O(n + maxStoneWeight)
  // because we will build a bucket for every possible weight. And usually a O(n +
  // 1000) would be a great solution, but the test cases here have a very short
  // input size. the number of stones goes only from 0 to 30, so this solution
  // actually performs worse than O(n) since n is at most 30! O(30) == O(1030) but
  // 30 < 1030. Both have the same complexity, but the first runs faster, and you
  // might have not noticed why unless you check the inputs given in the tests.
  // BucketSort
  public int lastStoneWeight(int[] stones) {
    int[] buckets = new int[1001];
    for (int stone : stones) {
      buckets[stone]++;
    }
    int i = 1000, j;
    while (i > 0) {
      if (buckets[i] == 0)
        i--;
      else {
        buckets[i] = buckets[i] % 2;
        if (buckets[i] != 0) {
          j = i - 1;
          while (j > 0 && buckets[j] == 0) {
            j--;
          }
          if (j == 0)
            return i;
          buckets[i - j]++;
          buckets[j]--;
          i--;
        }
      }
    }
    return 0;
  }

  public int lastStoneWeight2(int[] stones) {
    Arrays.sort(stones);
    for (int i = stones.length - 1; i > 0; i--) {
      stones[i - 1] = stones[i] - stones[i - 1];
      Arrays.sort(stones);
    }
    return stones[0];
  }
}
