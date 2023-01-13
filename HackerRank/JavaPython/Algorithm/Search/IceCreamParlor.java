// Sample Input
// STDIN       Function
// -----       --------
// 2           t = 2
// 4           k = 4
// 5           cost[] size n = 5
// 1 4 5 3 2   cost = [1, 4, 5, 3, 2]
// 4           k = 4
// 4           cost[] size n = 4
// 2 2 4 3     cost=[2, 2,4, 3]

// Sample Output
// 1 4
// 1 2

// Explanation
// Sunny and Johnny make the following two trips to the parlor:

// The first time, they pool together m = 4 dollars. Of the five flavors available that day, flavors 1 and 4 have a total cost of 1 + 3 = 4.
// The second time, they pool together m = 4 dollars. Of the four flavors available that day, flavors 1 and 2 have a total cost of 2 + 2 = 4.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        Integer [] a = new Integer[arr.size()];
        List<Integer> ans =new ArrayList<>();
        arr.toArray(a);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(i!=j &&(a[i]+a[j])==m  && j>i){
                ans.add(i+1);
                ans.add(j+1);
                break; 
                }
            }
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
