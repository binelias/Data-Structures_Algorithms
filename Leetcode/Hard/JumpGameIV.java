// Given an array of integers arr, you are initially positioned at the first index of the array.

// In one step you can jump from index i to index:

// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.

// Example 1:

// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
// Example 2:

// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You do not need to jump.
// Example 3:

// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

class Solution {
  public int minJumps(int[] arr) {
    // creating variable
    int n = arr.length;
    if (n == 1)
      return 0; // base case

    // craeted map holding integer & list
    Map<Integer, List<Integer>> map = new HashMap<>();
    int step = 0; // intial step is 0

    // Our 1st job is "fill the map"
    for (int i = 0; i < n; i++) {
      // so, using this function it will check is arr[i] is present or not, if it's
      // not present it would create a new arraylist
      // and if it's already present we will add index in it
      map.computeIfAbsent(arr[i], v -> new ArrayList()).add(i);
    }

    // next we need a queue.
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);// in queue we will add our 1st index which is 0;

    while (!q.isEmpty()) { // looping until queue is not empty
      step++; // incrementing our step
      int size = q.size(); // taking queue size
      for (int i = 0; i < size; i++) { // now for each element in this queue for this particulart size running a loop
        // so, here we will perform 3 steps
        int j = q.poll(); // getting element from queue

        // Jump to j - 1
        if (j - 1 >= 0 && map.containsKey(arr[j - 1])) {
          q.offer(j - 1);
        }

        // Jump to j + 1
        if (j + 1 < n && map.containsKey(arr[j + 1])) {
          // there could be 2 conditions
          if (j + 1 == n - 1)
            return step; // if j+1 is equals to last element
          q.offer(j + 1); // otherwise add in queue
        }

        // Jump to k --> arr[j] == arr[k]
        if (map.containsKey(arr[j])) { // if this particular element hasn't processed
          for (int k : map.get(arr[j])) { // so, we will iterate over each k
            if (k != j) { // in this we first check if they are not equal, positions are not same
              if (k == n - 1)
                return step;
              q.offer(k);
            }
          }
        }
        map.remove(arr[j]); // removing from map
      }
    }

    return step;
  }
}