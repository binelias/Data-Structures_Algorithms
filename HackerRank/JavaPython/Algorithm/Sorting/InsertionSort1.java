// Sample Input

// 5
// 2 4 6 8 3
// Sample Output

// 2 4 6 8 8 
// 2 4 6 6 8 
// 2 4 4 6 8 
// 2 3 4 6 8 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. INTEGER_ARRAY arr
   */

  public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    int v = arr.get(n - 1); // take last number
    int i = n - 2; // get last but one index
    while (i >= 0 && v < arr.get(i)) { // continue the loop till i>=0 and value < ith value
      if (arr.get(i) > v)
        arr.set(i + 1, arr.get(i)); // if value < ith value, shift ith value to i+1 th index
      i--; // go to left
      for (int x : arr)
        System.out.print(x + " "); // print the array in each setp
      System.out.println();
    }
    arr.set(i + 1, v); // at ent set i+th value to value selected in the begining
    for (int x : arr)
      System.out.print(x + " "); // print the array again
    System.out.println();
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.insertionSort1(n, arr);

    bufferedReader.close();
  }
}
