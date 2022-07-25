
// Modify and return the given map as follows: if the keys "a" and "b" are both in the map and have equal values, remove them both.


// mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
// mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
// mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
import java.util.Map;


package CodingBat.Map1;

public class mapAB2 {
  public Map<String, String> solution(Map<String, String> map) {
    if(map.containsKey("a") && map.containsKey("b")) {
      String a =map.get("a");
      String b =map.get("b");
      if(a.equals(b)) {
        map.remove("a");
        map.remove("b");
      }
    }
    return map;
  }
  
}
