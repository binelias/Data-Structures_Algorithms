// Sample Input

// STDIN       Function
// -----       --------
// 5           arr[] size n =5
// 4 5 3 7 2   arr =[4, 5, 3, 7, 2]
// Sample Output

// 3 2 4 5 7

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivotIndex = 0; // not a great choice of pivot.
        int pivotValue = arr.get(pivotIndex);
        
        swap(arr, pivotIndex, arr.size() - 1); // put pivot at end for now.
        
        /* Linear search, comparing all elements to pivotValue and swapping as necessary */
        int indexToReturn = 0;
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) < pivotValue){
                swap(arr, i, indexToReturn);
                indexToReturn++;
            }
        }
        
        swap(arr, indexToReturn, arr.size() - 1); // puts pivot where it belongs
        return arr;
    }
    
     private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
