// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

const numIslands = function(grid) {
  const height = grid.length;
  const width = grid[0].length;
  let counter = 0;
  const exists = (i, j) =>  (i >= 0 && i < height && j >= 0 && j < width);
  const visit = (i, j) => grid[i][j]='0';
  
  const check = (i, j, q) => {
      if(exists(i, j)){
          if(grid[i][j] == '1'){
              visit(i, j)
              q.push({i, j})
          }
      }
  }
  
  for(let i =0; i < height; i++){
      for(let j=0; j < width; j++){
          if(grid[i][j] == '1'){
              counter++;
              visit(i,j);
              const q = [{i, j}];
              while(q.length > 0){
                  const c = q.shift();
                  check(c.i-1, c.j, q);//up
                  check(c.i+1, c.j, q);//down
                  check(c.i, c.j-1, q);//left
                  check(c.i, c.j+1, q);//right
              }
          }
      }
  }
  return counter;
};

// const numberOfIslands = function(grid) {
//   if(grid.length === 0) return 0;
//   let islandCount = 0;

//   for(let row = 0; row < grid.length; row++) {
//     for(let col = 0; col < grid[0].length; col++) {
//       if(grid[row][col] === 1) {
//         islandCount++;
//         grid[row][col] = 0;
//         const queue = [];
//         queue.push([row, col]);

//         while(queue.length) {
//           const currentPos = queue.shift();
//           const currentRow = currentPos[0];
//           const currentCol = currentPos[1];

//           for(let i = 0; i < directions.length; i++) {
//             const currentDir = directions[i];
//             const nextRow = currentRow + currentDir[0];
//             const nextCol = currentCol + currentDir[1];

//             if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;

//             if(grid[nextRow][nextCol] === 1) {
//               queue.push([nextRow, nextCol]);
//               grid[nextRow][nextCol] = 0;
//             }
//           }
//         }
//       }
//     }
//   }
//   return islandCount;
// }

// const testMatrix = [
//   [1, 1, 1, 0, 0],
//   [1, 1, 1, 0, 1],
//   [0, 1, 0, 0, 1],
//   [0, 0, 0, 1, 1]
// ];

// const directions = [
//   [-1, 0], //up
//   [0, 1], //right
//   [1, 0], //down
//   [0, -1] //left
// ]

// const numberOfIslands2 = function(matrix) {
//   if(matrix.length === 0) return 0;
//   let islandCount = 0;

//   for(let row = 0; row < matrix.length; row++) {
//     for(let col = 0; col < matrix[0].length; col++) {
//       if(matrix[row][col] === 1) {
//         islandCount++;
//         matrix[row][col] = 0;
//         const queue = [];
//         queue.push([row, col]);

//         while(queue.length) {
//           const currentPos = queue.shift();
//           const currentRow = currentPos[0];
//           const currentCol = currentPos[1];

//           for(let i = 0; i < directions.length; i++) {
//             const currentDir = directions[i];
//             const nextRow = currentRow + currentDir[0];
//             const nextCol = currentCol + currentDir[1];

//             if(nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) continue;

//             if(matrix[nextRow][nextCol] === 1) {
//               queue.push([nextRow, nextCol]);
//               matrix[nextRow][nextCol] = 0;
//             }
//           }
//         }
//       }
//     }
//   }

//   return islandCount;
// }

// console.log(numberOfIslands(testMatrix));