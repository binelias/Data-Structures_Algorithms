// Sample Input
// 5
// 10
// 20
// 30
// 40
// 50

// Sample Output
// 10
// 20
// 30
// 40
// 50

// Explanation
// When we save each integer to its corresponding index in a, we get a = [10,20,30,40,50]. The locked code prints each array element on a new line from left to right.

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
