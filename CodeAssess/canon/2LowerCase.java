// Input:
// abcdEfGhl

// Output:
// abcdefghl

package CodeAssess.canon;
import java.io.*;
import java.util.*;

public class LowerCase {
	public String solution(String str) {
		return str.toLowerCase();
    }
	public static void main(String[] args) throws java.lang.Exception{
		LowerCase lc = new LowerCase();
		System.out.println(lc.solution(new String("abcdEfGhl")));
	}
}
