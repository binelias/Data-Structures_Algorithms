// Sample Input
// He is a very very good boy, isn't he?

// Sample Output
// 10
// He
// is
// a
// very
// very
// good
// boy
// isn
// t
// he

// Explanation
// We consider a token to be a contiguous segment of alphabetic characters. There are a total of 10 such tokens in string s, and each token is printed in the same order in which it appears in string s.

package HackerRank.JavaPython.Strings;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        //Edge cases
        
        s = removeLeadingNonLetters(s);
        if(s.length() == 0) {
            System.out.println(0);
            return;
        }
        
        //split all non-alpha char
        String[] words = s.split("[^a-zA-Z]+");
        System.out.println(words.length);
        for(String word: words) {
            System.out.println(word);
        }
    }
    
    private static String removeLeadingNonLetters(String str) {
        int i;
        for(i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                break;
            }
        }
        return str.substring(i);
    }
}

