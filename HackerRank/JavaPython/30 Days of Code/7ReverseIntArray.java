// Sample Input
// 4
// 1 4 3 2

// Sample Output
// 2 3 4 1
import java.io.*;


public class Solution {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    int [] arr = new int[n];
    String[] arrItems = sc.nextLine().split(" ");
    sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    for(int i=0; i<n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }
    for(int j=n-1; j>=0; j--) {
      System.out.print(arr[j] + " ");
    }
    sc.close();
  }
}
