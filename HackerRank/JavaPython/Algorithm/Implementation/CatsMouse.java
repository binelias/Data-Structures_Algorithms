// Input Format
// The first line contains a single integer, q, denoting the number of queries.
// Each of the q subsequent lines contains three space-separated integers describing the respective values of x (cat A's location),  (cat Bs location), and  z(mouse C's location).

// Sample Input 0
// 2
// 1 2 3
// 1 3 2

// Sample Output 0
// Cat B
// Mouse C

// Explanation 0
// Query 0: The positions of the cats and mouse are shown below: 

// 0 1(cat A) 2(cat B) 3(mouse C) 4

// Cat B will catch the mouse first, so we print Cat B on a new line.

// Query 1: In this query, cats A and B reach mouse C at the exact same time: image

// 0 1(cat A) 2(mouse C) 3(cat B) 4

// Because the mouse escapes, we print Mouse C on a new line.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {

        int A_to_C = Math.abs(z - x);
        int B_to_C = Math.abs(z - y);
        if (A_to_C < B_to_C) {
            return "Cat A";
        } else if (A_to_C > B_to_C) {
            return "Cat B";
        } else {
            return "Mouse C";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
