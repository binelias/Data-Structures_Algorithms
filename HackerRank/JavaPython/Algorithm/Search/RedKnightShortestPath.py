# In ordinary chess, the pieces are only of two colors, black and white. In our version of chess, we are including new pieces with unique movements. One of the most powerful pieces in this version is the red knight.

# The red knight can move to six different positions based on its current position (UpperLeft, UpperRight, Right, LowerRight, LowerLeft, Left) as shown in the figure below.


# Output Format

# If the destination can be reached, print two lines. In the first line, print a single integer denoting the minimum number of moves that the red knight has to make in order to reach the destination. In the second line, print the space-separated sequence of moves.

# If the destination cannot be reached, print a single line containing only the word Impossible.

# Sample Input 0

# 7
# 6 6 0 1
# Sample Output 0

# 4
# UL UL UL L
# Explanation 0

# image

# Sample Input 1

# 6
# 5 1 0 5
# Sample Output 1

# Impossible


# Sample Input 2

# 7
# 0 3 4 3
# Sample Output 2

# 2
# LR LL


#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'printShortestPath' function below.
#
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER i_start
#  3. INTEGER j_start
#  4. INTEGER i_end
#  5. INTEGER j_end
#


def backtrackPath(arr, i_end, j_end):
    path = []
    que = [arr[i_end][j_end]]

    while que:
        i, j, dirc = que.pop(0)
        if i != -1 and j != -1 and dirc != -1:
            path.append(dirc)
            que.append(arr[i][j])

    return " ".join(path[::-1])


def printShortestPath(n, i_start, j_start, i_end, j_end):
    # Print the distance along with the sequence of moves.
    que = [[i_start, j_start, 0]]

    vis = [[0 for i in range(n)]for j in range(n)]
    vis[i_start][j_start] = 1

    # predecessor array to remember path
    pre = [[-1 for i in range(n)]for j in range(n)]
    pre[i_start][j_start] = [-1, -1, -1]

    path = []
    while que:
        row, col, step = que.pop(0)

        if row == i_end and col == j_end:
            path = backtrackPath(pre, i_end, j_end)
            print(f'{step}\n{path}')
            return

        neighbours = [[row-2, col-1, "UL"], [row-2, col+1, "UR"], [row, col+2,
                                                                   "R"], [row+2, col+1, "LR"], [row+2, col-1, "LL"], [row, col-2, "L"]]

        for nrow, ncol, dirc in neighbours:
            if nrow >= 0 and nrow < n and ncol >= 0 and ncol < n and vis[nrow][ncol] == 0:
                vis[nrow][ncol] = 1
                que.append([nrow, ncol, step+1])
                pre[nrow][ncol] = [row, col, dirc]

    print("Impossible")


if __name__ == '__main__':
    n = int(input().strip())

    first_multiple_input = input().rstrip().split()

    i_start = int(first_multiple_input[0])

    j_start = int(first_multiple_input[1])

    i_end = int(first_multiple_input[2])

    j_end = int(first_multiple_input[3])

    printShortestPath(n, i_start, j_start, i_end, j_end)
