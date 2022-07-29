// A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

// Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

// The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

// The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

// Return the number of minutes needed to inform all the employees about the urgent news.

package Leetcode.Medium.Graphs;
import java.util.*;

public class TimeNeededInformAllEmployees {
  int max;
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
      if(n == 1)
          return 0;
      int[] time = new int[n];
      List<Integer> edge = new ArrayList<>();
      for(int i = 0;i < n;i++)
          edge.add(new ArrayList<>());
      for(int i = 0;i < n;i++){
          if(manager[i] != -1)
              edge.get(manager[i]).add(i);
      }
      max = 0;
      dfs(edge, headID, informTime, 0);
      return max;
  }
  public void dfs(List<List<Integer>> edge, int curr, int[] inform, int time){
    int informNext = time + inform[curr];
    max = Math.max(informNext, max);
    for(int nei : edge.get(curr))
    dfs(edge, nei, inform, informNext);
  }
}
