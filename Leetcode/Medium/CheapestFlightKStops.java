// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

// Example 1:

// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
// Example 2:

// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
// Output: 200
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
// Example 3:

// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
// Output: 500
// Explanation:
// The graph is shown above.
// The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

// Constraints:

// 1 <= n <= 100
// 0 <= flights.length <= (n * (n - 1) / 2)
// flights[i].length == 3
// 0 <= fromi, toi < n
// fromi != toi
// 1 <= pricei <= 104
// There will not be any multiple flights between two cities.
// 0 <= src, dst, k < n
// src != dst

// Breadth First Search
// Intuition
// A breadth-first search is a good algorithm to use if we want to find the shortest path in an unweighted graph. The property of BFS is that the first time a node is reached during the traversal, it is reached at the minimum distance from the source. The same cannot be said for a weighted graph. For a weighted graph, a path having more edges does not necessarily mean the path is more expensive. Thus, we cannot employ a normal breadth-first search for weighted graphs.

// A breadth-first search has no way of knowing if a particular discovery of a node would give us the cheapest path to that node. The only possible way for BFS (or DFS) to find the shortest path in a weighted graph is to search the entire graph and keep recording the minimum distance from the source to the destination node.

// However, our problem limits the number of stops to k. As a result, we need not search the paths with lengths greater than k + 1. A breadth-first search can be used for this problem because the number of levels to be explored by the algorithm is bounded by k.

// In this approach, we will perform a level-wise iteration over the nodes. We will explore all the nodes at the present level (say l) before moving on to the nodes at the next level (l + 1). This level would correspond to the number of stops that would be limited by k. When we move from a level of l to l + 1, we will increase the stops by 1. We are allowed a maximum of k stops, which means we could go up to a maximum level of k + 1 from the src node, trying to reach dst at the minimum price.

// We can maintain an array dist which stores the minimum price to reach each node. When we want to move to a node, we will only consider edges where the total price after traversing the edge is less than the currently calculated dist[node]. This optimization helps us avoid TLE.

// If you are not familiar with BFS traversal, we suggest you read our Leetcode Explore Card.

// In this article, we will use the terms price and distance interchangeably. You can imagine the prices as miles between airports, and we want the shortest distance.

// Algorithm
// Create an adjacency list where adj[X] contains all the neighbors of node X and the corresponding price it takes to move to a neighbor.
// Intialize dist array, storing the minimum price to reach a node from the src node. Intialize it with large values.
// Initialize a queue storing {node, distance} pairs. Initially, the queue should have only {src, 0}.
// Create a variable called stops and set its value to 0.
// Perform BFS until the queue is empty or stops > k:
// Iterate over all the nodes at a particular level. This will be done by starting a nested loop and visiting all the nodes currently present in the queue.
// At each pair {node, distance}, iterate over all the neighbors of node. For each neighbour, check if dist[neighbor] is less than distance + the price of the edge. If it is, then update dist[neighbor] and push {neighbor, dist[neighbor]} onto the queue.
// After iterating over all the nodes in the current level, increase stops by one. We've visited all the nodes at a particular level and are ready to visit the next level of nodes.
// Once we reach a condition where either the queue is empty or stops == k, we have our answer as dist[dst]. If dist[dst] hasn't changed from the initial large value, then we never reached it, so return -1.
// Below is a visual example of how the algorithm works. The left side arrays represents the previous level and the right side arrays represent the current level.

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    for (int[] i : flights)
      adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { src, 0 });
    int stops = 0;

    while (stops <= k && !q.isEmpty()) {
      int sz = q.size();
      // Iterate on current level.
      while (sz-- > 0) {
        int[] temp = q.poll();
        int node = temp[0];
        int distance = temp[1];

        if (!adj.containsKey(node))
          continue;
        // Loop over neighbors of popped node.
        for (int[] e : adj.get(node)) {
          int neighbour = e[0];
          int price = e[1];
          if (price + distance >= dist[neighbour])
            continue;
          dist[neighbour] = price + distance;
          q.offer(new int[] { neighbour, dist[neighbour] });
        }
      }
      stops++;
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
  }
}