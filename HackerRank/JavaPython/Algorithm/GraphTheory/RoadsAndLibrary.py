# Determine the minimum cost to provide library access to all citizens of HackerLand. There are  cities numbered from  1 to n. Currently there are no libraries and the cities are not connected. Bidirectional roads may be built between any city pair listed in cities. A citizen has access to a library if:

# Their city contains a library.
# They can travel by road from their city to a city containing a library.

# Sample Input

# STDIN       Function
# -----       --------
# 2           q = 2
# 3 3 2 1     n = 3, cities[] size m = 3, c_lib = 2, c_road = 1
# 1 2         cities = [[1, 2], [3, 1], [2, 3]]
# 3 1
# 2 3
# 6 6 2 5     n = 6, cities[] size m = 6, c_lib = 2, c_road = 5
# 1 3         cities = [[1, 3], [3, 4],...]
# 3 4
# 2 4
# 1 2
# 2 3
# 5 6
# Sample Output

# 4
# 12


#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'roadsAndLibraries' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER c_lib
#  3. INTEGER c_road
#  4. 2D_INTEGER_ARRAY cities
#


def find_parent(node, parent):
    res = node
    while res != parent[res]:
        parent[res] = parent[parent[res]]
        res = parent[res]
    return res


def union(n1, n2, parent, rank):
    p1, p2 = find_parent(n1, parent), find_parent(n2, parent)

    if p1 == p2:
        return 0

    if p1 >= p2:
        parent[p2] = p1
        rank[p1] += rank[p2]
    else:
        parent[p1] = p2
        rank[p2] += rank[p1]
    return 1


def roadsAndLibraries(n, c_lib, c_road, cities):
    # Write your code here
    parent = [i for i in range(n)]
    rank = [1] * n
    city_groups = n
    roads_cost = 0

    for n1, n2 in cities:
        # 0-index
        n1 -= 1
        n2 -= 1

        if union(n1, n2, parent, rank):
            city_groups -= 1
            roads_cost += c_road

    return min(roads_cost + (city_groups * c_lib), n * c_lib)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        c_lib = int(first_multiple_input[2])

        c_road = int(first_multiple_input[3])

        cities = []

        for _ in range(m):
            cities.append(list(map(int, input().rstrip().split())))

        result = roadsAndLibraries(n, c_lib, c_road, cities)

        fptr.write(str(result) + '\n')

    fptr.close()
