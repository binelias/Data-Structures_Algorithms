// Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.


// mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
// mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
// mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
import java.util.Map;

package CodingBat.Map1;

public class mapShare {
  public Map<String, String> solution(Map<String, String> map) {
    if(map.containsKey("a")) {
      map.put("b", map.get("a"));
      map.remove("c");
    }else {
      map.remove("c");
    }
    return map;
  }
}
