# Sample Input 0

# 4 0
# 4 4
# Sample Output 0

# 9
# Explanation 0

# The queen is standing at position  on a  chessboard with no obstacles:

# image

# Sample Input 1

# 5 3
# 4 3
# 5 5
# 4 2
# 2 3
# Sample Output 1

# 10
# Explanation 1

# The queen is standing at position  on a  chessboard with  obstacles:

# image

# The number of squares she can attack from that position is .

# Sample Input 2

# 1 0
# 1 1
# Sample Output 2

# 0
# Explanation 2

# Since there is only one square, and the queen is on it, the queen can move 0 squares.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'queensAttack' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER k
#  3. INTEGER r_q
#  4. INTEGER c_q
#  5. 2D_INTEGER_ARRAY obstacles
#


def queensAttack(n, k, r_q, c_q, obstacles):
    # Write your code here
    obset = set(map(tuple, obstacles))
    count = 0
    directions = ((1, 0), (-1, 0), (0, -1), (0, 1),
                  (1, 1), (-1, 1), (1, -1), (-1, -1))
    # up down left right upright downright upleft downleft
    for d in directions:
        row = r_q
        column = c_q
        while 0 < row <= n and 0 < column <= n:
            row += d[0]
            column += d[1]
            if 0 < row <= n and 0 < column <= n and (row, column) not in obset:
                count += 1
            else:
                break
    return count


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    second_multiple_input = input().rstrip().split()

    r_q = int(second_multiple_input[0])

    c_q = int(second_multiple_input[1])

    obstacles = []

    for _ in range(k):
        obstacles.append(list(map(int, input().rstrip().split())))

    result = queensAttack(n, k, r_q, c_q, obstacles)

    fptr.write(str(result) + '\n')

    fptr.close()
