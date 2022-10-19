// Every student receives a  in the inclusive range from 0 to 100.

// Any grade less than 40 is a failing grade.

// If the difference between the grade and the next multiple of 5 is less than 3, round  up to the next multiple of 5.

// If the value of  grade is less than 38, no rounding occurs as the result will still be a failing grade.

// Sample Input 0
// 4
// 73
// 67
// 38
// 33

// Sample Output 0
// 75
// 67
// 40
// 33

// Explanation 0
// Student 1 received a 73, and the next multiple of 5  from 73 is 75. Since 75 - 73 < 3, the student's grade is rounded to 75.

// Student 2 received a 67, and the next multiple of 5 from 67 is 70. Since 70 - 67 = 3, the grade will not be modified and the student's final grade is 67.

// Student 3 received a 38, and the next multiple of 5 from 38 is 40. Since 40 - 38 < 3, the student's grade will be rounded to 40.

// Student 4 received a grade below 33, so the grade will not be modified and the student's final grade is 33.

// Constraints
// 1 <= n <= 60
// 0 <= grades[i] <= 100

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
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */

  public static List<Integer> gradingStudents(List<Integer> grades, int gradesCount) {
    // Write your code here
    for (int i = 0; i < gradesCount; i++) {
      int grade = grades.get(i);
      if (grade >= 38) {
        int gradeMod5 = grade % 5;
        if (gradeMod5 > 2) {
          grades.set(i, grade + 5 - gradeMod5);
        }
      } else
        continue;
    }
    return grades;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.gradingStudents(grades, gradesCount);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
