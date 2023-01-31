// You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

// However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

// Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

// Example 1:

// Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
// Output: 34
// Explanation: You can choose all the players.
// Example 2:

// Input: scores = [4,5,6,5], ages = [2,1,2,1]
// Output: 16
// Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
// Example 3:

// Input: scores = [1,2,3,5], ages = [8,9,10,1]
// Output: 6
// Explanation: It is best to choose the first 3 players. 

// Constraints:

// 1 <= scores.length, ages.length <= 1000
// scores.length == ages.length
// 1 <= scores[i] <= 106
// 1 <= ages[i] <= 1000

// Top-Down Dynamic Programming
// Intuition
// We are given two lists of integers. These lists represent the score and age, respectively, of each of the NNN players. We need to find the highest score of the non-conflicting team. A team has conflict if a younger player has a strictly higher score than an older player.

// Whether a player stays in the team depends on his age and score, as well as the age and score of other players in the team. So we need to consider these two parameters before making any decision. We can reduce these two considerable parameters to one by sorting the players according to the other parameter, i.e., if we sort by age, then we only need to consider score and vice versa. In this approach, we will sort the players in ascending order of age. The benefit of sorting is that now when we start choosing players from left to right, we know that the age of the player we choose will always be greater than the age of the players we have already chosen. Hence we only need to think about the score of players.

// Once we have sorted the players in ascending order of age, we will iterate them from smallest to largest age. For each player in the iteration, we either:

// Add this player to the team if he doesn't conflict with the team.
// Do not add the player to the team.
// To check if the current player makes the team conflicting, we need to have the previous player we have chosen. The reason is that the players we have already chosen are non-conflicting. Since the players are in increasing order of their age, they would also need to be in non-decreasing order of the score (because that's necessary for the team to be non-conflicting). Hence the last player we have chosen will have the highest age and score. Now, if the score of the current player is more than the last player we have chosen, we can add this player to the team; otherwise, not.

// For this recursive approach, what are the parameters that we need to track? The first parameter is the index of the player we are currently considering as we traverse the players. Secondly, we must keep track of the last player index prev we chose.

// In this approach, we will have to iterate over all the 2N2^N2 
// N
//   possibilities and hence is not efficient. If we observe the below figure, there are repeated subproblems. Notice the green nodes are repeated subproblems signifying that we have already solved these subproblems before. To avoid recalculating results for previously seen subproblems, we will memoize the result for each subproblem. So the next time we need to calculate the result for the same set of parameters {index, prev}, we can simply look up the result in constant time instead of recalculating the result.

// fig

// Algorithm
// Store the ages and scores of all the players in the list ageScorePair.

// Sort the list ageScorePair in ascending order of age and then in ascending order of score.

// Iterate over the players; start with index = 0 and prev = -1, as we haven't chosen any player yet.

// If it's the first player (prev = -1) or the player's score at index is more than the score of the player at index prev. Then we can add this player, and the score will be the maximum of the two choices we have.

// If we add this player, we will add the score, and the value of prev will be the current index index, and move on to the next player, i.e., index + 1.
// If we don't add this player, the value of prev won't change and move on to the next player.
// If the above two conditions are not satisfied, we only have the option to leave this player and move on to the next one.

// Base condition: If we have iterated over all the players, we should return 0.

class Solution {
  public int bestTeamScore(int[] scores, int[] ages) {
    final int n = ages.length;
    int[][] ageScorePair = new int[n][2];

    for (int i = 0; i < n; i++) {
      ageScorePair[i][0] = ages[i];
      ageScorePair[i][1] = scores[i];
    }

    // Sort in ascending order of age and then by score.
    Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    // Initially, all states are null, denoting not yet calculated.
    Integer[][] dp = new Integer[n][n];

    return findMaxScore(dp, ageScorePair, -1, 0);
  }

  private int findMaxScore(Integer[][] dp, int[][] ageScorePair, int prev, int index) {
    // Return 0 if we have iterated over all the players.
    if (index >= ageScorePair.length) {
      return 0;
    }

    // We have already calculated the answer, so no need to go into recursion.
    if (dp[prev + 1][index] != null) {
      return dp[prev + 1][index];
    }

    // If we can add this player, return the maximum of two choices we have.
    if (prev == -1 || ageScorePair[index][1] >= ageScorePair[prev][1]) {
      return dp[prev + 1][index] = Math.max(findMaxScore(dp, ageScorePair, prev, index + 1),
          ageScorePair[index][1] + findMaxScore(dp, ageScorePair, index, index + 1));
    }

    // This player cannot be added; return the corresponding score.
    return dp[prev + 1][index] = findMaxScore(dp, ageScorePair, prev, index + 1);
  }
}