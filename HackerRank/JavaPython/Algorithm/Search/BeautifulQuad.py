#!/bin/python3

import os
import sys

#
# Complete the beautifulQuadruples function below.
#


def beautifulQuadruples(a, b, c, d):
    # Write your code here.
    # remember if a^b^c^d = 0 then a^b = c^d, therefore sort values
    # to avoid duplications

    a, b, c, d = sorted([a, b, c, d])

    # maximum value possible after xor of any two nums
    max_v = 2 ** (len(bin(d))-2)

    # store count of i^j from current row plus bottom row, Memoization
    cnt = [[0]*max_v for i in range(c+1)]

    # store total xor combinations of c^d, Memoization
    total = [0]*(c+1)

    for i in reversed(range(1, c+1)):
        for j in range(i, d+1):
            cnt[i][i ^ j] += 1
        total[i] = d-i+1

        # if not last row, add details of row below
        if i != c:
            for k in range(max_v):
                cnt[i][k] += cnt[i+1][k]
            total[i] += total[i+1]

    # zero stores xor combination with zero values
    # all_perm store total xor combinations possible of a^b^c^d
    zero = all_perm = 0
    for i in range(1, a+1):
        for j in range(i, b+1):

            # adding cnt[j][i^j] to zero as i^j appears cnt[j][i^j] times for all c >= j
            zero += cnt[j][i ^ j]

            # adding all permutations possible with c >= j
            all_perm += total[j]

    return all_perm - zero


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    abcd = input().split()

    a = int(abcd[0])

    b = int(abcd[1])

    c = int(abcd[2])

    d = int(abcd[3])

    result = beautifulQuadruples(a, b, c, d)

    fptr.write(str(result) + '\n')

    fptr.close()
