Sample Input
13

Sample Output
prime

public class JavaPrimalityTest {
  import java.io.*;
import java.util.*;

import java.math.BigInteger;


public class Solution {
  public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);

      BigInteger n = sc.nextBigInteger();
      System.out.println(n.isProbablePrime(10) ? "prime" : "not prime");
      sc.close();
  }
}

