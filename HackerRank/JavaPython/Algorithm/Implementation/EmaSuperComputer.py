# Ema built a quantum computer! Help her test its capabilities by solving the problem below.

# Given a grid of size n x m, each cell in the grid is either good or bad.

# A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

# In the diagram below, the blue pluses are valid and the orange ones are not valid.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'twoPluses' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING_ARRAY grid as parameter.
#


def twoPluses(grid):
    # Write your code here
    plusses = []
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] != 'B':
                max_plus_length = min(
                    (len(grid)-1)//2, (len(grid[0])-1)//2, i, j, len(grid)-i-1, len(grid[0])-j-1)
                plus = set()
                plus.add((i, j))
                plusses.append(plus)
                for k in range(1, max_plus_length+1):
                    if grid[i-k][j] == 'G' and \
                       grid[i+k][j] == 'G' and \
                       grid[i][j-k] == 'G' and \
                       grid[i][j+k] == 'G':
                        plus.add((i-k, j))
                        plus.add((i+k, j))
                        plus.add((i, j-k))
                        plus.add((i, j+k))
                    else:
                        break
                    subplus = plus.copy()
                    plusses.append(subplus)

    max_area_product = 0
    for pi in plusses:
        for pj in plusses:
            if not pi.intersection(pj):
                max_area_product = max(max_area_product, len(pi)*len(pj))

    return max_area_product


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    grid = []

    for _ in range(n):
        grid_item = input()
        grid.append(grid_item)

    result = twoPluses(grid)

    fptr.write(str(result) + '\n')

    fptr.close()
