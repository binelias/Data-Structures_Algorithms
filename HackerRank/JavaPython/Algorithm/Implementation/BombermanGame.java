// Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.

// Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , any valid cells  and  are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.

// Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:

// Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
// After one second, Bomberman does nothing.
// After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
// After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
// Bomberman then repeats steps 3 and 4 indefinitely.
// Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

// Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after  seconds.

// For example, if the initial grid looks like:

// ...
// .O.
// ...
// it looks the same after the first second. After the second second, Bomberman has placed all his charges:

// OOO
// OOO
// OOO
// At the third second, the bomb in the middle blows up, emptying all surrounding cells:

// O.O
// ...
// O.O
// Function Description

// Complete the bomberMan function in the editory below.

// bomberMan has the following parameter(s):

// int n: the number of seconds to simulate
// string grid[r]: an array of strings that represents the grid
// Returns

// string[r]: n array of strings that represent the grid in its final state

// Sample Input

// STDIN           Function
// -----           --------
// 6 7 3           r = 6, c = 7, n = 3
// .......         grid =['.......', '...O...', '....O..',\
// ...O...                '.......', 'OO.....', 'OO.....']
// ....O..
// .......
// OO.....
// OO.....
// Sample Output

// OOO.OOO
// OO...OO
// OOO...O
// ..OO.OO
// ...OOOO
// ...OOOO
// Explanation

// The initial state of the grid is:

// .......
// ...O...
// ....O..
// .......
// OO.....
// OO.....
// Bomberman spends the first second doing nothing, so this is the state after 1 second:

// .......
// ...O...
// ....O..
// .......
// OO.....
// OO.....
// Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

// OOOOOOO
// OOOOOOO
// OOOOOOO
// OOOOOOO
// OOOOOOO
// OOOOOOO
// In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate. This is the final state after  seconds:

// OOO.OOO
// OO...OO
// OOO...O
// ..OO.OO
// ...OOOO
// ...OOOO

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
   * Complete the 'bomberMan' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. STRING_ARRAY grid
   */

  public static List<String> bomberMan(int k, List<String> grid) {
    int n = grid.size();
    int m = grid.get(0).length();
    if (k == 1) {
      return grid;
    }
    if (k % 2 == 0) {
      return gridToList(createAllBombGrid(n, m));
    } else {
      char[][] result = blast(listToGrid(grid), n, m);
      if ((k / 2) % 2 == 0) {
        result = blast(result, n, m);
      }
      return gridToList(result);
    }
  }

  private static char[][] blast(char[][] grid, int n, int m) {
    char[][] result = createAllBombGrid(n, m);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 'O') {
          result[i][j] = '.';
          if (j + 1 < m) {
            result[i][j + 1] = '.';
          }
          if (j - 1 >= 0) {
            result[i][j - 1] = '.';
          }
          if (i + 1 < n) {
            result[i + 1][j] = '.';
          }
          if (i - 1 >= 0) {
            result[i - 1][j] = '.';
          }
        }
      }
    }
    return result;
  }

  private static char[][] createAllBombGrid(int n, int m) {
    char[][] result = new char[n][m];
    for (int i = 0; i < n; i++) {
      result[i] = new char[m];
      Arrays.fill(result[i], 'O');
    }
    return result;
  }

  private static char[][] listToGrid(List<String> list) {
    char[][] arr = new char[list.size()][list.get(0).length()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i).toCharArray();
    }
    return arr;
  }

  private static List<String> gridToList(char[][] grid) {
    List<String> result = new ArrayList<>();
    for (char[] arr : grid) {
      result.add(new String(arr));
    }
    return result;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int r = Integer.parseInt(firstMultipleInput[0]);

    int c = Integer.parseInt(firstMultipleInput[1]);

    int n = Integer.parseInt(firstMultipleInput[2]);

    List<String> grid = IntStream.range(0, r).mapToObj(i -> {
      try {
        return bufferedReader.readLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .collect(toList());

    List<String> result = Result.bomberMan(n, grid);

    bufferedWriter.write(
        result.stream()
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}
