// Input Format
// The first line contains three space-separated integers b, n, and m, the budget, the number of keyboard models and the number of USB drive models.
// The second line contains n space-separated integers keyboard[i], the prices of each keyboard model.
// The third line contains m space-separated integers drives, the prices of the USB drives.

// Constraints
// 1 <= n,m <= 1000
// 1 <= b <= 10^6
// The price of each item is in the inclusive range [1,10^6].

// Sample Input 0
// 10 2 3
// 3 1
// 5 2 8

// Sample Output 0
// 9

// Explanation 0
// Buy the 2nd keyboard and the 3rd USB drive for a total cost of 8 + 1 =9.

// Sample Input 1
// 5 1 1
// 4
// 5

// Sample Output 1
// -1

// Explanation 1
// There is no way to buy one keyboard and one USB drive because 4 + 5 > 5, so return -1. 

import java.io.*;
import java.util.*;


public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        Arrays.sort(keyboards); // O(n log n) time complexity
        Arrays.sort(drives);    // O(m log m) time complexity
        int max = -1;
        int i = 0;
        int j = drives.length - 1;
        while (i < keyboards.length && j >= 0) { // O(n + m) time complexity
            int cost = keyboards[i] + drives[j];
            if (cost > b) {
                j--; // look for a cheaper hard drive
            } else {
                if (cost > max) {
                    max = cost;
                }
                i++; // look for a more expensive keyboard
            }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
