# Sample Input

# 3
# 2 3
# *.M
# .X.
# 1
# 4 11
# .X.X......X
# .X*.X.XXX.X
# .XX.X.XM...
# ......XXXX.
# 3
# 4 11
# .X.X......X
# .X*.X.XXX.X
# .XX.X.XM...
# ......XXXX.
# 4
# Sample Output

# Impressed
# Impressed
# Oops!

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countLuck' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING_ARRAY matrix
#  2. INTEGER k
#

def countLuck(matrix, k):
    # Write your code here
    d = {}
    
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if matrix[i][j] in ('.', '*', 'M'):
                d[(i, j)] = matrix[i][j]
            
            if matrix[i][j] == 'M':
                q = [(i, j, [0])]
                v = [(i, j)]
                
    while q:
        i, j, p = q.pop(0)
        
        if d[(i, j)] == '*':
            if p[0] == k:
                return 'Impressed'
            else:
                return 'Oops!'
        
        n = len(v)
        p = list(p)
        
        for x, y in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
            x += i
            y += j
            
            if (x, y) in d and (x, y) not in v:
                v.append((x, y))
                q.append((x, y, p))
                
        if (len(v) - n) > 1:
            p[0] += 1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        matrix = []

        for _ in range(n):
            matrix_item = input()
            matrix.append(matrix_item)

        k = int(input().strip())

        result = countLuck(matrix, k)

        fptr.write(result + '\n')

    fptr.close()
