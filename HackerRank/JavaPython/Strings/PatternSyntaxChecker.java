// Sample Input
// 3
// ([A-Z])(.+)
// [AZ[a-z](a-z)
// batcatpat(nat

// Sample Output
// Valid
// Invalid
// Invalid

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
        in.nextLine();

		while(testCases-- > 0){
			String pattern = in.nextLine();
          	//Write your code
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch(PatternSyntaxException exception) {
                System.out.println("Invalid");
            }
		}
        in.close();
	}
}
