// There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.

// You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

// A good path is a simple path that satisfies the following conditions:

// The starting node and the ending node have the same value.
// All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
// Return the number of distinct good paths.

// Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.

// Example 1:

// Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
// Output: 6
// Explanation: There are 5 good paths consisting of a single node.
// There is 1 additional good path: 1 -> 0 -> 2 -> 4.
// (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
// Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
// Example 2:

// Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
// Output: 7
// Explanation: There are 5 good paths consisting of a single node.
// There are 2 additional good paths: 0 -> 1 and 2 -> 3.

// Overview
// The problem presents an undirected tree with n nodes. Each node of the tree has a value associated to it. Our task is to compute the total number of distinct good paths where a good path is defined as:

// The starting node and the ending node have the same value.
// All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
// Approach: Union-Find
// Intuition
// An intuitive approach would be to start from a node and traverse to its neighbors, which have a lower value than the node. From the neighbors, we move to their neighbors. If we find another node with a value similar to the start node, we have one good path. We can repeat the same process for every node in the tree. In such a way, we traverse the tree, moving to neighbors with lower values for every node, and count the total number of good paths. We can choose BFS or DFS for the graph traversal. Each graph traversal takes O(n)O(n)O(n) time, and since we would do a complete traversal starting from every node, we would take O(n2)O(n^2)O(n 
// 2
//  ) time. This approach would indicate that the time limit has been exceeded (TLE).

// Let's think of a faster way by making some observations.

// There is no point in traversing from a node to its neighbor where the vals[neighbor] > vals[node]. It violates the good path constraints. So, for any node, the only nodes that matter are the ones that have values less than vals[node]. Intuitively, this does give some hints about sorting the nodes according to their values, starting with the smallest value first and then going to higher values.

// Let's look at an example. Consider a node with the value X in a tree T. Let's try to find the number of good paths that start and end with the value X. The nodes having values greater than X are of no use, so let's remove them and form a new subgraph of all the nodes (and edges in T connected to these nodes) having values less than or equal to X. Note that the new subgraph could be a connected tree, or there could be multiple connected trees separated from each other.

// Let's say we have two existing trees (components) c1 and c2 which are subgraphs of T.

// Imagine if there were 6 nodes with the value X, say a, b, c, d, e, and f. We want to add all of them to the subgraph and find the number of good paths starting and ending with X. Let's say a, b, and c connect with some nodes in c1. Nodes d and e connect with some nodes in c2. Node f does not connect with any existing component and creates a new component c3 with just the node f.

// Let's compute the number of good paths. In component c1, if we start with node a we get three good paths. The a node itself as well as the paths from a to b and a to c. For node b, we have the node itself and the path to c (the path to a is already covered). And for node c, we just have the node itself. So, there are six good paths formed in component c1. What if there were N nodes in place of three? Starting from the first node, we would have N good paths: the node itself and N - 1 paths to other nodes with the same value. For the second node, we would have N - 1 options (since the first node is already covered), and so on. So, if N nodes having the same value connect in a component, the good paths would be N + N - 1 + N - 2 + .. + 1 = N * (N + 1) / 2.

// Similary, we can count three good paths forming in component c2. We can also use the same formula with N = 2 which gives (2 * (2 + 1) / 2) = 3 good paths.

// For the component c3, there is one good path for node f, the node itself. It needs nodes with higher values to connect to other nodes in the original tree T, which do not lead to the formation of a good path. Here, N = 1, so using the formula gives us one good path.

// Having added all the nodes with the value X, how can we compute the good paths with starting nodes having a value X + 1 (or next higher value)? To the subgraph formed above, we add all the nodes having the value X + 1 and repeat the same process to compute all the good paths starting with the value X + 1. The nodes with the value X can serve as intermediate nodes in a good path starting and ending with the value X + 1.

// We can extend the above to start with value 1 first, then add nodes with value 2, then add nodes with value 3, and so on, to the subgraph formed in the previous iteration. We should begin from the lowest and move to the higher values of the nodes. For each value, we should add all the nodes with the same value to the existing subgraph and calculate the number of good paths formed in each component. This way, we build the complete tree at the end by adding nodes of the same value at each step.

// This approach can be implemented with a disjoint-set data structure, also called a union-find data structure. It is a data structure that stores a collection of disjoint (non-overlapping) sets. Equivalently, it stores a partition of a set into disjoint subsets. It provides operations for adding new sets, merging sets (replacing them by their union), and finding a representative member of a set. It implements two useful operations:

// a) Find: Determine which subset a particular element is in. This can be used to determine if two elements are in the same subset. b) Union: Join two subsets into a single subset.

// If you are new to Union-Find, we suggest you read our Leetcode Explore Card. We will not talk about implementation details in this article, but only about the interface to the data structure.

// In this approach, we will create a map, say valuesToNodes to map a value to all the nodes that have that value. The map is sorted with respect to the keys, which are the node values. We iterate over every value, nodes[] entry in valuesToNodes.

// For each node in nodes[], we check all neighbor. If vals[node] >= vals[neighbor], neighbor is already covered, and it is a node in the subgraph. It can be used as an intermediate node in a good path if formed using it. We perform union (node, neighbor) to add node to the current subgraph. Otherwise, if vals[node] < vals[neighbor], the node is not added to the existing components, and it creates a new component with the node itself.

// The next step is to compute the number of nodes with the same value added to each component and use the above formula to count the number of good paths. We can do this by using a map, say groups where the key is the unique id of the component (or tree) and the value is the count of nodes from nodes[] in that component. Iterate over all the nodes[] and for each node, we increment group[find(node)] by one. This way, we have the count of nodes in each component.

// We iterate over the group map, and for each entry id, size, we add size * (size + 1) / 2 to the count of good paths.

// Refer to the following slides for a step-by-step visual example:

// Current

// Algorithm
// Create an adjacency list where adj[X] contains all the neighbors of node X.
// Create a map valuesToNodes where valuesToNodes[X] is an array that contains all the nodes having the value X. The data structure chosen to create such a map sorts the keys in non-decreasing order, i.e., the keys are sorted.
// Iterate over all the nodes and add each node to valuesToNodes[vals[node]].
// Create a class UnionFind defining standard methods find and union_set.
// Create an instance of UnionFind, passing the size as n. Also, initialize the count of good paths variable goodPaths with 0.
// Iterate over each entry value, nodes in valuesToNodes in ascending order.
// For every node in nodes, iterate over its neighbors.
// For each neighbor of the node, if vals[node] >= vals[neighbor] we perform a union of the node with the neighbor.
// After iterating through all the nodes, we create a map group. group[A] contains the number of nodes (from the nodes array) that belong to the same component A. For every node in nodes, we find its component and increment the size of that component by 1 in groups, i.e., group[find(node)] = group[find(node)] + 1.
// We iterate through all the entries in the group and, for each key, get the value called size corresponding to it. Add (size * (size + 1) / 2) to the goodPaths.
// Return goodPaths.

class UnionFind {
  int[] parent;
  int[] rank;

  public UnionFind(int size) {
    parent = new int[size];
    for (int i = 0; i < size; i++)
      parent[i] = i;
    rank = new int[size];
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union_set(int x, int y) {
    int xset = find(x), yset = find(y);
    if (xset == yset) {
      return;
    } else if (rank[xset] < rank[yset]) {
      parent[xset] = yset;
    } else if (rank[xset] > rank[yset]) {
      parent[yset] = xset;
    } else {
      parent[yset] = xset;
      rank[xset]++;
    }
  }
}

class Solution {
  public int numberOfGoodPaths(int[] vals, int[][] edges) {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
      adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
    }

    int n = vals.length;
    // Mapping from value to all the nodes having the same value in sorted order of
    // values.
    TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
    }

    UnionFind dsu = new UnionFind(n);
    int goodPaths = 0;

    // Iterate over all the nodes with the same value in sorted order, starting from
    // the lowest value.
    for (int value : valuesToNodes.keySet()) {
      // For every node in nodes, combine the sets of the node and its neighbors into
      // one set.
      for (int node : valuesToNodes.get(value)) {
        if (!adj.containsKey(node))
          continue;
        for (int neighbor : adj.get(node)) {
          // Only choose neighbors with a smaller value, as there is no point in
          // traversing to other neighbors.
          if (vals[node] >= vals[neighbor]) {
            dsu.union_set(node, neighbor);
          }
        }
      }
      // Map to compute the number of nodes under observation (with the same values)
      // in each of the sets.
      Map<Integer, Integer> group = new HashMap<>();
      // Iterate over all the nodes. Get the set of each node and increase the count
      // of the set by 1.
      for (int u : valuesToNodes.get(value)) {
        group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
      }
      // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
      for (int key : group.keySet()) {
        int size = group.get(key);
        goodPaths += size * (size + 1) / 2;
      }
    }
    return goodPaths;
  }
}