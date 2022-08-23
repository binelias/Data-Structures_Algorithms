// Sample Input 0
// anagram
// margana

// Sample Output 0
// Anagrams
// Explanation 0

// Character	Frequency: anagram	Frequency: margana
// A or a	3	3
// G or g	1	1
// N or n	1	1
// M or m	1	1
// R or r	1	1
// The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

// Sample Input 1
// anagramm
// marganaa

// Sample Output 1
// Not Anagrams
// Explanation 1

// Character	Frequency: anagramm	Frequency: marganaa
// A or a	3	4
// G or g	1	1
// N or n	1	1
// M or m	2	1
// R or r	1	1
// The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

// Sample Input 2
// Hello
// hello

// Sample Output 2
// Anagrams

// Explanation 2
// Character	Frequency: Hello	Frequency: hello
// E or e	1	1
// H or h	1	1
// L or l	2	2
// O or o	1	1
// The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
import java.io.*;
import java.util.*;

public class Solution {
    
    static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<Character, Integer> map = new HashMap();
        
        /* Fill HashMap with 1st String */
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }
        
        /* Compare 2nd String to 1st String's HashMap */
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}