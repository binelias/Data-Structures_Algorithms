// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.


// Basically logic goes below:

// turn String into char[]
// sort the char[]
// turn sorted char[] back to String
// do "word" count with HashMap <String, Integer>
// sort the HashMap by value descendingly
// concat keys

class Solution {
  public String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    if (s.length() == 1) {
      return s;
    }

    StringBuilder sb = new StringBuilder("");

    // 1. turn String into char[]
    char[] c = s.toCharArray();

    // 2. sort the char[]
    Arrays.sort(c);

    // 3. turn sorted char[] back to String
    String newS = new String(c);

    // 4. do "word" count with HashMap <String, Integer>
    Map<String, Integer> mp = new HashMap<>();
    int slow = 0;
    int fast = 1;
    for (; fast < s.length(); fast++) {
      if (c[fast] != c[slow]) {
        int diff = fast - slow;
        sb.append(newS.substring(slow, fast));
        slow = fast;
        mp.put(sb.toString(), diff);
        sb = new StringBuilder("");
      }
    }

    int diff = fast - slow;
    sb = new StringBuilder("");
    while (slow < fast) {
      sb.append(c[slow]);
      slow++;
    }
    mp.put(sb.toString(), diff);

    // 5. sort the HashMap by value descendingly
    mp = sortByVal(mp);

    // 6. concat keys
    sb = new StringBuilder("");
    for (String cs : mp.keySet()) {
      sb.append(cs);
    }

    return sb.toString();
  }

  // 5. sort the HashMap by value descendingly
  private Map<String, Integer> sortByVal(Map<String, Integer> mp) {

    List<Map.Entry<String, Integer>> list = new LinkedList<>(mp.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });

    // lambda is slower than the anonymous class
    // Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

    Map<String, Integer> newMp = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : list) {
      newMp.put(entry.getKey(), entry.getValue());
    }

    return newMp;
  }
}

class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    Queue<Character> queue = new PriorityQueue<>(
        (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
    for (Map.Entry<Character, Integer> kv : map.entrySet()) {
      queue.offer(kv.getKey());
    }
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      char c = queue.poll();
      for (int i = 0; i < map.get(c); i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}