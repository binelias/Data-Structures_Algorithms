// Sample Input
// 10
// 64630 11735 14216 99233 14470 4978 73429 38120 51135 67060

// Sample Output
// 43900.6  - Mean
// 44627.5 - Median
// 4978 - Mode, smallest one if multiple values to choose from



Package HackerRank.Java.10 Days of Statistics;

import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int x[]= new int[num];
        int sum = 0;
        int total = 0;
        int w;
        for (int i=0; i<num;i++){
            x[i] = scan.nextInt();
        }
        for (int i=0; i<num;i++){
            w=scan.nextInt();
            total=total+w;
            sum = sum+x[i]*w;
        }
        System.out.printf("%.1f\n", (float)sum/total);
        scan.close();
    }
}

