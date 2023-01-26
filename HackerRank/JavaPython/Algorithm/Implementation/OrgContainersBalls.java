// David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container. David wants to sort the balls using his sort method.

// David wants to perform some number of swap operations such that:

// Each container contains only balls of the same type.
// No two balls of the same type are located in different containers.

// Sample Input 1

// 2
// 3
// 1 3 1
// 2 1 2
// 3 3 3
// 3
// 0 2 1
// 1 1 1
// 2 0 0
// Sample Output 1

// Impossible
// Possible

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        int n = container.size();
        int[] balls = new int[n];
        int[] capacity = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                balls[i] += container.get(j).get(i);
                capacity[i] += container.get(i).get(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= balls[i];
            ans ^= capacity[i];
        }
        return ans == 0 ? "Possible" : "Impossible";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
