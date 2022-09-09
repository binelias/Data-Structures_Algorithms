// Sample Input
// {}()
// ({()})
// {}(
// []

// Sample Output
// true
// true
// false
// true
import java.util.*;
class Solution{

// ArrayDeque is "likely to be faster than Stack when used as a stack" - Java documentation	
    
	public static void main(String []argh)
	{
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input, map) ? "true" : "false" );
        }
        sc.close();
		
	}
    private static boolean isBalanced(String expression, HashMap<Character,Character> map) {
        if((expression.length() % 2) != 0) return false;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if(map.containsKey(ch)) deque.push(ch);
            else if(deque.isEmpty() || ch != map.get(deque.pop())) return false;
        }
        return deque.isEmpty();
    } 
}