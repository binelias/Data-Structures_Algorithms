// Sample Input
// 5
// 12 0 1 78 12
// 2
// Insert
// 5 23
// Delete
// 0

// Sample Output
// 0 1 78 12 23

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.add(val);
        }
        
        //Insert and Remove Queries
        int m =sc.nextInt();
        for(int i = 0; i < m; i++) {
            String action = sc.next();
            if(action.equals("Insert")) {
                int idx = sc.nextInt();
                int val = sc.nextInt();
                list.add(idx, val);
            }else {
                int idx = sc.nextInt();
                list.remove(idx);
            }
        }
        sc.close();
        
        //Print answer
        for(Integer lists : list) {
            System.out.print(lists + " ");
        }
    }
}