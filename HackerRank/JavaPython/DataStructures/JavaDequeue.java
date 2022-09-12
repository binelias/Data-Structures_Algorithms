// In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

// Sample Input
// 6 3
// 5 3 5 2 3 2

// Sample Output
// 3

// Explanation
// In the sample testcase, there are 4 subarrays of contiguous numbers.

// s1 ={5, 3, 5} - Has 2 unique numbers.

// s2 ={3, 5, 2} - Has 3 unique numbers.

// s3 ={5, 2, 3} - Has 3 unique numbers.

// s4 ={2, 3, 2} - Has 2 unique numbers.

// In these subarrays, there are 2,3,3,2 unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is 3.

import java.util.*;

// Why not use just a HashMap instead of both a HashMap and an ArrayDeque? 
// Well, an ArrayDeque helps keep the ordering of elements. Although the 
// elements are also in our HashMap, they is no ordering to the elements 
// in the HashMap since it's just a set.

public class test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Integer> deque = new ArrayDeque<>();
    int n = in.nextInt();
    int m = in.nextInt();
    int max = 0;

    for (int i = 0; i < n; i++) {
      int num = in.nextInt();
      if (i >= m) {
        int old = deque.removeFirst();
        if (map.get(old) == 1)
          map.remove(old);
        else
          map.merge(old, -1, Integer::sum);
      }
      // Add new value

      deque.addLast(num);
      map.merge(num, 1, Integer::sum);
      max = Math.max(max, map.size());

      // If all integer are unique, we have found our largest possible ans, so we can
      // break out of loop
      if (max == m)
        break;
    }
    in.close();
    System.out.println(max);
  }

}// T: O(n),S: O(n)
