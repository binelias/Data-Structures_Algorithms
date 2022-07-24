// Sample Input
// Hello world
// I am a file
// Read me until end-of-file.

// Sample Output
// 1 Hello world
// 2 I am a file
// 3 Read me until end-of-file.

package HackerRank.JavaPython.Introduction;
import java.util.Scanner;


public class javaEndFile {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    int i = 1;
    while (sc.hasNext()) {
        System.out.println(i++ + " " + sc.nextLine());
    }
    sc.close();
}
}
