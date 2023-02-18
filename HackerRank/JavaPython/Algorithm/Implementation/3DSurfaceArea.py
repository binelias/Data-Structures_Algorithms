# Sample Input 0

# 1 1
# 1
# Sample Output 0

# 6
# Explanation 0

# The surface area of  cube is 6.

# Sample Input 1

# 3 3
# 1 3 4
# 2 2 3
# 1 2 4
# Sample Output 1

# 60

# Explanation 1

# The object is rotated so the front row matches column 1 of the input, heights 1, 2, and 1.

# The front face is 1 + 2 + 1 = 4 units in area.
# The top is 3 units.
# The sides are 4 units.
# None of the rear faces are exposed.
# The underside is 3 units.
# The front row contributes 4 + 3 + 4 + 3 = 14 units to the surface area.

#!/bin/python3

import math
import os
import random
import re
import sys
import itertools
#
# Complete the 'surfaceArea' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY A as parameter.
#


def calc_matrix(A):
    surface = []
    for i in range(0, len(A)):
        surface.append(A[i][0])
        for j in range(1, len(A[i])):
            if A[i][j] > A[i][j-1]:
                surface[i] += A[i][j] - A[i][j-1]
            elif A[i][j] < A[i][j-1]:
                surface[i] += A[i][j-1] - A[i][j]
        surface[i] += A[i][len(A[i])-1]
    return(surface)


def surfaceArea(A):
    # Write your code here
    top_down = len(A)*len(A[0])
    surface_one = calc_matrix(A)
    tran_surface = calc_matrix(
        list(map(list, itertools.zip_longest(*A, fillvalue=0))))
    return(sum(surface_one)+sum(tran_surface)+2*top_down)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    H = int(first_multiple_input[0])

    W = int(first_multiple_input[1])

    A = []

    for _ in range(H):
        A.append(list(map(int, input().rstrip().split())))

    result = surfaceArea(A)

    fptr.write(str(result) + '\n')

    fptr.close()
