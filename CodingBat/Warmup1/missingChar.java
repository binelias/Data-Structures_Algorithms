package CodingBat.Warmup1;

public class missingChar {
  public String solution(String str, int n) {
    String ch1 = str.substring(0, n);
    String ch2 = str.substring(n+1);
    return ch1 +ch2;
  }
}
