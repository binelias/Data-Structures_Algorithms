// Sample Input
// 1 2 3 4 5

// Sample Output
// 10 14


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
      long min = 0;
      long max = 0;
      Collections.sort(arr);
      for(int i = 1; i<arr.size(); i++) {
        max+=arr.get(i);
      }
      for(int i = 0; i<arr.size()-1; i++) {
        min+=arr.get(i);
      }
      System.out.print(min + " " + max);
      
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

