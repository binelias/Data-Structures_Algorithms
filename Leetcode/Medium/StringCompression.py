# Given an array of characters chars, compress it using the following algorithm:

# Begin with an empty string s. For each group of consecutive repeating characters in chars:

# If the group's length is 1, append the character to s.
# Otherwise, append the character followed by the group's length.
# The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

# After you are done modifying the input array, return the new length of the array.

# You must write an algorithm that uses only constant extra space.


# Example 1:

# Input: chars = ["a","a","b","b","c","c","c"]
# Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
# Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
# Example 2:

# Input: chars = ["a"]
# Output: Return 1, and the first character of the input array should be: ["a"]
# Explanation: The only group is "a", which remains uncompressed since it's a single character.
# Example 3:

# Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
# Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
# Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

# Constraints:

# 1 <= chars.length <= 2000
# chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.


# Intuition of this Problem:
# The implementation uses two pointers, i and j, to traverse the character array. The variable i is used to iterate over the array, while j is used to keep track of the position to which the compressed character needs to be written. The variable prev is used to store the previous character encountered, and count is used to keep track of the number of consecutive occurrences of the current character.

# Approach for this Problem:
# Initialize two pointers, i and j, to 0. Pointer i will be used to traverse the input array, while pointer j will be used to modify the array in place.
# While i is less than the length of the input array, do the following:
# a. Initialize a variable count to 1. This variable will keep track of the number of consecutive repeating characters in the input array.
# b. While i is less than the length of the input array minus 1, and the character at index i is equal to the character at index i+1, increment count and i.
# c. Write the character at index i to the output array at index j, and increment both i and j.
# d. If count is greater than 1, convert it to a string and write each character of the string to the output array at index j, incrementing j for each character.
# Return j, which is the length of the compressed array.

class Solution:
    def compress(self, chars: List[str]) -> int:
        n = len(chars)
        if n == 1:
            return 1

        i = 0
        j = 0

        while i < n:
            count = 1
            while i < n - 1 and chars[i] == chars[i+1]:
                count += 1
                i += 1

            chars[j] = chars[i]
            j += 1

            if count > 1:
                for c in str(count):
                    chars[j] = c
                    j += 1

            i += 1

        return j
