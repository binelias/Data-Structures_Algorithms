// Sample Input 0
// 4 2
// 1 2 2 4

// Sample Output 0
// 2

// Sample Input 1
// 6 3
// 1 3 9 9 27 81

// Sample Output 1
// 6

// Sample Input 2
// 5 5
// 1 5 5 25 125

// Sample Output 2
// 4

//logical steps
// I don't normally share codes in discussions but this time I wanted to since I thought it is much easier to understand than others. I am using the same two maps strategy with others:

// The first map basically stores the count of each number we encountered so far.
// The second map stores the number of tuples we can form using the current element we encountered.
// So, if r = 3 and we have seen two 3s so far, the first map will store the value two for key 3. When we encounter a 9, we will insert value two for key 9 into the second map. If we encounter another 9, we will increase the value in the second map to four. And when we encounter a 27, we will increment the result by four.


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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
      HashMap<Long, Long> mapCounts = new HashMap<>();
      HashMap<Long, Long> mapPair = new HashMap<>();
      long count = 0L;
      
      for(int i = arr.size()-1; i >=0; i--) {
        long a = arr.get(i);
        if(mapPair.containsKey(a*r)) {
          count += mapPair.get(a*r);
        }
        if(mapCounts.containsKey(a*r)) {
          mapPair.put(a, mapPair.getOrDefault(a, 0L) + mapCounts.get(a*r));
        }
        mapCounts.merge(a, 1L, Long::sum); 
      }
      return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

