// Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

// Its length is at least 6.
// It contains at least one digit.
// It contains at least one lowercase English character.
// It contains at least one uppercase English character.
// It contains at least one special character. The special characters are: !@#$%^&*()-+

// Input Format

// The first line contains an integer , the length of the password.

// The second line contains the password string. Each character is either a lowercase/uppercase English alphabet, a digit, or a special character.

// Constraints

// All characters in  are in [a-z], [A-Z], [0-9], or [!@#$%^&*()-+ ].
// Sample Input 0

// 3
// Ab1
// Sample Output 0

// 3
// Explanation 0

// She can make the password strong by adding 3 characters, for example, $hk, turning the password into Ab1$hk which is strong.

// 2 characters aren't enough since the length must be at least 6.

// Sample Input 1

// 11
// #HackerRank
// Sample Output 1

// 1
// Explanation 1

// The password isn't strong, but she can make it strong by adding a single digit.

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        Set<String> set = new HashSet<>();
        Set<Character> special = new HashSet<>();
        "!@#$%^&*()-+".chars().forEach(c -> special.add((char)c));
        password.chars().forEach( c -> {
            if(Character.isUpperCase((char)c)){
              set.add("UPPER");  
            }else if(Character.isLowerCase((char) c)){
                set.add("LOWER");
            }else if(Character.isDigit((char) c)){
                set.add("DIGIT");
            }else if(special.contains((char) c)){
                set.add("SPECIAL");
            }
        });
        int sizeGap = 6 - password.length();
        int strengthGap = 4 - set.size();
        if(sizeGap > strengthGap) return sizeGap;
        else return strengthGap;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
