// Sample Input 0

// STDIN           Function
// -----           --------
// 6               arr[] size n = 6
// 5 4 4 2 2 8     arr = [5, 4, 4, 2, 2, 8]
// Sample Output 0

// 6
// 4
// 2
// 1
// Explanation 0

// sticks-length        length-of-cut   sticks-cut
// 5 4 4 2 2 8             2               6
// 3 2 2 _ _ 6             2               4
// 1 _ _ _ _ 4             1               2
// _ _ _ _ _ 3             3               1
// _ _ _ _ _ _           DONE            DONE
// Sample Input 1

// 8
// 1 2 3 4 3 3 2 1
// Sample Output 1

// 8
// 6
// 4
// 1
// Explanation 1

// sticks-length         length-of-cut   sticks-cut
// 1 2 3 4 3 3 2 1         1               8
// _ 1 2 3 2 2 1 _         1               6
// _ _ 1 2 1 1 _ _         1               4
// _ _ _ 1 _ _ _ _         1               1
// _ _ _ _ _ _ _ _       DONE            DONE

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        
        Collections.sort(arr);
        
        list.add(arr.size());
        
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) != arr.get(i-1)) {
                list.add(arr.size() - i);
            }
            
            while (i < arr.size()-1 && arr.get(i).equals(arr.get(i+1))) {
                i++;
            } 
        }
        
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

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
