// On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

// A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

// Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

// The knight continues moving until it has made exactly k moves or has moved off the chessboard.

// Return the probability that the knight remains on the board after it has stopped moving.


// Example 1:
// Input: n = 3, k = 2, row = 0, column = 0
// Output: 0.06250
// Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
// From each of those positions, there are also two moves that will keep the knight on the board.
// The total probability the knight stays on the board is 0.0625.

// Example 2:
// Input: n = 1, k = 0, row = 0, column = 0
// Output: 1.00000

// Top down recursive
/*
reccurence relation:
Directions = [
  [-2, -1],
  [-2, 1],
  [-1, 2],
  [1, 2],
  [2, 1],
  [2, -1],
  [1, -2],
  [-1, -2]
];
0 <= r < N, 0 <= c < N, k === 0
probability(r, c, k) = 1

0 <= r < N, 0 <= c < N, k > 1
probability(r, c, k) = Σ(x, y)∈Directions probability(r + x, c + y, k - 1) / 8

r < 0 || r > N, c < 0 || c > N
probability(r, c, k) = 0
 */

const DIRECTIONS = [
  [-2, -1],
  [-2, 1],
  [-1, 2],
  [1, 2],
  [2, 1],
  [2, -1],
  [1, -2],
  [-1, -2]
];

var knightProbability = function(N, K, r, c) {
  if (r < 0 || c < 0 || r >= N || c >= N) {
    return 0;
  }

  if (K === 0) {
    return 1;
  }

  let res = 0;

  for (let dir of DIRECTIONS) {
    res += knightProbability(N, K - 1, r + dir[0], c + dir[1]) / 8;
  }

  return res;
};//T: O(8^k), S: O(8^k)

console.log(knightProbability(6, 2, 2, 2))


// Top down recursive with DP
const recurse = (N, K, r, c, dp) => {
  if (r < 0 || c < 0 || r >= N || c >= N) {
    return 0;
  }

  if (K === 0) {
    return 1;
  }

  if (dp[K][r][c] !== undefined) return dp[K][r][c];

  let res = 0;
  for (let dir of DIRECTIONS) {
    res += recurse(N, K - 1, r + dir[0], c + dir[1], dp) / 8;
  }

  dp[K][r][c] = res;

  return dp[K][r][c];
};

var knightProbability = function(N, K, r, c) {
  const dp = new Array(K + 1).fill(0).map(() => new Array(N).fill(0).map(() => new Array(N).fill(undefined)));

  return recurse(N, K, r, c, dp);
};

console.log(knightProbability(6, 2, 2, 2))


// Bottom up iterative
var knightProbability = function(N, K, r, c) {
  const dp = new Array(K + 1).fill(0).map(() => new Array(N).fill(0).map(() => new Array(N).fill(0)));

  dp[0][r][c] = 1;
  for (let step = 1; step <= K; step++) {
    for (let row = 0; row < N; row++) {
      for (let col = 0; col < N; col++) {
        for (let i = 0; i < DIRECTIONS.length; i++) {
          const dir = DIRECTIONS[i];
          const prevRow = row + dir[0];
          const prevCol = col + dir[1];
          if (prevRow >= 0 && prevRow < N && prevCol >= 0 && prevCol < N) {
            dp[step][row][col] =
              dp[step][row][col] + dp[step - 1][prevRow][prevCol] / 8;
          }
        }
      }
    }
  }

  let res = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      res += dp[K][i][j];
    }
  }

  return res;
};

console.log(knightProbability(6, 3, 2, 2))


// Bottom up iterative optimized
var knightProbability = function(N, K, r, c) {
  let prevDp = new Array(N).fill(0).map(() => new Array(N).fill(0));
  let nextDp = new Array(N).fill(0).map(() => new Array(N).fill(0));

  prevDp[r][c] = 1;
  for (let step = 1; step <= K; step++) {
    for (let row = 0; row < N; row++) {
      for (let col = 0; col < N; col++) {
        for (let i = 0; i < DIRECTIONS.length; i++) {
          const currentDirection = DIRECTIONS[i];
          const prevRow = row + currentDirection[0];
          const prevCol = col + currentDirection[1];
          if (prevRow >= 0 && prevRow < N && prevCol >= 0 && prevCol < N) {
            nextDp[row][col] =
              nextDp[row][col] + prevDp[prevRow][prevCol] / 8;
          }
        }
      }
    }
    prevDp = nextDp;
    nextDp = new Array(N).fill(0).map(() => new Array(N).fill(0));
  }

  let res = 0;
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      res += prevDp[i][j];
    }
  }

  return res;
};

console.log(knightProbability(6, 2, 2, 2))