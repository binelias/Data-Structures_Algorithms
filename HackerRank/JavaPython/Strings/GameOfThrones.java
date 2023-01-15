// Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

// door

// But, to lock the door he needs a key that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be rearranged into a palindrome. Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.

// Sample Input 0

// aaabbbb
// Sample Output 0

// YES
// Explanation 0

// A palindromic permutation of the given string is bbaaabb.

// Sample Input 1

// cdefghmnopqrstuvw
// Sample Output 1

// NO
// Explanation 1

// Palindromes longer than 1 character are made up of pairs of characters. There are none here.

// Sample Input 2

// cdcdcdcdeeeef
// Sample Output 2

// YES
// Explanation 2

// An example palindrome from the string: ddcceefeeccdd.

import java.io.*;


class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        // Write your code here
        int[] hash = new int[26];
        for(char ch:s.toCharArray()) hash[ch-'a']++;
        int odd = 0;
        for(int i=0;i<26;i++) 
            if(hash[i]%2!=0) 
                if(odd>0) return "NO"; 
                else odd++;
        return "YES"; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
