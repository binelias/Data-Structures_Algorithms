// Input Format

// There will be exactly 6 lines, each containing 6 integers seperated by spaces. Each integer will be between -9 and 9 inclusive.

// Output Format
// Print the answer to this problem on a single line.

// Sample Input
// 1 1 1 0 0 0
// 0 1 0 0 0 0
// 1 1 1 0 0 0
// 0 0 2 4 4 0
// 0 0 0 2 0 0
// 0 0 1 2 4 0

// Sample Output
// 19

// Explanation
// The hourglass which has the largest sum is:
// 2 4 4
//   2
// 1 2 4

import java.io.*;
import java.util.*;


public class Solution {
    private static int findSum(int[][] arr, int r, int c) {
        int sum = arr[r + 0][c + 0] + arr[r+ 0][c + 1] + arr[r+ 0][c + 2]
                                    + arr[r+ 1][c + 1] +
                  arr[r + 2][c + 0] + arr[r+ 2][c + 1] + arr[r+ 2][c + 2];
        return sum;
    }
    
    public static int maxHourGlass(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                int sum = findSum(arr, row, col);
                max = Math.max(max,sum);
            }   
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 6; col++) {
                arr[row][col] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(maxHourGlass(arr));
    }
}