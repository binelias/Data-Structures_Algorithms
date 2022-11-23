// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false
// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char S = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(S)) {
                if (!map1.get(S).equals(word))
                    return false;
            }

            else {
                if (map2.containsKey(word))
                    return false;
                else {
                    map1.put(S, word);
                    map2.put(word, true);
                }
            }
        }

        return true;
    }
}