// You are given  queries. Each query is of the form two integers described below:
// -1 x: Insert x in your data structure.
// -2 y: Delete one occurence of y from your data structure, if present.
// -3 z: Check if any integer is present whose frequency is exactly . If yes, print 1 else

// Sample Input 0
// 8
// 1 5
// 1 6
// 3 2
// 1 10
// 1 10
// 1 6
// 2 5
// 3 2

// Sample Output 0
// 0
// 1

// Sample Input 1
// 4
// 3 4
// 2 1003
// 1 16
// 3 1

// Sample Output 1
// 0
// 1

// Sample Input 2
// 10
// 1 3
// 2 3
// 3 2
// 1 4
// 1 5
// 1 5
// 1 4
// 3 2
// 2 4
// 3 2

// Sample Output 2
// 0
// 1
// 1

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
      HashMap<Integer, Integer> frequencies = new HashMap<>();
      int[] quantities = new int[queries.size() + 1];
      List<Integer> result = new ArrayList<>();
      int frequency, value;

      for (List<Integer> query : queries) {
        value = query.get(1);
        switch (query.get(0)) {
          case 1:
            // process fq
            frequency = frequencies.getOrDefault(value, 0);
            frequencies.put(value, frequency + 1);
            // process qt
            quantities[frequency]--;
            quantities[frequency + 1]++;
            break;
          case 2:
            // process fq
            frequency = frequencies.getOrDefault(value, 0);
            if (frequency == 0) break;
            if (frequency == 1) frequencies.remove(value);
            else frequencies.put(value, frequency - 1);
            // process qt
            quantities[frequency]--;
            quantities[frequency - 1]++;
            break;
          case 3:
            if (value >= quantities.length) result.add(0);
            else result.add(quantities[value] > 0 ? 1 : 0);
            break;
        }
      }

      return result;
    }
    
    static List<Integer> freqQuery2(List<List<Integer>> queries) {
      List<Integer> ans = new ArrayList<>();
      List<Integer> dataList = new ArrayList<>();
      HashMap<Integer, Integer> freqMap = new HashMap<>();
      
      for(List<Integer> query : queries) {
        int command = query.get(0);
        Integer data = query.get(1);
        if(command == 1) {
          dataList.add(data);
          freqMap.put(data, freqMap.getOrDefault(data,0) + 1);
        }else if (command == 2) {
          if(dataList.remove(data)){
            freqMap.put(data, freqMap.getOrDefault(data, 0) - 1);
          }
        }else if (command == 3) {
          ans.add(freqMap.containsValue(data) ? 1 : 0);
        }
      }
      return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

