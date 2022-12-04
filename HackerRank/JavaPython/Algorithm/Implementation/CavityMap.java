// Sample Input

// STDIN   Function
// -----   --------
// 4       grid[] size n = 4
// 1112    grid = ['1112', '1912', '1892', '1234']
// 1912
// 1892
// 1234
// Sample Output

// 1112
// 1X12
// 18X2
// 1234
// Explanation

// The two cells with the depth of 9 are not on the border and are surrounded on all sides by shallower cells. Their values are replaced by X.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        // Write your code here
        for (int i = 1; i < grid.size() - 1; i++) {
            for (int j = 1; j < grid.get(i).length() - 1; j++) {
                if (grid.get(i).charAt(j) > grid.get(i).charAt(j - 1)
                        && grid.get(i).charAt(j) > grid.get(i).charAt(j + 1)
                        && grid.get(i).charAt(j) > grid.get(i - 1).charAt(j)
                        && grid.get(i).charAt(j) > grid.get(i + 1).charAt(j)) {
                    grid.set(i, grid.get(i).substring(0, j) + "X" + grid.get(i).substring(j + 1));
                }
            }

        }
        return grid;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
