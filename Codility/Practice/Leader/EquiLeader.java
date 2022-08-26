// A non-empty array A consisting of N integers is given.

// The leader of this array is the value that occurs in more than half of the elements of A.

// An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

// For example, given array A such that:

//     A[0] = 4
//     A[1] = 3
//     A[2] = 4
//     A[3] = 4
//     A[4] = 4
//     A[5] = 2
// we can find two equi leaders:

// 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
// 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
// The goal is to count the number of equi leaders.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

// For example, given:
//     A[0] = 4
//     A[1] = 3
//     A[2] = 4
//     A[3] = 4
//     A[4] = 4
//     A[5] = 2
// the function should return 2, as explained above.

package Practice.Leader;

import java.util.*;

public class EquiLeader {
	private int dominator;
	private int dominatorCount;

	public int solution(int[] A) {
		// write your code in Java SE 8
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			if (!map.containsKey(a)) {
				map.put(a, 1);
			} else {
				map.put(a, map.get(a) + 1);
			}
			if (map.get(a) > A.length / 2) {
				dominator = a;
				dominatorCount = map.get(a);
			}
		}
		int equiLeaders = 0;
		int leaderInRightSide = dominatorCount;
		int countRightSide = A.length;
		int leaderInLeftSide = 0;
		int countLeftSide = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == dominator) {
				leaderInRightSide--;
				leaderInLeftSide++;
			}
			countLeftSide++;
			countRightSide--;

			if (leaderInLeftSide > countLeftSide / 2) {
				if (leaderInRightSide > countRightSide / 2) {
					equiLeaders++;
				}
			}
		}
		return equiLeaders;
	}
}// T: O(n)
