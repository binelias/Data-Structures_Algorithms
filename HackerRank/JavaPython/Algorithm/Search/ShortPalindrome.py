# Sample Input 0

# kkkkkkz
# Sample Output 0

# 15
# Sample Input 1

# abbaab
# Sample Output 1

# 4
# Sample Input 2

# akakak
# Sample Output 2

# 2
# Explanation 2

# Tuples possible are  (1,2,4,5) and (0,1,3,4)

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'shortPalindrome' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#


def shortPalindrome(s):
    # Write your code here

    dim1 = [0] * 26
    dim2 = [0] * 26 * 26
    dim3 = [0] * 26

    count = 0

    mod = 1000000007

    for k in s:

        c = ord(k) - ord('a')

        count = (count + dim3[c]) % mod

        ic = c

        for i in range(26):

            dim3[i] = (dim3[i] + dim2[ic]) % mod
            dim2[ic] = (dim2[ic] + dim1[i]) % mod
            ic += 26

        dim1[c] += 1

    return count


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = shortPalindrome(s)

    fptr.write(str(result) + '\n')

    fptr.close()
