// Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".

// In one step, Alice can change a 0 to a 1 or vice versa. Count and print the minimum number of steps needed to make Alice see the string as beautiful.

// Example


// She can change any one element and have a beautiful string.

// Sample Input 1

// 5
// 01100
// Sample Output 1

// 0
// Sample Case 1:

// In this sampleb= "01100"

// Explanation 1

// The substring "010" does not occur in b, so the string is already beautiful in 0 moves.

// Sample Input 2

// 10
// 0100101010
// Sample Output 2

// 3
// Explanation 2

// In this sample  b = "0100101010"

// One solution is to change the values of b[2],b[5], and b[9] to form a beautiful string.

// Idea: - For each 010, we can flip it to 011, and count that as one "step".
//       - An easy way to count the number of steps is to change each 010 to 01 instead, 
//         and to compare the length of the resulting string with the original string

import java.io.*;


class Result {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
        // Write your code here
        return b.length() - b.replace("010","01").length();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = Result.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
