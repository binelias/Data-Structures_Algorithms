// Input Format

// The first and only line of input contains four space-separated integers p, d, m and s.

// ou wish to buy video games from the famous online video game store Mist.

// Usually, all games are sold at the same price, p dollars. However, they are planning to have the seasonal Halloween Sale next month in which you can buy games at a cheaper price. Specifically, the first game will cost p dollars, and every subsequent game will cost d dollars less than the previous one. This continues until the cost becomes less than or equal to m dollars, after which every game will cost m dollars. How many games can you buy during the Halloween Sale?

// Sample Input 0

// 20 3 6 80
// Sample Output 0

// 6
// Explanation 0

// Assumptions other than starting funds, , match the example in the problem statement. With a budget of 80, you can buy 6 games at a cost of 20+17+14+11+8+6=76. A 7th game for an additional 6 units exceeds the budget.

// Sample Input 1

// 20 3 6 85
// Sample Output 1

// 7
// Explanation 1

// This is the same as the previous case, except this time the starting budget s=85 units of currency. This time, you can buy 7 games since they cost 20+17+14+11+8+6+6=82. An additional game at  units will exceed the budget. HolloweenSale {
  
// }

int i = 0, n = 0, c = p;
        while (s > 0) {
            c = p - (i * d);
            if (c <= m) {
                c = m;
            } 
            s -= c;
            if (s >= 0) {
                n++;
            }
            i++;
        }
        return n;
