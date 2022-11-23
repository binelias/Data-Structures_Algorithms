// 

// Algorithm:
// 1 win, 2 win, 3 win, 4 lose.
// 5 win because I can take 1 and there 4 stones left, which is losing condition.
// 6 win, since I can take 2.
// 7 win, since I can take 3.
// 8 lose, since I can't make it left 4 stones, since my max move is removing only 3 stones.
// The rest can be proven by induction.

class Solution {
  public boolean canWinNim(int n) {
    return n % 4 != 0;
  }
}