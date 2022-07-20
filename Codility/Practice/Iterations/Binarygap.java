package Practice.Iterations;
//Soln 1
public class BinaryGap {
	
	public int solution(int N) {
		
		String bString = Integer.toString(N,2);
		
		boolean started = false;
		
		int count = 0;
		int maxCount = 0;
		
		for(int i=0; i<bString.length(); i++) {
			String c = bString.substring(i,i+1);
			if(c.equals("1")) {
				if(started) {
					if(count > maxCount) {
						maxCount = count;
					}
				}
				count = 0;
				started = true;
			}
			if(c.equals("0")) {
				count++;
			}
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		BinaryGap gb = new BinaryGap();
		System.out.println(gb.solution(1041));
	}

}

//second soln
public class BinaryGap2 {
	
	public int solution(int N) {
//		convert int to binary
  String biStr = Integer.toString(N,2);
  
  int count = 0;
  int maxCount = 0;
  
  for(int i=0; i<biStr.length(); i++) {
    char c = biStr.charAt(i);
    if(c == '0') {
      count++;
    }else {
      maxCount = Math.max(maxCount, count);
      count = 0;
    }
  }
  return maxCount;
}

public static void main(String[] args) {
  BinaryGap num = new BinaryGap();
  System.out.println(num.solution(5));
}
}