# Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

# A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.


# Example 1:

# Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
# Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
# Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
# "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
# "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
# Example 2:

# Input: words = ["cat","dog","catdog"]
# Output: ["catdog"]

# Constraints:

# 1 <= words.length <= 104
# 1 <= words[i].length <= 30
# words[i] consists of only lowercase English letters.
# All the strings of words are unique.
# 1 <= sum(words[i].length) <= 105

# DFS
# Intuition
# As mentioned before, this problem can be transformed into a reachability problem and thus can be solved by a DFS (or BFS) algorithm. For each word, we construct a directed graph with all prefixes as nodes. For simplicity, we can represent each prefix by its length.

# So the graph contains (word.length + 1) nodes. For edges, consider 2 prefixes i and j with 0 <= i < j <= word.length, if prefix j can be created by concatenating prefix i and a word in the dictionary, we add a directed edge from node i to node j.

# When i = 0, we require j < word.length as there should be an edge from node 0 to node word.length. Determining whether a word can be created by concatenating 2 or more words in the dictionary is the same as determining whether there is a path from node 0 to node word.length in the graph.

# Algorithm
# For each word, construct the implicit graph mentioned above, then add it to the answer if the node word.length can be reached from node 0 in the graph which can be checked using DFS.

class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        dictionary = set(words)
        answer = []
        for word in words:
            length = len(word)
            dp = [False] * (length + 1)
            dp[0] = True

            for i in range(1, length+1):
                for j in range((i == length) and 1 or 0, i):
                    if not dp[i]:
                        dp[i] = dp[j] and word[j:i] in dictionary
            if dp[length]:
                answer.append(word)
        return answer
