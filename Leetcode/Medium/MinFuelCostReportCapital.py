# There is a tree(i.e., a connected, undirected graph with no cycles) structure country network consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0. You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.

# There is a meeting for the representatives of each city. The meeting is in the capital city.

# There is a car in each city. You are given an integer seats that indicates the number of seats in each car.

# A representative can use the car in their city to travel or change the car and ride with another representative. The cost of traveling between two cities is one liter of fuel.

# Return the minimum number of liters of fuel to reach the capital city.


# Example 1:


# Input: roads = [[0, 1], [0, 2], [0, 3]], seats = 5
# Output: 3
# Explanation:
# - Representative1 goes directly to the capital with 1 liter of fuel.
# - Representative2 goes directly to the capital with 1 liter of fuel.
# - Representative3 goes directly to the capital with 1 liter of fuel.
# It costs 3 liters of fuel at minimum.
# It can be proven that 3 is the minimum number of liters of fuel needed.
# Example 2:


# Input: roads = [[3, 1], [3, 2], [1, 0], [0, 4], [0, 5], [4, 6]], seats = 2
# Output: 7
# Explanation:
# - Representative2 goes directly to city 3 with 1 liter of fuel.
# - Representative2 and representative3 go together to city 1 with 1 liter of fuel.
# - Representative2 and representative3 go together to the capital with 1 liter of fuel.
# - Representative1 goes directly to the capital with 1 liter of fuel.
# - Representative5 goes directly to the capital with 1 liter of fuel.
# - Representative6 goes directly to city 4 with 1 liter of fuel.
# - Representative4 and representative6 go together to the capital with 1 liter of fuel.
# It costs 7 liters of fuel at minimum.
# It can be proven that 7 is the minimum number of liters of fuel needed.
# Example 3:


# Input: roads = [], seats = 1
# Output: 0
# Explanation: No representatives need to travel to the capital city.


# Constraints:

# 1 <= n <= 105
# roads.length == n - 1
# roads[i].length == 2
# 0 <= ai, bi < n
# ai != bi
# roads represents a valid tree.
# 1 <= seats <= 105


# erview
# We are given a tree with n nodes (or cities) from 0 to n - 1 and exactly n - 1 edges.

# There is one car and one representative at each node. We are given an integer seats that represents the maximum number of representatives that can together go in any car. The cost of travelling over an edge using a car takes one liter of fuel.

# Our task is to move all the representatives to node 0 by using the minimum fuel and return the minimum fuel required to do so.

# Before moving on to the solution, consider some of the graph terminologies that will be used later:

# img

# Child: A node that is one edge further away from a given node in a rooted tree. In the above image, nodes 3, 4 are children of 1, which is called the parent.
# Descendants: Descendants of a node are children, children of children, and so on. In the above image, nodes 3, 4, 6, 7, 9 are all descendants of 1.
# Subtree: A subtree of a node T is a tree S consisting of a node T and all of its descendants in T. The subtree corresponding to the root node is the entire tree.
# Level: A node's level (or depth) in a tree data structure is its distance from the tree's root node. The root node is said to be at level 0, and its children are at level 1, and the children of the nodes at level 1 are at level 2, and so on. In our case, the root node is node 0, because this is where we want to take all of the representatives.
# Although the edges are given as undirected, we will treat the graph as a tree where 0 is the root and only consider moving in one direction.Although the edges are given as undirected, we will treat the graph as a tree where 0 is the root and only consider moving in one direction.

# Depth First Search

# Intuition
# We can see that taking a car from level l to l + 1 and back to level l to get to the root node is pointless. It takes two units of fuel to go from l to l + 1 and back again. Instead, the representative at level l + 1 can drive to level l in one unit of fuel. As a result, the cars would move from higher to lower levels in order to reach the root node.

# We will try to put as many representatives as possible in the same car to save fuel. Let's look at an example to see how we should arrange the representatives.

# Consider a node node that has a parent node parent. Assume there are r representatives in the subtree of node. To reach node 0, all representatives in this subtree must pass through parent. Let's compute how much fuel would be required to just cross the edge that connects nodes node and parent.

# Intitutively, we can think that the worst-case scenario would be the one where all the representatives take their own car and cross the edge. This would require r units of fuel.

# The best way would be to put r representatives one by one into the cars until the cars reach seat capacity. This would require ceil(r / seats) cars and an equal amount of fuel (since a car takes one unit of fuel to travel over an edge). For example, if you have 10 representatives in a subtree and the capacity is 3, then you would need ceil(10 / 3) = 4 cars.

# Also, regardless of how the representatives arrive at node, there will definitely be at least ceil(r / seats) cars. This is because all of the representatives in the subtree of node except for the one at node would arrive by using at least ceil((r - 1) / seats) cars or more (since we can accommodate a maximum of seats people in a car). Hence, we already have cars that can seat r - 1 people, and there is one representative and one car at node to take all the representatives in the required number of cars (1 + ceil(r - 1 / seats) >= ceil(r / seats)). That brings us to our solution.

# We begin by moving all the representatives in a node's subtree to the node. Then, using the minimum fuel calculated by the above formula, move all of the representatives to the parent node. So our task is to compute the number of representatives in each node's subtree and add the fuel required to move all of the representatives in the node's subtree to the parent node.

# The depth-first search (DFS) algorithm can be used to compute the number of representatives in each subtree. In DFS, we use a recursive function to explore nodes as far as possible along each branch. Upon reaching the end of a branch, we backtrack to the next branch and continue exploring.

# Once we encounter an unvisited node, we will take one of its neighbor nodes (if exists) as the next node on this branch. Recursively call the function to take the next node as the 'starting node' and solve the subproblem.

# If you are new to Depth First Search, please see our Leetcode Explore Card for more information on it!

# We implement a dfs method that performs a DFS traversal and returns the number of representatives in the subtree of given node. We begin the traversal from root node 0. Using the above-mentioned formula, we then calculate the number of cars and thus the fuel required to move all of the representatives to the parent node. To get the final answer, we add the fuel required to move representatives from all nodes to their respective parent nodes until we reach the root node.

# Algorithm
# Create an adjacency list where adj[X] contains all the neighbors of node X.
# Create an integer fuel that stores the minimum amount of fuel needed to move all representatives to node 0.
# Begin the DFS traversal:
# We use the dfs function to perform the traversal. For each call, pass node, parent, adj and seats as the parameters. It returns the number of representatives in the subtree of the node. We start with node 0. We also keep track of the parent node of the current node so that we don’t visit the node’s parent as it has already been visited.
# Initalize an integer representatives to store the number of representatives in the subtree of node. We initialize it to 1 because the node itself has one representative.
# Iterate over all the children of the node (nodes that share an edge) and check if any child is equal to the parent. If the child is equal to the parent, we will not visit it again.
# If the child is not equal to the parent, recursively call the dfs function with the node as child and the parent as node. Add the count of representatives (returned by this call) in the subtree of child to representatives.
# After iterating over all the children, we have the required number of representatives. To move all of these representatives to the parent node, we would require ceil(representatives / seats) cars and an equal amount of fuel. We perform fuel += ceil(representatives / seats). We ignore node 0 because it does not have a parent.
# Return fuel.


class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        n = len(roads) + 1
        adj = [[] for _ in range(n)]
        for road in roads:
            adj[road[0]].append(road[1])
            adj[road[1]].append(road[0])

        self.fuel = 0

        def dfs(node, parent, adj, seats):
            representatives = 1
            for child in adj[node]:
                if child != parent:
                    representatives += dfs(child, node, adj, seats)
            if node != 0:
                self.fuel += math.ceil(representatives / seats)
            return representatives

        dfs(0, -1, adj, seats)
        return self.fuel
