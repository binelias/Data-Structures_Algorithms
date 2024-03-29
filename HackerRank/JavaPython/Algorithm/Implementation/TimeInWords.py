# Sample Input 0
# 5
# 47

# Sample Output 0
# thirteen minutes to six

# Sample Input 1
# 3
# 00

# Sample Output 1
# three o' clock

# Sample Input 2
# 7
# 15

# Sample Output 2
# quarter past seven

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeInWords' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER h
#  2. INTEGER m
#


def timeInWords(h, m):
    # Write your code here
    ones = {"1": "one", "2": "two", "3": "three", "4": "four", "5": "five", "6": "six", "7": "seven", "8": "eight", "9": "nine", "10": "ten", "11": "eleven", "12": "twelve", "13": "thirteen", "14": "fourteen", "15": "fifteen", "16": "sixteen", "17": "seventeen",
            "18": "eighteen", "19": "nineteen", "20": "twenty", "21": "twenty one", "22": "twenty two", "23": "twenty three", "24": "twenty four", "25": "twenty five", "26": "twenty six", "27": "twenty seven", "28": "twenty eight", "29": "twenty nine"}
    if m == 0:
        return ones[str(h)]+" o' clock"
    elif m == 1:
        return ones[str(m)]+" minute past "+ones[str(h)]
    elif 2 <= m < 15:
        return ones[str(m)]+" minutes past "+ones[str(h)]
    elif m == 15:
        return "quarter past "+ones[str(h)]
    elif 15 < m < 30:
        return ones[str(m)]+" minutes past "+ones[str(h)]
    elif m == 30:
        return "half past "+ones[str(h)]
    elif 30 < m < 45:
        return ones[str(60-m)]+" minutes to "+(ones[str(h+1)] if h != 12 else "one")
    elif m == 45:
        return "quarter to "+(ones[str(h+1)] if h != 12 else "one")
    elif 45 < m <= 58:
        return ones[str(60-m)]+" minutes to "+(ones[str(h+1)] if h != 12 else "one")
    elif m == 59:
        return ones[str(60-m)]+" minute to " + (ones[str(h+1)] if h != 12 else "one")


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    h = int(input().strip())

    m = int(input().strip())

    result = timeInWords(h, m)

    fptr.write(result + '\n')

    fptr.close()
