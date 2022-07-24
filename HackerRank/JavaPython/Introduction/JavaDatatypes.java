// Sample Input
// 5
// -150
// 150000
// 1500000000
// 213333333333333333333333333333333333
// -100000000000000

// Sample Output
// -150 can be fitted in:
// * short
// * int
// * long
// 150000 can be fitted in:
// * int
// * long
// 1500000000 can be fitted in:
// * int
// * long
// 213333333333333333333333333333333333 can't be fitted anywhere.
// -100000000000000 can be fitted in:
// * long

package HackerRank.JavaPython.Introduction;
import java.util.Scanner;

public class JavaDatatypes {
  public static void main(String []args)
  {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();

    for(int i=0;i<t;i++)
    {

      try
      {
          long x=sc.nextLong();
          System.out.println(x+" can be fitted in:");
          if(x>=-128 && x<=127)System.out.println("* byte");
          //Complete the code
          if (x >= -(Math.pow(2, 16 - 1)) && x <= (Math.pow(2, 16 - 1) - 1))System.out.println("* short");
          if (x >= -(Math.pow(2, 32 - 1)) && x <= (Math.pow(2, 32 - 1) - 1))System.out.println("* int");
          if (x >= -(Math.pow(2, 64 - 1)) && x <= (Math.pow(2, 64 - 1) - 1))System.out.println("* long");
      }
      catch(Exception e)
      {
          System.out.println(sc.next()+" can't be fitted anywhere.");
      }

    }
  }
}
