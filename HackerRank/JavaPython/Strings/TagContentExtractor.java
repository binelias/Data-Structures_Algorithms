// Sample Input
// 4
// <h1>Nayeem loves counseling</h1>
// <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
// <Amee>safat codes like a ninja</amee>
// <SA premium>Imtiaz has a secret crush</SA premium>

// Sample Output
// Nayeem loves counseling
// Sanjay has no watch
// So wait for a while
// None
// Imtiaz has a secret crush

import java.util.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
			boolean matchFound = false;
            Pattern t = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = t.matcher(line);
            while(m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if(!matchFound) {
                System.out.println("None");
            }
			testCases--;
		}
        in.close();
	}
}
