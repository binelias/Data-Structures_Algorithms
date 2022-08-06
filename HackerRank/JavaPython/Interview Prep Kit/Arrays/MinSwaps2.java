// Sample Input 0
// 4
// 4 3 1 2

// Sample Output 0
// 3

// Sample Input 1
// 5
// 2 3 4 1 5

// Sample Output 1
// 3

// Sample Input 2
// 7
// 1 3 5 2 4 6 7

// Sample Output 2
// 3

import java.io.*;
import java.util.*;


public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      int swap = 0;
      for(int i = 0; i < arr.length; i++) {
        if(i+1 != arr[i]) {
          int j = i;
          while(arr[j] != i+1) {
            j++;
          }
          
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
          swap++;
        }
      }
      return swap;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
