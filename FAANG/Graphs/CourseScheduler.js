// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false cuz there's a cycle

// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

//Example 3:
// Input: numCourses = 6, prerequisites = [[1,0],[2,1], [2,5], [0,3], [4,3], [3,5], [4,5]]
// Output: True cuz there's no cycle

//Step1 Verify Constraints
//Can we have courses unconnected to other courses? Yes

//Directed Graph
//Adj list
// 0[1]
// 1[2]  
// 2[]
// 3[0,4]
// 4[]
// 5[2,3,4]

//Brute Soln
//full traversal to confirm if it's not a cycle through DFS pr BFS

//Brute force soln
const canFinish = function(numCourses, prerequisites) {
  const adjList = new Array(numCourses).fill(0).map(() => []);
  for(let i = 0; i<prerequisites.length; i++) {//P
    const pair = prerequisites[i];
    adjList[pair[1]].push(pair[0]);
  }

  for( let vert = 0; vert<numCourses; vert++) {//n^3
    const queue = [];
    const seen = {};
    for( let i = 0; i<adjList[vert].length; i++) {
      queue.push(adjList[vert][i]);
    }
    while(queue.length) {
      const current = queue.shift();
      seen[current] = true;
      if(current === vert) return false;
      const adjacent = adjList[current];
      for(let i =0; i < adjacent.length; i++) {
        const next = adjacent[i];
        if(!seen[next]) {
          queue.push(next);
        }
      }
    }
  }
  return true;
};//T: O(P + n^3), S:O(n^2)


//Optimal soln using Topological Sort algorithm
// Directed Acyclic Graph
// Indegree: number of edges pointing toward the node
//0[1,
//1 1,
//2 2,
//3 1,
//4 2,
//5 0]

//Adj list
// 0[1]
// 1[2]
// 3[0,4]
// 4[]
// 5[2,3,4]

//numCourses = 6, prerequisites = [[1,0],[2,1], [2,5], [0,3], [4,3], [3,5], [4,5]]

const canFinish2 = function(numCourses, prerequisites) {
  const inDegree = new Array(numCourses).fill(0);
  const adjList = inDegree.map(() => []);
  for (let i = 0; i < prerequisites.length; i++) {//O(P)
    const pair = prerequisites[i];
    inDegree[pair[0]]++;
    adjList[pair[1]].push(pair[0]);
  }

  const stack = [];
  for(let i = 0; i < inDegree.length; i++) {//O(n)
    if(inDegree[i] === 0) {
      stack.push(i);
    }
  }

  let count = 0;
  while(stack.length) {//O(n^2)
    const current = stack.pop();
    count++;
    const adjacent = adjList[current];
    for(let i = 0; i < adjacent.length; i++) {
      const next = adjacent[i];
      inDegree[next]--;
      if(inDegree[next] === 0) {
        stack.push(next);
      }
    }
  }
  return count === n;
}
//T: O(P + O(n^2)), S: O(n^2)
