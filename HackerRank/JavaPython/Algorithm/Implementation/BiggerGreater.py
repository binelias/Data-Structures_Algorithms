# Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

# Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

# It must be greater than the original word
# It must be the smallest word that meets the first condition


# Sample Input 0

# 5
# ab
# bb
# hefg
# dhck
# dkhc
# Sample Output 0

# ba
# no answer
# hegf
# dhkc
# hcdk
# Explanation 0

# Test case 1:
# ba is the only string which can be made by rearranging ab. It is greater.
# Test case 2:
# It is not possible to rearrange bb and get a greater string.
# Test case 3:
# hegf is the next string greater than hefg.
# Test case 4:
# dhkc is the next string greater than dhck.
# Test case 5:
# hcdk is the next string greater than dkhc.

# Sample Input 1

# 6
# lmno
# dcba
# dcbb
# abdc
# abcd
# fedcbabcd
# Sample Output 1

# lmon
# no answer
# no answer
# acbd
# abdc
# fedcbabdc

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'biggerIsGreater' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING w as parameter.
#


def biggerIsGreater(w):
    # Write your code here
    if len(w) <= 1:
        return "no answer"
    w = list(w)
    curr = len(w) - 2
    while(curr != -1):
        subLst = w[curr+1:]
        subLst.sort()
        w[curr+1:] = subLst
        back = curr+1
        while(back != len(w)):
            if(w[curr] < w[back]):
                w[curr], w[back] = w[back], w[curr]
                return "".join(w)
            else:
                back += 1
        curr -= 1
    return "no answer"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    T = int(input().strip())

    for T_itr in range(T):
        w = input()

        result = biggerIsGreater(w)

        fptr.write(result + '\n')

    fptr.close()
