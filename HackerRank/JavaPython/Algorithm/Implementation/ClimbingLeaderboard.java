// An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense Ranking, so its leaderboard works like this:

// The player with the highest score is ranked number  on the leaderboard.
// Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.

// mple Input 1

// CopyDownload
// Array: ranked
// 100
// 100
// 50
// 40
// 40
// 20
// 10

// Array: player
// 5
// 25
// 50
// 120

// 7
// 100 100 50 40 40 20 10
// 4
// 5 25 50 120
// Sample Output 1

// 6
// 4
// 2
// 1
// Explanation 1

// Alice starts playing with  players already on the leaderboard, which looks like this:

// image

// After Alice finishes game , her score is  and her ranking is :

// image

// After Alice finishes game , her score is  and her ranking is :

// image

// After Alice finishes game , her score is  and her ranking is tied with Caroline at :

// image

// After Alice finishes game , her score is  and her ranking is :

// image

// Sample Input 2

// CopyDownload
// Array: ranked
// 100
// 90
// 90
// 80
// 75
// 60

// Array: player
// 50
// 65
// 77
// 90
// 102

// 6
// 100 90 90 80 75 60
// 5
// 50 65 77 90 102
// Sample Output 2

// 6
// 5
// 4
// 2
// 1

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER_ARRAY ranked
   * 2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    List<Integer> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>(ranked);
    ArrayList<Integer> copy = new ArrayList<>(set);
    Collections.sort(copy);
    Collections.reverse(copy);

    for (int i = 0; i < player.size(); i++) {
      int a = player.get(i);
      list.add(searching(a, copy));
    }
    return list;
  }

  public static int searching(int a, List<Integer> copy) {
    if (a >= copy.get(0)) {
      return 1;
    }
    if (a == copy.get(copy.size() - 1)) {
      return copy.size();
    }
    if (a < copy.get(copy.size() - 1)) {
      return copy.size() + 1;
    }
    int left = 0, right = copy.size() - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (a == copy.get(mid)) {
        return mid + 1;
      }
      if (a <= copy.get(mid) && a > copy.get(mid + 1)) {
        return mid + 2;
      }
      if (a < copy.get(mid)) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return left + 2;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
