# Sample Input

# 20
# 0 ab
# 6 cd
# 0 ef
# 6 gh
# 4 ij
# 0 ab
# 6 cd
# 0 ef
# 6 gh
# 0 ij
# 4 that
# 3 be
# 0 to
# 1 be
# 5 question
# 1 or
# 2 not
# 4 is
# 2 to
# 4 the
# Sample Output

# - - - - - to be or not to be - that is the question - - - -
# Explanation

# The correct order is shown below. In the array at the bottom, strings from the first half of the original array were replaced with dashes.

# 0 ab
# 0 ef
# 0 ab
# 0 ef
# 0 ij
# 0 to
# 1 be
# 1 or
# 2 not
# 2 to
# 3 be
# 4 ij
# 4 that
# 4 is
# 4 the
# 5 question
# 6 cd
# 6 gh
# 6 cd
# 6 gh
# sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], ['-', 'that', 'is', 'the'], ['question'], ['-', '-', '-', '-'], [], [], [], []]


#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countSort' function below.
#
# The function accepts 2D_STRING_ARRAY arr as parameter.
#


def countSort(arr):
    # Write your code here
    n = len(arr)
    mid = n // 2
    ar = [''] * n
    for i in range(n):
        ar[int(arr[i][0])] += "- " if i < mid else arr[i][1] + " "

    for i in range(n):
        print(ar[i], end='')


if __name__ == '__main__':
    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(input().rstrip().split())

    countSort(arr)
