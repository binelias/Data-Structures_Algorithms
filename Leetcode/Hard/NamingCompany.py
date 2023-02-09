# You are given an array of strings ideas that represents a list of names to be used in the process of naming a company. The process of naming a company is as follows:

# Choose 2 distinct names from ideas, call them ideaA and ideaB.
# Swap the first letters of ideaA and ideaB with each other.
# If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
# Otherwise, it is not a valid name.
# Return the number of distinct valid names for the company.


# Example 1:

# Input: ideas = ["coffee","donuts","time","toffee"]
# Output: 6
# Explanation: The following selections are valid:
# - ("coffee", "donuts"): The company name created is "doffee conuts".
# - ("donuts", "coffee"): The company name created is "conuts doffee".
# - ("donuts", "time"): The company name created is "tonuts dime".
# - ("donuts", "toffee"): The company name created is "tonuts doffee".
# - ("time", "donuts"): The company name created is "dime tonuts".
# - ("toffee", "donuts"): The company name created is "doffee tonuts".
# Therefore, there are a total of 6 distinct company names.

# The following are some examples of invalid selections:
# - ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
# - ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
# - ("coffee", "toffee"): Both names formed after swapping already exist in the original array.
# Example 2:

# Input: ideas = ["lack","back"]
# Output: 0
# Explanation: There are no valid selections. Therefore, 0 is returned.


# Constraints:

# 2 <= ideas.length <= 5 * 104
# 1 <= ideas[i].length <= 10
# ideas[i] consists of lowercase English letters.
# All the strings in ideas are unique.

# Group words by their initials
# Intuition
# Let's start with the most intuitive solution, which is to try every pair of words and count the number of valid names created, as shown in the picture below. (The x2 is to indicate that a pair of words forms two valid names, one for each ordering, take the first swap as an example, if we can swap coffee with donuts to generate a valid name, we can also swap donuts with coffee to generate the second valid name).

# img

# However, given the size of the input array ideas as nnn, we need to try O(n2)O(n ^ 2)O(n
#                                                                                        2
#                                                                                        ) pairs of words. This approach is likely to exceed the time limit, implying that we should look for a better approach.

# We notice that if two words have the same initial letter, swapping them will not create any new word.

# img

# Hence, we can group the suffixes of all words in ideas by their initials, take apple as an example, we store pple in a set marked with the letter a.

# Since swapping any two words from the same group always creates two invalid names, we only need to try swapping words from two different groups.

# img

# For two groups with initial letters a and b, if a suffix suffix is contained by both groups, then swapping a + suffix with any other words in group b is invalid, as the new name b + suffix is already in group b. Similarly, swapping b + suffix with any other words in group a is invalid as well since a + suffix is already in group a.

# Here a and b are variables representing letters, not the literals "a" and "b"

# Hence, two words a + suffix_a and b + suffix_b can be swapped to generate two new names only if their suffixes are distinct, that is , neither suffix_a is in group b nor suffix_b is in group a.

# img

# Therefore, we need to try every pair of initial letters a and b, then find the numbers of distinct suffixes in both groups. We can swap every distinct suffix in group a with every distinct suffix in group b to make two valid company names.

# We can get the number of distinct suffixes by first getting the number of mutual suffixes num_of_mutual in both groups. The number of distinct suffixes equals the size of one group minus num_of_mutual.


# Algorithm
# Group words in ideas by their initials in initial_group, an array of sets of length 26, and initialize answer as 0.

# Iterate over every pair of groups. For each group i and j, get the number of suffixes num_of_mutual that appears in both groups.

# We can swap every distinct suffix in group i with every distinct suffix in group j, increment answer by 2 * (len(group[i]) - num_of_mutual) * (len(group[j]) - num_of_mutual)

# Return answer.

class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        initial_groups = [set() for _ in range(26)]
        for idea in ideas:
            initial_groups[ord(idea[0]) - ord('a')].add(idea[1:])

        answer = 0
        # Calculate number of valid names from every pair of groups.
        for i in range(25):
            for j in range(i + 1, 26):
                # Get the number of mutual suffixes.
                num_of_mutual = len(initial_groups[i] & initial_groups[j])

                # Valid names are only from distinct suffixes in both groups.
                # Since we can swap a with b and swap b with a to create two valid names, multiple answer by 2.
                answer += 2 * \
                    (len(initial_groups[i]) - num_of_mutual) * \
                    (len(initial_groups[j]) - num_of_mutual)

        return answer
