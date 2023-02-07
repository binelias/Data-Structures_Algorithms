# from indices nnn to 2∗n−12 * n - 12∗n−1. The elements of xxx should be placed at indices 0, 2, 4, .... At nums[i] we have element xi+1x_{i + 1}x
# Given the array nums consisting of 2n elements in the form[x1, x2, ..., xn, y1, y2, ..., yn].

# Return the array in the form[x1, y1, x2, y2, ..., xn, yn].


# Example 1:

# Input: nums = [2, 5, 1, 3, 4, 7], n = 3
# Output: [2, 3, 5, 4, 1, 7]
# Explanation: Since x1 = 2, x2 = 5, x3 = 1, y1 = 3, y2 = 4, y3 = 7 then the answer is [2, 3, 5, 4, 1, 7].
# Example 2:

# Input: nums = [1, 2, 3, 4, 4, 3, 2, 1], n = 4
# Output: [1, 4, 2, 3, 3, 2, 4, 1]
# Example 3:

# Input: nums = [1, 1, 2, 2], n = 2
# Output: [1, 2, 1, 2]


# Constraints:

# 1 <= n <= 500
# nums.length == 2n
# 1 <= nums[i] <= 10 ^ 3

# Simple Iteration
# Intuition
# Let us start by trying to identify some patterns in the original array, The elements from x1x_1x
# 1
# ​
# to xnx_nx
# n
# ​
# exist from indices 000 to n−1n - 1n−1 and elements from y1y_1y
# 1
# ​
# to yny_ny
# n
# ​
# i+1
# ​
# , we should place it at index 2∗i2 * i2∗i for all 0≤i < n0 \le i \lt n0≤i < n.

# The elements of yyy should be placed at indices 1, 3, 5, .... At nums[n + i] we have element yi+1y_{i + 1}y
# i+1
# ​
# , we should place it at index 2∗i+12 * i + 12∗i+1 for all 0≤i < n0 \le i \lt n0≤i < n. Notice that it is the same formula as the previous one but with a + 1, indicating that elements of yyy come after elements of xxx.

# places

# One of the intuitive ways to solve this is to have an extra array result\text{result}result of size 2∗n2 * n2∗n, then iterate over nums\text{nums}nums and place each of its elements at the respective positions in result\text{result}result.

# Algorithm
# Build an array result of size 2 * n.
# Iterate over the nums array ranging from indices 0 to n - 1:
# Store the element xi+1x_{i + 1}x
# i+1
# ​
#     , that is , nums[i] at index 2 * i,
# and element yi+1y_{i + 1}y
# i+1
# ​
#     , that is , nums[i + n] at index 2 * i + 1 in result.
# Return the result array.

class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        result = [0] * (2 * n)
        for i in range(n):
            result[2 * i] = nums[i]
            result[2 * i + 1] = nums[n + i]
        return result
