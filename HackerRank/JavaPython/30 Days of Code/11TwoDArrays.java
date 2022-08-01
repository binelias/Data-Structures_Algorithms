// Sample Input
// 1 1 1 0 0 0
// 0 1 0 0 0 0
// 1 1 1 0 0 0
// 0 0 2 4 4 0
// 0 0 0 2 0 0
// 0 0 1 2 4 0

// Sample Output
// 19

package HackerRank.JavaPython.30 Days of Code;

import java.io.*;
import java.util.*;



public class Solution {
  public static void main(String[] args) throws IOException {
    Scanner sc =new Scanner(System.in);

    List<List<Integer>> arr = new ArrayList<>();
    
    int a[][] = new int[6][6];
    int max = Integer.MIN_VALUE;
    
    try {
        for(int i=0; i<6; i++){
          for(int j=0; j<6; j++){
            a[i][j] = sc.nextInt();
            if(i>1 && j>1) {
              int sum = 
                a[i][j]
                + a[i][j-1]
                + a[i][j-2]
                + a[i-1][j-1]
                + a[i-2][j]
                + a[i-2][j-1]
                + a[i-2][j-2];
              if(sum>max) max=sum;
            }
          }
        }
    }catch(Exception e) {
      System.out.print("Error!");
    }
    System.out.println(max);
    sc.close();
  }
}

