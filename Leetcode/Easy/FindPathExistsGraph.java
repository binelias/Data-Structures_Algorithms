// There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

// You want to determine if there is a valid path that exists from vertex source to vertex destination.

// Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

// Example 1:

// Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
// Output: true
// Explanation: There are two paths from vertex 0 to vertex 2:
// - 0 → 1 → 2
// - 0 → 2
// Example 2:

// Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
// Output: false
// Explanation: There is no path from vertex 0 to vertex 5.

// Constraints:

// 1 <= n <= 2 * 105
// 0 <= edges.length <= 2 * 105
// edges[i].length == 2
// 0 <= ui, vi <= n - 1
// ui != vi
// 0 <= source, destination <= n - 1
// There are no duplicate edges.
// There are no self edges.

// Depth First Search (DFS): Recursive
// Intuition
// If you are new to Depth First Search, see our Leetcode Explore Card for more information on it!

// In DFS, we explore nodes as far as possible along each branch. Upon reaching the end of the current branch, we backtrack to the next possible branch and continue exploring.

// img

// Once we encounter an unvisited node, we take one of its neighbor nodes (if it exists) as the next node on this branch. Recursively call the function to take the next node as the 'starting node' and solve the subproblem. If we reach the end of this branch, we backtrack to the previous node and visit the next neighbor node (if it exists), and repeat the process. Similarly, we also use a bool array seen to record every visited node, so they won't be visited by other nodes anymore.

// Algorithm
// Use one bool array seen to mark all visited nodes, set seen[source] = true.
// Use a hash map graph to store all edges.
// Start the search from node source. If the current node we are visiting (curr_node) equals destination, return true. Otherwise, find all its neighbor nodes that haven't been visited before.
// If there exists such a neighbor node, mark it as visited, move on to this node and repeat step 3.
// If this neighbor node can reach destination, then return true, otherwise, try the next neighbor.
// Return false if we finished the search without finding destination.

class Solution {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen = new boolean[n];

    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
      graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
    }

    return dfs(graph, seen, source, destination);
  }

  private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
    if (currNode == destination) {
      return true;
    }
    if (!seen[currNode]) {
      seen[currNode] = true;
      for (int nextNode : graph.get(currNode)) {
        if (dfs(graph, seen, nextNode, destination)) {
          return true;
        }
      }
    }
    return false;
  }// T:O(n+m), S:(n+m)
}