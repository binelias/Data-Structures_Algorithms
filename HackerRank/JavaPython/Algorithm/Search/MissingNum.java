// Given two arrays of integers, find which elements in the second array are missing from the first array.

// Notes

// If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
// Return the missing numbers sorted ascending.
// Only include a missing number once, even if it is missing multiple times.
// The difference between the maximum and minimum numbers in the original list is less than or equal to .
// Function Description

// Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.

// missingNumbers has the following parameter(s):

// int arr[n]: the array with missing numbers
// int brr[m]: the original array of numbers
// Returns

// int[]: an array of integers

// Example

// Sample Input
// 10
// 203 204 205 206 207 208 203 204 205 206
// 13
// 203 204 204 205 206 207 205 208 203 206 205 206 204

// Sample Output
// 204 205 206

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        for(int i: brr) if(min > i) min = i;
        int[] hash = new int[101];
        for(int i: brr) hash[i-min]++;
        for(int i: arr) hash[i-min]--;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<hash.length;i++)
            if(hash[i] > 0) res.add(i+min);
        return res;
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
