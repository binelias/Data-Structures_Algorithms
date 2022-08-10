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
      for(int i=0; i<points.size()-2;i++) {
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
      return ways == points.size() ? ways : count;
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

