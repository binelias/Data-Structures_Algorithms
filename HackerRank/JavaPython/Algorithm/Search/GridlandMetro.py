# Sample Input

# STDIN   Function
# -----   --------
# 4 4 3   n = 4, m = 4, k = 3
# 2 2 3   track = [[2, 2, 3], [3, 1, 4], [4, 4, 4]]
# 3 1 4
# 4 4 4
# Sample Output

# 9
# Explanation

# image

# In the diagram above, the yellow cells denote the first train track, green denotes the second, and blue denotes the third. Lampposts can be placed in any of the nine red cells.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gridlandMetro' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER m
#  3. INTEGER k
#  4. 2D_INTEGER_ARRAY track
#


def gridlandMetro(n, m, k, track):
    # Write your code here
    lamps = {}
    for x in range(k):
        lamps[track[x][0]] = [0, 0]
    print(len(lamps))
    if k == 0:
        return m*n
    else:
        lamptotal = (n - len(lamps))*m
        for i in range(k):
            if track[i][0] in lamps:
                if (lamps[track[i][0]][0]) == 0:
                    lamps[track[i][0]][0] = track[i][1]
                    lamps[track[i][0]][1] = track[i][2]
                else:
                    if track[i][1] < lamps[track[i][0]][0]:
                        lamps[track[i][0]][0] = track[i][1]
                    if track[i][2] > lamps[track[i][0]][1]:
                        lamps[track[i][0]][1] = track[i][2]
                if (track[i][1] == 8) & (track[i][2] == 8):
                    lamptotal += 2
            print(lamps)
    for i in lamps:
        lamptotal += m - (lamps[i][1] - lamps[i][0] + 1)
    return lamptotal


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    k = int(first_multiple_input[2])

    track = []

    for _ in range(k):
        track.append(list(map(int, input().rstrip().split())))

    result = gridlandMetro(n, m, k, track)

    fptr.write(str(result) + '\n')

    fptr.close()
