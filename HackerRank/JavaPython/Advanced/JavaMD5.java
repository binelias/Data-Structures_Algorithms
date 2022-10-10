// 

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    sc.close();

    // encode string using md5
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(str.getBytes());
    byte[] digest = md.digest();

    // print encoded val in hexa
    for (byte b : digest) {
      System.out.format("%02x", b);
    }
  }
}