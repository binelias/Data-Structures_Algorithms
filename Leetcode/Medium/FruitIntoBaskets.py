# You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

# You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

# You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
# Starting from any tree of your choice, you must pick exactly one fruit from every tree(including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
# Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
# Given the integer array fruits, return the maximum number of fruits you can pick.


# Example 1:

# Input: fruits = [1, 2, 1]
# Output: 3
# Explanation: We can pick from all 3 trees.
# Example 2:

# Input: fruits = [0, 1, 2, 2]
# Output: 3
# Explanation: We can pick from trees[1, 2, 2].
# If we had started at the first tree, we would only pick from trees[0, 1].
# Example 3:

# Input: fruits = [1, 2, 3, 2, 2]
# Output: 4
# Explanation: We can pick from trees[2, 3, 2, 2].
# If we had started at the first tree, we would only pick from trees[1, 2].


# Constraints:

# 1 <= fruits.length <= 105
# 0 <= fruits[i] < fruits.length

# Sliding Window

# Intuition
# In the previous approach, we keep the window size non-decreasing. However, we might run into cases where the window contains O(n)O(n)O(n) types of fruits and takes O(n)O(n)O(n) space.

# This can be optimized by making sure that there are always at most 2 types of fruits in the window. After adding a new fruit from the right side right, if the current window has more than 2 types of fruit, we keep removing fruits from the left side left until the current window has only 2 types of fruit. Note that the window size may become smaller than before, thus we cannot rely on left and right to keep track of the maximum number of fruits we can collect. Instead, we can just use a variable max_picked to keep track of the maximum window size we encountered.

# img

# For the details on the implementation, let's take a look at the following slides.

# Current


# Algorithm
# Initialize max_picked = 0 as the maximum fruits we can collect, and use hash map basket to record the types of fruits in the current window.
# Start with an empty window having left = 0 and right = 0 as its left and right index.
# We iterate over right and add fruits[right] to this window.
# If there are no more than 2 types of fruits, this subarray is valid.
# Otherwise, we need to keep removing fruits from the left side until there are only 2 types of fruits in the window.
# Then we update max_picked as max(max_picked, right - left + 1).
# Once we finish iterating, return max_picked as the maximum number of fruits we can collect

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        # We use a hash map 'basket' to store the number of each type of fruit.
        basket = {}
        max_picked = 0
        left = 0

        # Add fruit from the right index (right) of the window.
        for right in range(len(fruits)):
            basket[fruits[right]] = basket.get(fruits[right], 0) + 1

            # If the current window has more than 2 types of fruit,
            # we remove fruit from the left index (left) of the window,
            # until the window has only 2 types of fruit.
            while len(basket) > 2:
                basket[fruits[left]] -= 1
                if basket[fruits[left]] == 0:
                    del basket[fruits[left]]
                left += 1

            # Update max_picked.
            max_picked = max(max_picked, right - left + 1)

        # Return max_picked as the maximum number of fruits we can collect.
        return max_picked
