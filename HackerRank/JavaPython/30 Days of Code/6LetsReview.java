// Sample Input
// 2
// Hacker
// Rank

// Sample Output
// Hce akr
// Rn ak


import java.io.*;
import java.util.*;

public class Solution {
    
    
    public static void solution(char[] array) {
        int size = array.length;
        for(int i=0; i<size; i+=2){
            System.out.print(array[i]);
        }
        System.out.print(" ");
        for(int i=1; i< size; i+=2){
            System.out.print(array[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String str = "";
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        for(int i=1; i<=x; i++){
            str = sc.nextLine();
            solution(str.toCharArray());
        }
        sc.close();
    }
}
