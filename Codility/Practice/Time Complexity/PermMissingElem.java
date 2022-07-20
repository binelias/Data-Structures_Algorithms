package Time Complexity;
// An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

// Your goal is to find that missing element.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A, returns the value of the missing element.

// For example, given array A such that:

//   A[0] = 2
//   A[1] = 3
//   A[2] = 1
//   A[3] = 5
// the function should return 4, as it is the missing element.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [0..100,000];
// the elements of A are all distinct;
// each element of array A is an integer within the range [1..(N + 1)].
import java.util.HashSet;

public class PermMissingElem {
  
  public int solution(int[] A) {
	HashSet<Integer> list = new HashSet<>();
	for(int i=1; i<=A.length+1; i++) {
	  list.add(i);
	}
	for(int i=0; i<A.length; i++) {
	  list.remove((Integer)A[i]);
	}
	return list.iterator().next();
  }
  
  //sum of arithmetic mean
  public int solution2(int[] A){
	  int N = A.length + 1;
	  int mean = N * (N + 1) / 2;
	  //For each integer i in the array called A
	  for (int i : A) {
	    mean -= i;
	  }
	  return (int) (mean);
  }
  public static void main(String[] args) {
    System.out.println(new PermMissingElem().solution2(new int[] {2,3,1,5}));
  }
}

