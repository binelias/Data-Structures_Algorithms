# The member states of the UN are planning to send 2 people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'journeyToMoon' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY astronaut
#


class DisjointSet:
    def __init__(self, n): self.parent = [[i, 1] for i in range(n)]

    def __find(self, node):
        curr_node = node
        while (self.parent[curr_node][0] != curr_node):
            curr_node = self.parent[curr_node][0]
        self.parent[node][0] = curr_node
        return curr_node, self.parent[curr_node][1]

    def union(self, node1, node2):
        parent1, size1 = self.__find(node1)
        parent2, size2 = self.__find(node2)
        if (parent1 != parent2):
            if (size1 < size2):
                parent2, parent1 = parent1, parent2
            self.parent[parent2][0] = parent1
            self.parent[parent1][1] += self.parent[parent2][1]


def journeyToMoon(n, astronaut):
    # Write your code here
    ds = DisjointSet(n)
    for astro_id1, astro_id2 in astronaut:
        ds.union(astro_id1, astro_id2)
    comp_size_counts = [ds.parent[i][1]
                        for i in range(n) if (ds.parent[i][0] == i)]
    s, res = sum(comp_size_counts), 0
    for count in comp_size_counts:
        s -= count
        res += (count * s)
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    p = int(first_multiple_input[1])

    astronaut = []

    for _ in range(p):
        astronaut.append(list(map(int, input().rstrip().split())))

    result = journeyToMoon(n, astronaut)

    fptr.write(str(result) + '\n')

    fptr.close()
