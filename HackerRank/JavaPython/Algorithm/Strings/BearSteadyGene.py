# Sample Input

# 8
# GAAATAAA
# Sample Output

# 5
# Explanation

# One optimal solution is to replace AAATA with TTCCG resulting in GTTCCGAA.
# The replaced substring has length 5.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'steadyGene' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING gene as parameter.
#


def steadyGene(gene):
    # Write your code here
    maps = {}
    length = len(gene)
    qlength = length//4
    for char in gene:
        maps[char] = 1+maps.get(char, 0)

    def isViolate(maps):
        for value in maps.values():
            if value > qlength:
                return True
        return False
    if not isViolate(maps):
        return 0
    right, left = 0, 0
    result = float("inf")
    while right < length:
        while right < length and isViolate(maps):
            maps[gene[right]] -= 1
            right += 1
        while left < length and not isViolate(maps):
            maps[gene[left]] += 1
            left += 1
        result = min(result, right-left+1)
    return result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    gene = input()

    result = steadyGene(gene)

    fptr.write(str(result) + '\n')

    fptr.close()
