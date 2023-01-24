// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

// Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

// Example 1:

// Input: n = 2, trust = [[1,2]]
// Output: 2
// Example 2:

// Input: n = 3, trust = [[1,3],[2,3]]
// Output: 3
// Example 3:

// Input: n = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1

class Solution {
  public int findJudge(int n, int[][] trust) {
    int arr[] = new int[n + 1]; // Define an array of length n+1

    for (int i = 0; i < trust.length; i++) { // loop through the 'trust' array
      arr[trust[i][0]]--; // if a given person trust someone then decrement the count of his index
      arr[trust[i][1]]++; // increment the count of the index whom he trusts

    }
    // In last, check the 'arr' array that if there is any index having count equals
    // to n-1
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == n - 1)
        return i; // person doesnt trust anybody but everyone else trust him. Return their index
    }
    return -1;
  }// T:O(n), S:O(n)
}