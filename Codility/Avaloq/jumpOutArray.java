package Avaloq;
import java.util.*;

public class jumpOutArray {
  public int solution(int[] A) {
		int currIdx = 0;
		int jumps = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < A.length; i++) {
			map.put(i, A[i]);
		}
		
		while(currIdx >= 0 && currIdx < A.length) {
			if(map.get(currIdx) != null) {
				int val = map.get(currIdx);
				map.put(currIdx, null);
				currIdx += val;
				jumps += 1;
			}else {
				return -1;
			}
		}
		return jumps;
	}
		
	public static void main(String[] args) {
		System.out.println(new JumpOutArray().solution(new int[] {2, 3, -1, 1, 3}));
	}
}
