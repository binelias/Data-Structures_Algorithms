// The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.


// sleepIn(false, false) → true
// sleepIn(true, false) → false
// sleepIn(false, true) → true

package CodingBat.java.Warmup1;

public class sleepIn {
	public boolean solution(boolean weekday, boolean vacation) {
		  if(vacation || !weekday){
		    return true;
		  }else {
		    return false;
		  }
	}
}

