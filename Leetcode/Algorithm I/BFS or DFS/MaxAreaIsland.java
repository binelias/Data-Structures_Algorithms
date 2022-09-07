// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

// Example 1:
// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.

// Example 2:
// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0

// We can try the same approach using a stack based, (or "iterative") depth-first search.

// Here, seen will represent squares that have either been visited or are added to our list of squares to visit (stack). For every starting land square that hasn't been visited, we will explore 4-directionally around it, adding land squares that haven't been added to seen to our stack.

// On the side, we'll keep a count shape of the total number of squares seen during the exploration of this shape. We'll want the running max of these counts.


package Leetcode.Algorithm I.BFS.DFS;

public class MaxAreaIsland {
  //DFS iterative
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] seen = new boolean[grid.length][grid[0].length];
    int[] dr = new int[]{1,-1,0,0};
    int[] dc = new int[]{0,0,1,-1};
    
    int ans = 0;
    for(int row = 0; row < grid.length; row++) {
        for(int col = 0; col < grid[0].length; col++) {
            if(grid[row][col] == 1 && !seen[row][col]) {
                int shape = 0;
                 Stack <int[]> stack = new Stack<>();
                stack.push(new int[]{row, col});
                seen[row][col] = true;
                while(!stack.empty()) {
                    int[] node = stack.pop();
                    int r = node[0], c = node[1];
                    shape++;
                    for(int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if(0 <= nr && nr < grid.length && 0<= nc && nc < grid[0].length
                           && grid[nr][nc] == 1 && !seen[nr][nc]) {
                            stack.push(new int[]{nr, nc});
                            seen[nr][nc] = true;
                        }
                    }
                }
                ans = Math.max(ans, shape);
            }
        }
    }
    return ans;
  }
}
