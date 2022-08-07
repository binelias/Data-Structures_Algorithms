// Sample Input 0
// STDIN               Function
// -----               --------
// 9 5                 expenditure[] size n =9, d = 5
// 2 3 4 2 3 6 8 4 5   expenditure = [2, 3, 4, 2, 3, 6, 8, 4, 5]

// Sample Output 0
// 2

// Sample Input 1
// 5 4
// 1 2 3 4 4

// Sample Output 1
// 0


// Steps
// Count Sort
// use your count array like a sliding window instead of recomputing it everytime
// handle even case appropriately
// Integer division rounds down the value

package HackerRank.JavaPython.Interview Prep Kit.Sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    static double GetMedian(int[] count, int d){
      //count array
      int median = 0;
      int sum = 0;
      //odd
      if(d%2 == 1) {
        median = d/2 +1;
        for(int i = 0; i<count.length; i++){
          sum+=count[i];
          if(sum>=median) return (double) i;
        }
      }else {//even
        median = d/2;
        for(int i = 0; i<count.length; i++){
          sum+=count[i];
          if(sum>=median){
            int first = i;
            int second = sum > median ? i : i+1;
            return ((double)(first + second))/2;
          }
        }
      }
      return 0;
    }
    
    public static int activityNotifications(List<Integer> expenditure, int d) {
    // Write your code here
      int[] arr = expenditure.stream().mapToInt(i -> i).toArray();
      int[] count = new int[201];
      //fill count array to d elements
      for(int i = 0; i < d; i++) {
        count[arr[i]] += 1;
      }
      
      int ans = 0;
      for(int i = d; i < arr.length; i++) {
        double ave = GetMedian(count, d);
        //console "median: " median
        if(arr[i] >= 2*ave) ans++;
        
        //add next remove last
        count[arr[i]] +=1;
        count[arr[i-d]] -=1;
      }
      return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
