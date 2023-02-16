# There is an undirected tree where each vertex is numbered from 1 to n, and each contains a data value. The sum of a tree is the sum of all its nodes' data values. If an edge is cut, two smaller trees are formed. The difference between two trees is the absolute value of the difference in their sums.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'cutTheTree' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY data
#  2. 2D_INTEGER_ARRAY edges
#

sys.setrecursionlimit(10**5)


def dfs(conn, node, sums, data, parent):
    if sums[node] != 0:
        return sums[node]
    nb = conn[node]
    if len(nb) == 1 and node != 0:
        sums[node] = data[node]
        return data[node]
    ans = 0
    for n1 in nb:
        if n1 != parent:
            ans += dfs(conn, n1, sums, data, node)
    ans += data[node]
    sums[node] = ans
    return ans


def cutTheTree(data, edges):
    # Write your code here
    conn = [[] for i in range(n)]
    for e in edges:
        e1 = e[0]-1
        e2 = e[1]-1
        conn[e1].append(e2)
        conn[e2].append(e1)
    sums = [0 for i in range(n)]
    dfs(conn, 0, sums, data, 0)
    print(sums)
    mindiff = 999999999
    for i in range(1, n):
        # seperate node i
        sum1 = sums[i]
        sum2 = sums[0] - sums[i]
        diff = abs(sum1 - sum2)
        mindiff = min(mindiff, diff)
    return mindiff


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    data = list(map(int, input().rstrip().split()))

    edges = []

    for _ in range(n - 1):
        edges.append(list(map(int, input().rstrip().split())))

    result = cutTheTree(data, edges)

    fptr.write(str(result) + '\n')

    fptr.close()
