// Sample Input

// STDIN           Function
// -----           --------
// 7 3             arr[] size n = 7, d = 3
// 1 2 4 5 7 8 10  arr = [1, 2, 4, 5, 7, 8, 10]
// Sample Output

// 3
// Explanation

// There are many possible triplets {arr[i],arr[j], arr[k]}, but our only beautiful triplets are  (1,4,7),(4,7,10)  and (2,5,8)  by value, not index. Please see the equations below:
// 7-4 =4-1 =3 =d
// 10-7=7-4=3=d
// 8-5=5-2=3=d
// Recall that a beautiful triplet satisfies the following equivalence relation: arr[j] - arr[i] arr[k]- arr[j] =d where i<j<k.


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        int count=0;
        int i=0;
        int j=i+1;
        int k=j+1;
   
        while (k<arr.size()) {
            
            while((arr.get(j)-arr.get(i))==d ) {
                
                if ((arr.get(k)-arr.get(j))==d) {
                    count++;
                }    
                    
                k++;
                if (k==arr.size()) {
                    j=j+1;
                    k=j+1;
                }
            }
            j++;
            if (j==arr.size()-1) {
            i+=1;
            j=i+1; 
            k=j+1;
            }
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

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
