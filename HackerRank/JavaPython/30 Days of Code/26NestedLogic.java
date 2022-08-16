// Sample Input
// STDIN       Function
// -----       --------
// 9 6 2015    day = 9, month = 6, year = 2015 (date returned)
// 6 6 2015    day = 6, month = 6, year = 2015 (date due)

// Sample Output
// 45

// Explanation
// Given the following return dates:
// Returned: 
// D1 = 9, M1 = 6, Y1 = 2015
// Due: 
// D2 = 6, M2= 6, Y2 =2015
// Because Y2 = Y1, it is less than a year late.
// Because M2 = M1, it is less than a month late.
// Because D2 < D1, it was returned late (but still within the same month and year).

// Per the library's fee structure, we know that our fine will be 15 Hackos x (#days late). We then print the result of 15 x(D1 -D2) = 15 x (9-6) = 45  as our output.

import java.util.*;
import java.time.LocalDate;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Ask for input
        Scanner sc = new Scanner(System.in);
        LocalDate returnDate = readDate(sc);
        LocalDate dueDate = readDate(sc);
        sc.close();
        
        int fine;
        
        if(returnDate.isEqual(dueDate) || returnDate.isBefore(dueDate)) fine = 0;
        else if(returnDate.getMonth() == dueDate.getMonth() && returnDate.getYear() == dueDate.getYear()) fine = 15*(returnDate.getDayOfMonth() - dueDate.getDayOfMonth());
        else if(returnDate.getYear() == dueDate.getYear()) fine = 500*(returnDate.getMonthValue()-dueDate.getMonthValue());
        else fine = 10000;
        
        System.out.println(fine);
    }
    
    private static LocalDate readDate(Scanner sc) {
      int day = sc.nextInt();
      int month = sc.nextInt();
      int year = sc.nextInt();
      return LocalDate.of(year, month, day);
    }
}