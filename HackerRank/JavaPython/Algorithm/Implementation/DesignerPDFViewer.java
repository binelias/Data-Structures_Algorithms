// Sample Input 0

// 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
// abc
// Sample Output 0

// 9
// Explanation 0

// We are highlighting the word abc:

// Letter heights are ,  and . The tallest letter, b, is  high. The selection area for this word is .

// Note: Recall that the width of each character is .

// Sample Input 1

// 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7
// zaba
// Sample Output 1

// 28
// Explanation 1

// The tallest letter in  is  at . The selection area for this word is .

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        //Calculate and print area
        int maxHeight = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            maxHeight = Math.max(maxHeight, h.get(index));
        }
        int area = maxHeight * word.length();
        return area;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
