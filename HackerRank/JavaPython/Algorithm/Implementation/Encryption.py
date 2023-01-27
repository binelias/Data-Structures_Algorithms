# An English text needs to be encrypted using the following encryption scheme.
# First, the spaces are removed from the text. Let  be the length of this text.
# Then, characters are written into a grid, whose rows and columns have the following constraints:

# Explanation 0
# L = 12, (12)^1/2 is between 3 and 4.
# Rewritten with 3 rows and 4 columns:
# have
# anic
# eday

# Sample Input 1
# feedthedog

# Sample Output 1
# fto ehg ee dd

# Explanation 1
# L = 10, (10)^1/2  is between 3 and 4.
# Rewritten with 3 rows and 4 columns:

# feed
# thed
# og

# Sample Input 2
# chillout

# Sample Output 2
# clu hlt io

# Explanation 2
# L = 8, (8)^1/2 is between 2 and 3.
# Rewritten with 3 columns 3 and rows (2*3 = 6<8 so we have to use 3X3.)

# chi
# llo
# ut

# Algorithm: We first calculate the number of rows and columns needed for the rearranged string using the length of the original string and some basic math. Next check to ensure that the the area(rows*cols) >= L, if its not add 1 to rows.

# Finally, we iterate over each column index and appends every cols character from the string to a result string. A space is added after each column is processed. The function then returns the result string.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'encryption' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#


def encryption(s):
    # Write your code here
    L = math.sqrt(len(s))
    rows = math.floor(L)
    cols = math.floor(L) + 1 if math.floor(L) ** 2 != len(s) else rows
    # Ensure that cols * rows is greater than or equal to L
    if cols * rows < len(s):
        rows += 1
    # Iterate over each column index, then append every cols(th) character in string
    res = ""
    for start in range(cols):
        res += s[start]
        for repeat_index in range(start + cols, len(s), cols):
            res += s[repeat_index]
        res += ' '
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()
