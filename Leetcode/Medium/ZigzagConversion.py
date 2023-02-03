# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

# P   A   H   N
# A P L S I I G
# Y   I   R
# And then read line by line: "PAHNAPLSIIGYIR"

# Write the code that will take a string and make this conversion given a number of rows:

# string convert(string s, int numRows);


# Example 1:

# Input: s = "PAYPALISHIRING", numRows = 3
# Output: "PAHNAPLSIIGYIR"
# Example 2:

# Input: s = "PAYPALISHIRING", numRows = 4
# Output: "PINALSIGYAHRPI"
# Explanation:
# P     I    N
# A   L S  I G
# Y A   H R
# P     I
# Example 3:

# Input: s = "A", numRows = 1
# Output: "A"


# Constraints:

# 1 <= s.length <= 1000
# s consists of English letters (lower-case and upper-case), ',' and '.'.
# 1 <= numRows <= 1000
# Accepted
# 969.7K
# Submissions
# 2.2M
# Acceptance Rate
# 44.5%

# String Traversal
# Intuition
# The previous approach will be accepted, the interviewer doesn't expect us to give this solution but we are listing it as there is still room for some optimization, it can get hard to visualize so we will take it one step at a time so keep the pace with us.

# We were storing the string in a zig-zag pattern using some additional space. Look at each row of the completed matrix. If we notice carefully there is a pattern between the distances between characters in each row. If we analyze the jump pattern and traverse the input string using that pattern we can avoid the use of additional space.

# question

# In the above image, you can see, (each color denotes one row of our previously traversed matrix when mapping it in input string) in jumps denoted by pink arrows, first, we jump 6 steps then 2, then 6, and then again 2.
# Similarly, there is a pattern for all colors. Let's start analyzing this pattern using the same filled matrix.

# Notice in the below image the first and last rows we jump to the same position in the next section, i.e. we jump (number of characters) positions in each section.

# question

# But in the rest of the rows, we must traverse to the next corresponding element of the same section before jumping to the next section.

# question

# The hard part will be to calculate how to jump to the next character.

# If we have to jump to the next section then it's simple: we only jump charsInSection\text{charsInSection}charsInSection characters.
# So, currIndex += charsInSection\text{currIndex += charsInSection}currIndex += charsInSection.

# If we have to jump to the next character in the same section, then we will have to calculate how many characters are between these two positions and increment currIndex\text{currIndex}currIndex by that value.
# If the total characters in a section are charsInSection\text{charsInSection}charsInSection and we are in the ith\text{i}^{th}i
# th
#   row, then the number of characters above the current row will be 2∗i\text{2} * \text{i}2∗i, and the number of characters left will be charsInBetween = charsInSection - 2∗i\text{charsInBetween = charsInSection - 2} * \text{i}charsInBetween = charsInSection - 2∗i.
# So, secondIndex = currIndex + charsInBetween\text{secondIndex = currIndex + charsInBetween}secondIndex = currIndex + charsInBetween.

# question

# Thus, we can iterate over the input string in line-by-line order after writing it in a zig-zag pattern directly.

# Algorithm
# Initialize variables:

# answer, an empty string to store the final result.
# n, length of the input string.
# charsInSection, to store the number of characters in each section we defined.
# Iterate on each row from numRows:

# index will start at the first character in the current row, i.e. index is equal to currRow.
# We will traverse in the current row and append all characters to the answer string. First, we append the first character of the current section. If the current row is not the first or last row then we append the second character of the current section. Then update the index to jump to the next section in the current row and repeat this process again.
# Return answer.

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        answer = []
        n = len(s)
        chars_in_section = 2 * (numRows - 1)

        for curr_row in range(numRows):
            index = curr_row
            while index < n:
                answer.append(s[index])

                # If curr_row is not the first or last row,
                # then we have to add one more character of current section.
                if curr_row != 0 and curr_row != numRows - 1:
                    chars_in_between = chars_in_section - 2 * curr_row
                    second_index = index + chars_in_between

                    if second_index < n:
                        answer.append(s[second_index])
                # Jump to same row's first character of next section.
                index += chars_in_section

        return "".join(answer)
