// Sample Input
// 6

// Sample Output
// I implemented: AdvancedArithmetic
// 12
// Explanation

// The integer 6 is evenly divisible by 1, 2, 3, and 6. Our divisorSum method should return the sum of these numbers, which is 1+2+3+6 =12. The Solution class then prints I implemented: AdvancedArithmetic  on the first line, followed by the sum returned by divisorSum (which is 12) on the second line.

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(n);
        //if n is odd, we can't have even numbers as divisors
        int stepSize =(n%2 == 1) ? 2 : 1; 
        
        for(int i =1; i <= sqrt; i+=stepSize) {
          if(n%i == 0) sum += i + n/i;
        }
        // If sqrt is a divisor, we should only count it once
        if(sqrt*sqrt == n) sum -= sqrt;
        return sum;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}