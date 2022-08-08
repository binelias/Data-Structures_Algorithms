// Sample Input 0
// 2
// abba
// abcd

// Sample Output 0
// 4
// 0

// Sample Input 1
// 2
// ifailuhkqq
// kkkk

// Sample Output 1
// 3
// 10

// Sample Input 2
// 1
// cdcd

// Sample Output 2
// 5


//logical steps
// The problem looks difficult because they didn't explained it clearly. Let me explain the job to be done in this problem :

// Find all possible substrings in the string
// For each one of them , generate frequency table as per hashmap , like we say suppose "akk" contains in map , so increment the counter by 1, If NOT, then add "akk" as new entry in map
// **Make sure to store the string in map as per alphabetic order because this is only condition which will be suffice to be anagram **

// Now add the value of frequency to the count variable and there you go with the solution

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    // Write your code here
      int count = 0;
      HashMap<String, Integer> map = new HashMap<>();
      for(int i = 0; i<s.length(); i++) {
        for(int j = i+1; j <= s.length(); j++) {
          //generating a substring
          String subStr = s.substring(i, j);
          
          //below three lines are code to generate the alphabetical order for the string subStr
          char[] temp = subStr.toCharArray();
          Arrays.sort(temp);
          String tempStr = String.valueOf(temp);
          if(map.containsKey(tempStr)) {
            count +=map.get(tempStr);
            map.put(tempStr, map.get(tempStr)+1); 
          }else map.put(tempStr, 1);
        }
      }
      return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

