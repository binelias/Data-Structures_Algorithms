package CodingBat.java.Warmup1;

public class nearHundred {
  public boolean solution(int n) {
    int x = Math.abs(100-n);
    int y = Math.abs(200-n);
    return x<=10 || y<=10;
  }
}
