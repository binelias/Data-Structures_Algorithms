// Sample Input

// STDIN       Function
// -----       --------
// 6 3         n = 6, k = 3
// 5 1         contests = [[5, 1], [2, 1], [1, 1], [8, 1], [10, 0], [5, 0]]
// 2 1
// 1 1
// 8 1
// 10 0
// 5 0
// Sample Output

// 29

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

class ListComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> a, List<Integer> b) {
        int a1 = a.get(0);
        int a2 = a.get(1);
        int b1 = b.get(0);
        int b2 = b.get(1);

        if (a2 == 0 && b2 == 1) {
            return 1;
        } else if (a2 == 1 && b2 == 0) {
            return -1;
        } else {
            if (a1 > b1) return 1;
            else if (a1 == b1) return 0;
            else return -1;
        }
    }
}

class Result {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
    // Write your code here
        int total_luck = 0, important_contests = 0;
        ListComparator listComparator = new ListComparator();
        contests.sort(listComparator);

        for (List<Integer> contest: contests) {
            int importance = contest.get(1);
            int luck = contest.get(0);
            if (importance == 1) important_contests++;
            total_luck += luck;
        }

        int lost_contests = important_contests - k;

        for (int i = 0; i < lost_contests; i++) {
            total_luck -= (2 * contests.get(i).get(0));
        }

        return total_luck;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                contests.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
