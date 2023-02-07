#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'knightlOnAChessboard' function below.
#
# The function is expected to return a 2D_INTEGER_ARRAY.
# The function accepts INTEGER n as parameter.
#


def moveNight(a, b, n, loc):
    for dx, dy in [[a, b], [b, a]]:
        for sx, sy in [[1, 1], [-1, 1], [1, -1], [-1, -1]]:
            x = loc[0] + dx * sx
            y = loc[1] + dy * sy
            if any([x < 0, y < 0, x > n-1, y > n-1]):
                # Out of bounds
                continue
            yield x, y


def breadthF(a, b, n):
    traveled = set(((0, 0),))
    level = set(((0, 0),))
    d = 1
    while level:
        newLevel = set()
        for loc in level:
            for x, y in moveNight(a, b, n, loc):
                if (x, y) == (n-1, n-1):
                    return d
                if (x, y) not in traveled:
                    traveled.add((x, y))
                    newLevel.add((x, y))

        level = newLevel
        d += 1

    return -1


def knightlOnAChessboard(n):
    # Write your code here
    # Loop rows and columns
    ans = [[breadthF(row, col, n) for col in range(1, n)]
           for row in range(1, n)]
    return ans


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    result = knightlOnAChessboard(n)

    fptr.write('\n'.join([' '.join(map(str, x)) for x in result]))
    fptr.write('\n')

    fptr.close()
