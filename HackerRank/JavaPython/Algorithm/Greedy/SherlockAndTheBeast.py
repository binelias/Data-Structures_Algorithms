# Sherlock Holmes suspects his archenemy Professor Moriarty is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.

# Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus. He also gives him a clue: an integer. Sherlock determines the key to removing the virus is to find the largest Decent Number having that number of digits.

# A Decent Number has the following properties:

# Its digits can only be 3's and/or 5's.
# The number of 3's it contains is divisible by 5.
# The number of 5's it contains is divisible by 3.
# It is the largest such number for its length.
# Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!

# Sample Input

# STDIN   Function
# -----   --------
# 4       t = 4
# 1       n = 1 (first test case)
# 3       n = 3 (second test case)
# 5
# 11
# Sample Output

# -1
# 555
# 33333
# 55555533333


#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'decentNumber' function below.
#
# The function accepts INTEGER n as parameter.
#


def decentNumber(n):
    # Write your code here
    respuesta = ""
    cinco = n
    tres = 0
    decent = False

    while (cinco >= 0):
        if (cinco % 3 == 0) and (tres % 5 == 0):
            decent = True
            break
        else:
            tres += 1
            cinco -= 1
    if decent:
        respuesta += "5"*cinco
        respuesta += "3"*tres
        print(int(respuesta))

    else:
        print(-1)


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        decentNumber(n)
