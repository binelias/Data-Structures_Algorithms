# Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).


# Example 1:

# Input: low = 3, high = 7
# Output: 3
# Explanation: The odd numbers between 3 and 7 are [3,5,7].
# Example 2:

# Input: low = 8, high = 10
# Output: 1
# Explanation: The odd numbers between 8 and 10 are [9].

# Constraints:

# 0 <= low <= high <= 10^9

# Intuition

# In a range of contiguous numbers, we know that evens and odds are equally divided.

# Approach

# The only edge cases will be to check whether low and high belong to odd category. Other odds will be (high-low)//2

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        ans = 0
        if low % 2 != 0:
            ans += 1
        elif high % 2 != 0:
            ans += 1

        return ans + (high-low)//2
