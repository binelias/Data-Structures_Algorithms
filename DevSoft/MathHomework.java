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
     * Complete the 'minNum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER threshold
     *  2. INTEGER_ARRAY points
     */

    public static int minNum(int threshold, List<Integer> points) {
    // Write your code here
      int count = 1;
      int ways = 1;
      Map<Integer, Integer> map = new HashMap<>();
      for(int i=0; i<points.size()-1; i++) {
        map.put(i, points.get(i+1) - points.get(0));
      }
      for(Integer value: map.values()) {
        if(value < threshold) ways++;
      }

      for(int i=0; i<points.size()-1;i++) {
        if(points.size()%2 == 0) {
          if(points.get(i+1) - points.get(0) <= threshold) count++;
        }else {
          if(i%2 == 0) {
            int soln = points.get(i+2) - points.get(0);
            if( soln <= threshold) count++;
            else if(soln > threshold) {
              if(points.get(i+1) - points.get(0) <= threshold) count++;
            }
          }
        }
        
      }
      return ways == points.size() ? ways : count + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        int pointsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> points = IntStream.range(0, pointsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minNum(threshold, points);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

// As the input array is sorted and it is mandate to choose the first element i=0, we can use binary search between [1, arr.length-1] to find the element where it crosses the threshold. After finding the point we can calculate how many min number of steps that can be taken to reach the threshold point. If the threshold point cannot be found then return size of array.

// Example : [1,2,3,4,5], select 1 as it is mandate (given i=0, should be selected). Binary search for target i.e arr[mid]>= threshold + arr[0], if found try searching for a smaller value within the range. We've found that arr[4] = (arr[0] + threshold) i.e. value of 5, now we have to calculate how many min number steps are be taken to reach i=4, from i =0, given we can take 1 or 2 steps [(i+1) or (i+2)] index. So by the example min steps would be 1 as we can reach the values using these steps. 1 -> 3 -> 5 i.e.(indices of [0 -> 2 ->4 ]), the answer will be the (number of steps taken + 2) = 3, as we had i=0 and i=(threshold value point) selected already.

