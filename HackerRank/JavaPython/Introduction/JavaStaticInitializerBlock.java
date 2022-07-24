// Sample input 1
// 1
// 3
// Sample output 1
// 3

// Sample input 2
// -1
// 2
// Sample output 2
// java.lang.Exception: Breadth and height must be positive

package HackerRank.JavaPython.Introduction
import java.util.Scanner;

public class JavaStaticInitializerBlock {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int B, H;
        Scanner reader = new Scanner(System.in);
        B = reader.nextInt();
        H = reader.nextInt();
        if (B <= 0 || H <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else {
            System.out.println(B*H);
        }
    }
}
