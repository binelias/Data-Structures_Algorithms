# Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumLoss' function below.
#
# The function is expected to return an INTEGER.
# The function accepts LONG_INTEGER_ARRAY price as parameter.
#


def minimumLoss(price):
    # Write your code here
    d = {}
    for i in range(len(price)):
        d[price[i]] = i
    price = sorted(price, reverse=True)
    mi = max(price)
    for i in range(1, len(price)):
        if d[price[i - 1]] < d[price[i]] and price[i-1] - price[i] < mi:
            mi = price[i - 1] - price[i]
    return mi


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    price = list(map(int, input().rstrip().split()))

    result = minimumLoss(price)

    fptr.write(str(result) + '\n')

    fptr.close()
