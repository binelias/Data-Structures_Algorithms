// Sample Input

// STDIN           Function
// -----           --------
// 6               n = 6
// 1 4 3 5 6 2     arr = [1, 4, 3, 5, 6, 2]

// Sample Output

// 1 4 3 5 6 2 
// 1 3 4 5 6 2 
// 1 3 4 5 6 2 
// 1 3 4 5 6 2 
// 1 2 3 4 5 6 

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for (int i = 1; i < arr.size(); i++) {
            int j = i;
            int value = arr.get(i);
            while (j >= 1 && arr.get(j-1) > value) { // find where to insert "value"
                arr.set(j, arr.get(j-1));            // shift the elements (1 by 1) to make room for inserting
                j--;
            }
            arr.set(j,value);
            printArray(arr);
        }
    }  
    
    private static void printArray(List<Integer> arr) {
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

