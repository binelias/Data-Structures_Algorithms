// Sample Input

// STDIN           Function
// -----           --------
// 6               arr[] size n = 6
// 7 1 3 4 1 7     arr = [7, 1, 3, 4, 1, 7]
// Sample Output

// 3
// Explanation
// There are two pairs to consider:

// a[1] and a[4] are both 1, so d[1,4] = [1-4] = 3.
// a[0] and a[5] are both 7, so d[0,5] = [0-5] = 5.
// The answer is (3,5) = 3.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                int prevIndex = map.get(a.get(i));
                int currDistance = i - prevIndex;
                minDistance = Math.min(minDistance, currDistance);
            }
            map.put(a.get(i), i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

