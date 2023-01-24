// Given a set of distinct integers, print the size of a maximal subset of  where the sum of any 2 numbers in S is not evenly divisible by k.

// Sample Input
// STDIN    Function
// -----    --------
// 4 3      S[] size n = 4, k = 3
// 1 7 2 4  S = [1, 7, 2, 4]
// Sample Output

// 3
// Explanation

// The sums of all permutations of two elements from s = {1,7,2,4} are:

// 1 + 7 = 8
// 1 + 2 = 3
// 1 + 4 = 5
// 7 + 2 = 9
// 7 + 4 = 11
// 2 + 4 = 6
// Only S = {1,7,4}  will not ever sum to a multiple of k = 3.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] frequency = new int[k];
        for(int i=0;i<s.size();i++){
            frequency[s.get(i)%k]+=1;
        }
        int count=0;
        System.out.println(frequency);
        if(frequency[0]>0)
        count=1;

        if(k%2==0&&frequency[k/2]>0)
            count+=1;

        for(int i=1,j=k-1;i<j;i++,j--){

            if(frequency[i]>frequency[j])
                count+=frequency[i];
            else
                count+=frequency[j];
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
