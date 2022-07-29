// A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

// Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

// The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

// The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

// Return the number of minutes needed to inform all the employees about the urgent news.

//Step1 verify the constraints
// cyclic? nodes end up in the origianl node during traversal, so no cycles because tree
// unconnected? all of node are connected so no
// weighted?
// direct? it is guaranteed that the subordination relationships have a tree structure so this is a directed graph


//Step2 write out testcase
// Input: n = 1, headID = 0, manager = [-1], informTime = [0]
// Output: 0
// Explanation: The head of the company is the only employee in the company.

//it is an adjacency list
// Input: n = 8, headID = 4, manager = [2,2,4,6,-1,4,4,5], informTime = [0,0,4,0,7,3,6,0]
// 0[[],
// 1[],
// 2[0,1],
// 3[],
// 4[2,5,6],
// 5[7],
// 6[3],
// 7[]]

//finding max total minutes
//BFS or DFS
//DFS


const numOfMinutes = function(n, headID, manager, informTime) {
  const adjList = manager.map(() => []);
  for(let e=0;e<n;e++){//O(n)
    const managers = manager[e];
    if(managers === -1) continue;
    adjList[managers].push(e);
  }
  return dfs(headID,adjList, informTime);
};

const dfs = function(currentID, adjList, informTime) {
  if(adjList[currentID].length === 0) return 0;
  let max = 0;
  const subordinates = adjList[currentID];
  for(let i=0;i<subordinates.length;i++) {//O(n)
    max = Math.max(max, dfs(subordinates[i], adjList, informTime));
  }
  return max + informTime[currentID];
}