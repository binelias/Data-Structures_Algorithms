// You are given two strings of the same length s1 and s2 and a string baseStr.

// We say s1[i] and s2[i] are equivalent characters.

// For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
// Equivalent characters follow the usual rules of any equivalence relation:

// Reflexivity: 'a' == 'a'.
// Symmetry: 'a' == 'b' implies 'b' == 'a'.
// Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
// For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

// Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

// Example 1:

// Input: s1 = "parker", s2 = "morris", baseStr = "parser"
// Output: "makkek"
// Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
// The characters in each group are equivalent and sorted in lexicographical order.
// So the answer is "makkek".
// Example 2:

// Input: s1 = "hello", s2 = "world", baseStr = "hold"
// Output: "hdld"
// Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
// So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
// Example 3:

// Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
// Output: "aauaaaaada"
// Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".

// Constraints:

// 1 <= s1.length, s2.length, baseStr <= 1000
// s1.length == s2.length
// s1, s2, and baseStr consist of lowercase English letters.

// Approach:Disjoint Set Union (DSU/Union Find)

// Intuition
// If you're not familiar with DSU, check out our Explore card.

// Another way to find the connected components in a graph is using a Disjoint Set Union (DSU) data structure. Instead of using an adjacency matrix, we will perform a union operation for all the edges. In the end, the nodes that can be converted to each other will be in the same component.

// We also need to find the smallest character in each component. For this, we can change how we generally perform the union operation. While merging two components, we will always make the smaller character representative of the whole merged group.

// Although generally, we perform union by size to have almost constant time (Inverse Ackermann α(n)\alpha(n)α(n) to be precise, which is practically O(1)O(1)O(1)) operations, but owing to the smaller constraints (262626 lowercase English characters), we can still have the constant time complexity. For larger constraints, we can still follow the union by size and have a different method to fetch the components by finding the representative of each character. However, for this problem, we will not use union by size for simplicity and as it's not going to improve the time complexity by much.

// Algorithm
// Iterate over all the characters from 0 until 26, and make each character represent itself in a vector representative.
// Iterate over the characters in s1 and s2 and perform the union operation between the characters at their corresponding positions. In the union, we always make the smaller character the representative.
// Iterate over the characters in the string baseStr and map the characters to their representative by calling the find() operation and create the answer string ans.
// Return ans.

class Solution {
  int representative[] = new int[26];

  // Returns the root representative of the component.
  int find(int x) {
    if (representative[x] == x) {
      return x;
    }

    return representative[x] = find(representative[x]);
  }

  // Perform union if x and y aren't in the same component.
  void performUnion(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return;
    }

    // Make the smaller character representative.
    if (x < y) {
      representative[y] = x;
    } else {
      representative[x] = y;
    }
  }

  public String smallestEquivalentString(String s1, String s2, String baseStr) {
    // Make each character representative of itself.
    for (int i = 0; i < 26; i++) {
      representative[i] = i;
    }

    // Perform union merge for all the edges.
    for (int i = 0; i < s1.length(); i++) {
      performUnion(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
    }

    String ans = "";
    // Create the answer string with final mappings.
    for (char c : baseStr.toCharArray()) {
      ans += (char) (find(c - 'a') + 'a');
    }

    return ans;
  }
}