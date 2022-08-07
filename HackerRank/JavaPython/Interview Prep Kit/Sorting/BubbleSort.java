// Sample Input 0
// STDIN   Function
// -----   --------
// 3       a[] size n = 3
// 1 2 3   a = [1, 2, 3]

// Sample Output 0
// Array is sorted in 0 swaps.
// First Element: 1
// Last Element: 3

// Explanation 0
// The array is already sorted, so 0 swaps take place.

// Sample Input 1
// 3
// 3 2 1

// Sample Output 1
// Array is sorted in 3 swaps.
// First Element: 1
// Last Element: 3

package HackerRank.JavaPython.Interview Prep Kit.Sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
      int count = 0;
      boolean flag = false;
      while (!flag) {
        flag = true;
        for(int i = 0; i < a.size()-1; i++) {
          int val = a.get(i);
          int valNext = a.get(i+1);
          if(val > valNext) {
            int temp = a.get(i);
            a.set(i, a.get(i+1));
            a.set(i+1, temp);
            flag = false;
            count++;
          }
        }
      }
      System.out.println("Array is sorted in " + count + " swaps.");
      System.out.println("First Element: " + a.get(0));
      System.out.println("Last Element: " + a.get(a.size()-1));
    }

    public static void countSwaps2(List<Integer> a) {
      // Write your code here
        int count = 0;
        for(int j = 0; j < a.size(); j++) {
          for(int i = 0; i < a.size()-1; i++) {
            int val = a.get(i);
            int valNext = a.get(i+1);
            if(val > valNext) {
              int temp = a.get(i);
              a.set(i, a.get(i+1));
              a.set(i+1, temp);
              count++;
            }
          }
        }
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size()-1));
      }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}

