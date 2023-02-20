# Hackerland is a one-dimensional city with houses aligned at integral locations along a road. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away.

# Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house is within range of at least one transmitter. Each transmitter must be installed on top of an existing house.

# Sample Input 0

# STDIN       Function
# -----       --------
# 5 1         x[] size n = 5, k = 1
# 1 2 3 4 5   x = [1, 2, 3, 4, 5]
# Sample Output 0

# 2
# Explanation 0

# The diagram below depicts our map of Hackerland:

# k-nearest(2).png

# We can cover the entire city by installing 2 transmitters on houses at locations 2 and 4.

# Sample Input 1

# 8 2
# 7 2 4 6 5 9 12 11
# Sample Output 1

# 3
# Explanation 1

# The diagram below depicts our map of Hackerland:

# k-nearest2(2).png

# We can cover the entire city by installing 3 transmitters on houses at locations 4, 9, and 12.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'hackerlandRadioTransmitters' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY x
#  2. INTEGER k
#


def hackerlandRadioTransmitters(x, k):
    # Write your code here
    arr = sorted(x)
    l = len(x)
    pot = arr[0]
    flag = True
    d = 1
    for i in range(l):
        if arr[i]-pot > k:
            if arr[i]-arr[i-1] <= k and flag:
                pot = arr[i-1]
                flag = False
            else:
                pot = arr[i]
                d += 1
                flag = True
    return d


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    x = list(map(int, input().rstrip().split()))

    result = hackerlandRadioTransmitters(x, k)

    fptr.write(str(result) + '\n')

    fptr.close()
