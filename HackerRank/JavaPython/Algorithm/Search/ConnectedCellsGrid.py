# Sample Input

# STDIN       Function
# -----       --------
# 4           n = 4
# 4           m = 4
# 1 1 0 0     grid = [[1, 1, 1, 0], [0, 1, 1, 0], [0, 0, 1, 0], [1, 0, 0, 0]]
# 0 1 1 0
# 0 0 1 0
# 1 0 0 0
# Sample Output

# 5
# Explanation

# The diagram below depicts two regions of the matrix. Connected regions are filled with X or Y. Zeros are replaced with dots for clarity.

# X X . .
# . X X .
# . . X .
# Y . . .
# The larger region has 5 cells, marked X.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'connectedCell' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY matrix as parameter.
#


def connectedCell(matrix):
    # Write your code here
    print(matrix)
    reg = []
    c = [(-1, -1), (-1, 0), (-1, 1), (0, -1)]
    for y, line in enumerate(matrix):
        for x, point in enumerate(line):
            f = 0
            if point == 1:
                if not reg:
                    reg.append([(y, x)])
                else:
                    for num, el in enumerate(reg):
                        for p in el:
                            for y1, x1 in c:
                                if (y + y1, x + x1) == p:
                                    reg[num].append((y, x))
                                    f = 1
                                    break
                            if f == 1:
                                break
                    else:
                        reg.append([(y, x)])
    while True:
        f = 0
        for i in range(len(reg) - 1):
            for k in range(i + 1, len(reg)):
                if set(reg[i]) & set(reg[k]):
                    reg.append(set(reg[i]) | set(reg[k]))
                    reg.pop(k)
                    reg.pop(i)
                    f = 1
                    break
        if f == 0:
            break
    return max(map(len, reg))


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    m = int(input().strip())

    matrix = []

    for _ in range(n):
        matrix.append(list(map(int, input().rstrip().split())))

    result = connectedCell(matrix)

    fptr.write(str(result) + '\n')

    fptr.close()
