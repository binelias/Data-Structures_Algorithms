// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

// Approach 2: Using BFS
// Intuition

// A better brute force: Looking over the entire matrix appears wasteful and hence, we can use Breadth First Search (BFS) to limit the search to the nearest 0 found for each 1. As soon as a 0 appears during the BFS, we know that the 0 is the closest, and hence, we move to the next 1.

// Think again: But, in this approach, we will only be able to update the distance of one 1 using one BFS, which could in fact, result in slightly higher complexity than the brute force approach. But hey, this could be optimized if we start the BFS from 0s and thereby, updating the distances of all the 1s in the path.

// Algorithm
// For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
// We start by adding all the cells with 0s to q.
// Intially, distance for each 0 cell is 0 and distance for each 1 is INT_MAX, which is updated during the BFS.
// Pop the cell from queue, and examine its neighbors. If the new calculated distance for neighbor {i,j} is smaller, we add {i,j} to q and update dist[i][j].

class Solution {
  public int[][] updateMatrix(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      
      Queue<int[]> queue = new LinkedList<>();
      for(int i = 0; i < m; i++) {
          for(int j = 0; j < n; j++) {
              if(mat[i][j] == 0) queue.offer(new int[] {i, j});
              else mat[i][j] = Integer.MAX_VALUE;
          }
      }
      
      int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
      while(!queue.isEmpty()) {
          int[] cell =queue.poll();
          for(int[] d: dirs) {
              int r = cell[0] + d[0];
              int c = cell[1] + d[1];
              if(r < 0 || r >= m || c < 0 || c >= n || 
                 mat[r][c] <= mat[cell[0]][cell[1]] + 1) continue;
              queue.add(new int[] {r, c});
              mat[r][c] = mat[cell[0]][cell[1]] + 1;
          }
      }
      return mat;
  }
}