// Sample Input

// STDIN               Function
// -----               --------
// 8 5                 n = 8, t = 5
// 2 3 1 2 3 2 3 3     width = [2, 3, 1, 2, 3, 2, 3, 3]
// 0 3                 cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]
// 4 6
// 6 7
// 3 5
// 0 7
// Sample Output

// 1
// 2
// 3
// 2
// 1
// Explanation

// Below is the representation of the lane:

//    |HIGHWAY|Lane|    ->    Width

// 0: |       |--|            2
// 1: |       |---|           3
// 2: |       |-|             1
// 3: |       |--|            2
// 4: |       |---|           3
// 5: |       |--|            2
// 6: |       |---|           3
// 7: |       |---|           3
// (0,3): From index 0 through 3 we have widths 2,3,1 and 2. Nothing wider than 1 can pass all segments.
// (4,6): From index 4 through 6 we have width 3,2 and 3. Nothing wider than 2 can pass all segments.
// (6,7): 3,3 -> 3.
// (3,5): 2,3,2 -> 2. 
// (0,7): 2,3,1,2,3,2,3,3 -> 1.


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
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    public static List<Integer> serviceLane(List<Integer>width, List<List<Integer>> cases) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cases.size(); i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = cases.get(i).get(0); j <= cases.get(i).get(1); j++) {
                l.add(width.get(j));
            }
            res.add(Collections.min(l));

        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(width, cases);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
