# Sample Input

# STDIN   Function
# -----   --------
# 1       t = 1
# 5       n = 5
# ebacd   grid = ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
# fghij
# olmkn
# trpqs
# xywuv
# Sample Output

# YES
# Explanation

# The 5x5 grid in the 1 test case can be reordered to

# abcde
# fghij
# klmno
# pqrst
# uvwxy
# This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all alphabetically sorted.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gridChallenge' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING_ARRAY grid as parameter.
#

def gridChallenge(grid):
    # Write your code here
    for i in range(len(grid[0])):
        for j in range(len(grid)-1):
            if ord(grid[j][i]) > ord(grid[j+1][i]):
                return "NO"
    return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        grid = []

        for _ in range(n):
            grid_item = input()
            grid.append(grid_item)

        result = gridChallenge(grid)

        fptr.write(result + '\n')

    fptr.close()
