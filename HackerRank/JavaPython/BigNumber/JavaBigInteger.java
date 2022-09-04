// Sample Input
// 1234
// 20

// Sample Output
// 1254
// 24680

// Explanation
// 1234 + 20 = 1254
// 1234 x 20 = 24680

import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        BigInteger x = new BigInteger(sc.next());
        BigInteger y = new BigInteger(sc.next());
        System.out.println(x.add(y));
        System.out.println(x.multiply(y));
    }
}