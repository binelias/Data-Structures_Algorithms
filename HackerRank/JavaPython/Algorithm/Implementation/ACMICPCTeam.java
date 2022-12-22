// Sample Input

// 4 5
// 10101
// 11100
// 11010
// 00101
// Sample Output

// 5
// 2
// Explanation

// Calculating topics known for all permutations of 2 attendees we get:
// (1,2) -> 4
// (1,3) -> 5
// (1,4) -> 3
// (2,3) -> 4
// (2,4) -> 4
// (3,4) -> 5
// The 2 teams (1, 3) and (3, 4) know all 5 topics which is maximal.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'acmTeam' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts STRING_ARRAY topic as parameter.
   */

  public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
    List<Integer> result = new ArrayList<>();

    List<List<Integer>> list = new ArrayList<>();
    for (String topics : topic) {
      int index = 1;

      List<Integer> l = new ArrayList<>();

      for (char ch : topics.toCharArray()) {
        if (ch == '1')
          l.add(index);
        index++;
      }

      list.add(l);
    }

    List<Integer> maxA = new ArrayList<>();
    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        Set<Integer> merge = new HashSet<Integer>();

        merge.addAll(list.get(i));
        merge.addAll(list.get(j));

        maxA.add(merge.size());
      }
    }

    result.add(Collections.max(maxA));
    result.add(Collections.frequency(maxA, Collections.max(maxA)));
    return result;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<String> topic = IntStream.range(0, n).mapToObj(i -> {
      try {
        return bufferedReader.readLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .collect(toList());

    List<Integer> result = Result.acmTeam(topic);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
