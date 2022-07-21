// Input
// 2
// Output
// 2 x 1 = 2
// 2 x 2 = 4
// 2 x 3 = 6
// 2 x 4 = 8
// 2 x 5 = 10
// 2 x 6 = 12
// 2 x 7 = 14
// 2 x 8 = 16
// 2 x 9 = 18
// 2 x 10 = 20


package HackerRank.Java.Introduction;
import java.io.*;


public class javaLoopsI {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine().trim());
    for (int i = 1; i <= 10; i++) {
        System.out.println(N + " x " + i + " = " + N * i);
    }
    bufferedReader.close();
}
}
