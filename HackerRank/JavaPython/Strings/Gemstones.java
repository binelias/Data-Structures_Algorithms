// There is a collection of rocks where each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range [a-z]. There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in the collection.

// Given a list of minerals embedded in each of the rocks, display the number of types of gemstones in the collection.

// Sample Input

// STDIN       Function
// -----       --------
// 3           arr[] size n = 3
// abcdde      arr = ['abcdde', 'baccd', 'eeabg']
// baccd
// eeabg
// Sample Output

// 2
// Explanation

// Only a and b occur in every rock.

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'gemstones' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY arr as parameter.
   */

  public static int gemstones(List<String> arr) {
    // Write your code here
    final int NUM_ELEMENTS = 26;
    BitSet bitset = new BitSet(NUM_ELEMENTS);
    bitset.set(0, NUM_ELEMENTS);

    /* Create a BitSet for each rock. "AND" it with our original BitSet */
    for (String rock : arr) {
      BitSet currBitSet = new BitSet(NUM_ELEMENTS);
      for (int i = 0; i < rock.length(); i++) {
        currBitSet.set(rock.charAt(i) - 'a');
      }
      bitset.and(currBitSet);
    }

    return bitset.cardinality();
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> arr = IntStream.range(0, n).mapToObj(i -> {
      try {
        return bufferedReader.readLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .collect(toList());

    int result = Result.gemstones(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
