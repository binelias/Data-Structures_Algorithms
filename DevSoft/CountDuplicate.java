import java.util.*;

public class CountDuplicate {
	public static void main(String[] args) {
        Integer[] intArr = { 7, 2, 6, 1, 4, 7, 4 };
        List<Integer> listInt = Arrays.asList(intArr);

        Map<Integer, Integer> map = new HashMap<>();
        Integer dupCount = 0;
        int ways=0;

        for (Integer integer : intArr) {
            int times = Collections.frequency(listInt, integer);
            if (map.containsKey(integer)) {
                dupCount++;
            } else map.put(integer, times);
        }
        for (Integer value: map.values()) {
            if(value == 2) ways++;
        }
        if(ways>0)  System.out.println(ways);
        else System.out.println("null");
    }
}
