// Sample Input
// STDIN   Function
// -----   --------
// 3       __elements[] size N = 3
// 1 2 5   __elements = [1, 2, 5]

// Sample Output
// 4

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
  
	// Add your code here
    public int difference = 0;
    
    Difference(int elements[]) {
      this.elements = elements;
    }
    
    public int computeDifference() {
      for(int i=0; i<elements.length; i++) {
        for(int j = 0; j<elements.length; j++) {
          difference = elements[i] - elements[j];
          if(difference>maximumDifference) {
            maximumDifference = difference;
          }
        }
      }
      return maximumDifference;
    }

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}