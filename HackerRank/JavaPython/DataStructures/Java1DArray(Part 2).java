// Sample Input
// STDIN           Function
// -----           --------
// 4               q = 4 (number of queries)
// 5 3             game[] size n = 5, leap = 3 (first query)
// 0 0 0 0 0       game = [0, 0, 0, 0, 0]
// 6 5             game[] size n = 6, leap = 5 (second query)
// 0 0 0 1 1 1     . . .
// 6 3
// 0 0 1 1 1 0
// 3 1
// 0 1 0

// Sample Output
// YES
// YES
// NO
// NO

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        if(game == null) return false;
        return isSolvable(leap, game, 0);
    }
    
    private static boolean isSolvable( int leap, int[] game, int i) {
        //Base case
        if(i >= game.length) return true;
        else if(i < 0 || game[i] == 1) return false;
        
        //marks as visited
        game[i] = 1;
        
        //Recursive case
        return isSolvable(leap, game, i + leap) || isSolvable(leap, game, i + 1) || isSolvable(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}