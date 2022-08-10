// Sample Input 0
// 3
// 1 2 3

// Sample Output 0
// Array is sorted in 0 swaps.
// First Element: 1
// Last Element: 3

// Explanation 0
// The array is already sorted, so 0 swaps take place and we print the necessary  lines of output shown above.

// Sample Input 1
// 3
// 3 2 1

// Sample Output 1
// Array is sorted in 3 swaps.
// First Element: 1
// Last Element: 3

// Explanation 1
// The array a = [3,2,1] is not sorted, so we perform the following 3 swaps. Each line shows a after each single element is swapped.
// 1. [3,2,1] -> [2,3,1]
// 2. [2,3,1] -> [2,1,3]
// 3. [2,1,3] -> [1,2,3]

// After 3 swaps, the array is sorted.

//BubbleSort
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



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        // Write your code here
        int count = 0;
        for(int i = 0; i<a.size(); i++) {
          for(int j=0; j<a.size()-1; j++) {
            if(a.get(j) > a.get(j+1)) {
              Collections.swap(a, j, j+1);
              count++;
            }
          }
          if(count== 0) break;
        }
        
        System.out.println(
          "Array is sorted in " + count + " swaps." +
          "\nFirst Element: " + a.get(0) + 
          "\nLast Element: " + a.get(a.size()-1));

        bufferedReader.close();
    }
}
