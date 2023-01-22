// Sample Input
// 25

// Sample Output
// 15511210043330985984000000

// Explanation
// 25!


import java.io.*;
import java.math.*;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger fac = BigInteger.valueOf(1);
        for(int i=1;i<=n;i++){
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        System.out.println(fac.toString());

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
