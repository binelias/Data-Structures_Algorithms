// Sample Input
// 5
// 1 -2 4 -5 1

// Sample Output
// 9

// Explanation
// There are nine negative subarrays of A = [1, -2, 4, -5, 1]:
// 1. [1:1] = -2
// 2. [3:3] = -5
// 3. [0:1] = 1 + -2 = -1
// 4. [2:3] = 4 + -5 = -1
// 5. [3:4] = -5 + 1 = -4
// 6. [1:3] = -2 + 4 + -5 = -3
// 7. [0:3] = 1 + -2 + 4 + -5 = -2
// 8. [1:4] = -2 + 4 + -5 + 1 = -2
// 9. [0:4] = 1 + -2 + 4 + -5 + 1 = -1
// Thus, we print 9 on a new line.

import java.util.*;

public class Solution {

    private static int negativeSubarrays(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            int sum = 0;
            for(int j = i; j <array.length;j++) {
                sum +=array[j];
                if(sum<0) count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(negativeSubarrays(array));
    }
}