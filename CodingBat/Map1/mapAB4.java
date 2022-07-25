// Modify and return the given map as follows: if the keys "a" and "b" have values that have different lengths, then set "c" to have the longer value. If the values exist and have the same length, change them both to the empty string in the map.


// mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
// mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
// mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
import java.util.Map;

package CodingBat.Map1;

public class mapAB4 {
  public Map<String, String> solution(Map<String, String> map) {
    String a = map.get("a");
    String b = map.get("b");
    if(!map.containsKey("a") || !map.containsKey("b")){
      return map;
    }else if(a.length() > b.length()) {
      map.put("c", map.get("a"));
    }else if(b.length() > a.length()) {
      map.put("c", map.get("b"));
    }else if(a.length() == b.length()){
      map.put("a", "");
      map.put("b", "");
    }
    return map;
  }
}
