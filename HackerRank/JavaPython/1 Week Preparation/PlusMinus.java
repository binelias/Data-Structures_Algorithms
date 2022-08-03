// Sample Input
// STDIN           Function
// -----           --------
// 6               arr[] size n = 6
// -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]

// Sample Output
// 0.500000
// 0.333333
// 0.166667


import java.util.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
      int count = 0;
      int negCount = 0;
      int zeroCount = 0;
      for(int i = 0; i<arr.size(); i++) {
        if(arr.get(i)>0) {
          count++;
        }else if(arr.get(i)<0){
          negCount++;
        }else {
          zeroCount++;
        }
      }
      System.out.println((double)count/arr.size());
      System.out.println((double)negCount/arr.size());
      System.out.println((double)zeroCount/arr.size());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
