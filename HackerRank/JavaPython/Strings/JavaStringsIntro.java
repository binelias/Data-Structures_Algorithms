// Sample Input 0
// hello
// java

// Sample Output 0
// 9
// No
// Hello Java

// Explanation 0
// String A is "hello" and B is "java".

// A has a length of 5, and  has a length of 4; the sum of their lengths is 9.
// When sorted alphabetically/lexicographically, "hello" precedes "java"; therefore A  is not greater than B and the answer is No.

// When you capitalize the first letter of both A and B and then print them separated by a space, you get "Hello Java".

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */ 
        //sum length
        System.out.println(A.length() + B.length());
        
        //lexicorgraphical order
        System.out.println(A.compareTo(B) > 0 ? "Yes": "No");
        
        //Print desired format
        System.out.println(capFirstLetter(A) + " " + capFirstLetter(B));
    }
    
    private static String capFirstLetter(String str) {
        if(str == null || str.length() == 0) return "";
        else return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
