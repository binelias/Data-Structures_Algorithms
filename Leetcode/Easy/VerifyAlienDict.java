// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.


// Example 1:

// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
// Example 2:

// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
// Example 3:

// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// All characters in words[i] and order are English lowercase letters.

// Compare adjacent words
// Intuition

// Following the above overview, we want to compare each pair of adjacent words to see if they are sorted lexicographically. This can be achieved by a naive for-loop iterating over the input array. We can store the letter-order relation of each letter with its ranking in order, so that we can easily access the order of letters when we compare them.

// The remaining piece of the puzzle is how to compare two words lexicographically. This is not difficult, but there are a few edge cases that we must consider. To compare two adjacent words words[i] and words[i+1], we want to find the first letter that is different: if words[i] has the lexicographically smaller letter, then we can exit from the iteration because we know words[i] and words[i+1] are in the right order; however, if words[i] has the lexicographically larger letter, then we immediately return false, because we found one pair of words that are in the wrong order.

// We also need to consider the boundaries. While we loop from the beginning to the end of one word, we need to check if the other word has ended. Take the words apple and app as an example, we cannot iterate over all of the letters in apple because the word app is shorter. In this case, we reach the end of one word before finding the first different letter. When this happens, we must examine the length of each word: if the words are the same length or the former word is shorter, then words is sorted. However, if the latter word is shorter, then words is not sorted.

// Algorithm

// Initialize a hashmap/array to record the relations between each letter and its ranking in order.
// Iterate over words and compare each pair of adjacent words.
// Iterate over each letter to find the first different letter between words[i] and words[i + 1].
// If words[i + 1] ends before words[i] and no different letters are found, then we need to return false because words[i + 1] should come before words[i] (for example, apple and app).
// If we find the first different letter and the two words are in the correct order, then we can exit from the current iteration and proceed to the next pair of words.
// If we find the first different letter and the two words are in the wrong order, then we can safely return false.
// If we reach this point, it means that we have examined all pairs of adjacent words and that they are all sorted. Therefore we can return true.


class Solution {
    public boolean isAlienSorted(String[] words, String order) {
         int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length()) return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else break;
                }
            }
        }

        return true;
    }
}