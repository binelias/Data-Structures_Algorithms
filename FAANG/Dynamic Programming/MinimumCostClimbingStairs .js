// //For  a given staircase, the i-th step is assigned a non-negative cost indicated by a cost array.

// Once you pay the cost for a step, you can either climb one or two steps. Find the min cost to reach the top of the staircase. You first step can either be the first or step.


// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation:
// - Pay 1 and climb one step to reach index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - climb one step to reach the top.
// The total cost is 6.

//Top down recursion
/*
Recurrence relation: 
minCost(i) = cost[i] + min(minCost(i - 1), minCost(i - 2));
minCost(0) = cost[0];
minCost(1) = cost[1];
*/
const minCostClimbingStairs = function(cost) {
  const n = cost.length;
  return Math.min(minCost(n - 1, cost), minCost(n - 2, cost));
};

const minCost = function(i, cost) {
  if(i < 0) return 0;
  if(i === 0 || i === 1) return cost[i];
  return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost));
}//T: O(n), S: O(n)

console.log(minCostClimbingStairs([20, 15, 30, 5]))


//Top down optimized using DP
const minCostClimbingStairs1 = function(cost) {
  const n = cost.length;
  const dp = [];
  return Math.min(minCost2(n - 1, cost, dp), minCost2(n - 2, cost, dp));
};

const minCost2 = function(i, cost, dp) {
  if(i < 0) return 0;
  if(i === 0 || i === 1) return cost[i];
  if(dp[i] !== undefined) return dp[i];
  dp[i] = cost[i] + Math.min(minCost2(i - 1, cost, dp), minCost2(i - 2, cost, dp));
  return dp[i];
}//T: O(n),S: O(n)


//Bottom up iterative
/*
Recurrence relation:
minCost(i) = cost[i] + min(minCost(i - 1), minCost(i - 2));
minCost(0) = cost[0];
minCost(1) = cost[1]; 
*/

const minCostClimbingStairs2 = function(cost) {
  const n = cost.length;
  if(n === 0) return 0;
  if(n === 1) return cost[0];
  const dp = [];
  for(let i = 0; i < n; i++) {
    if (i < 2) {
      dp[i] = cost[i];
    } else {
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }
  }
  return Math.min(dp[n - 1], dp[n - 2]);
};//T: O(n), S: O(n)

console.log(minCostClimbingStairs2([20, 15, 30, 5]))

//Bottom up iterative optimized
/*
Recurrence relation:
minCost(i) = cost[i] + min(minCost(i - 1), minCost(i - 2));
minCost(0) = cost[0];
minCost(1) = cost[1];
*/

const minCostClimbingStairs3 = function(cost) {
  const n = cost.length;
  if(n === 0) return 0;
  if(n === 1) return cost[0];
  let dpOne = cost[0];
  let dpTwo = cost[1];
  for(let i = 2; i < n; i++) {
    const current = cost[i] + Math.min(dpOne, dpTwo);
    dpOne = dpTwo;
    dpTwo = current;
  }

  return Math.min(dpOne, dpTwo);
};//T: O(n), S: O(1)

console.log(minCostClimbingStairs3([20, 15]))














