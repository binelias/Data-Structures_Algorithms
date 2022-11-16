// 

// Sample Input 0

// 3 2 3
// 1 2 3
// 0
// 1
// 2
// Sample Output 0

// 2
// 3
// 1
// Explanation 0

// After the first rotation, the array is [3,1,2].
// After the second (and final) rotation, the array is [2,3,1].

// We will call this final state array [2,3,1]. For each query, we just have to get the value of b[queries[i]].

// 0, 2.
// 1, 3.
// 2, 1.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        int realRotations = k % a.size();
        List<Integer> response = new ArrayList<>();
        for (int i = 0; i < realRotations; i++) {
            int currentInt = a.get(a.size()-1);
            a.remove(a.size() - 1);
            a.add(0, currentInt);
        }

        for (int j = 0; j < queries.size(); j++) {
            response.add(a.get(queries.get(j)));
        }

        return response;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

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
