// Sample Input 1

// 3
// 1 2 3
// Sample Output 1

// -1
// Explanation 1

// The triangle (1,2,3) is degenerate and thus can't be constructed, so we print -1 on a new line.

// Sample Input 2

// 6
// 1 1 1 2 3 5
// Sample Output 2

// 1 1 1
// Explanation 2

// The triangle (1,1,1) is the only valid triangle.

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
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
         List<Integer> result = new ArrayList<>();
        Collections.sort(sticks, Comparator.reverseOrder());
        for (int i = 0; i < sticks.size(); i++) {
            for (int j = i + 1; j < sticks.size(); j++) {
                for (int k = j + 1; k < sticks.size(); k++) {
                    if (isValidTriangle(sticks.get(i), sticks.get(j), sticks.get(k))) {
                        result.add(sticks.get(k));
                        result.add(sticks.get(j));
                        result.add(sticks.get(i));
                        return result;
                    }
                }
            }
        }
        result.add(-1);
        return result;
    }

    private static boolean isValidTriangle(int a, int b, int c) {
        return a < b + c;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
