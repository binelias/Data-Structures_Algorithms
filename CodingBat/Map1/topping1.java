// Given a map of food keys and topping values, modify and return the map as follows: if the key "ice cream" is present, set its value to "cherry". In all cases, set the key "bread" to have the value "butter".


// topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
// topping1({}) → {"bread": "butter"}
// topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
import java.util.Map;

package CodingBat.Map1;

public class topping1 {
  public Map<String, String> solution(Map<String, String> map) {
    if(map.containsKey("ice cream")) {
      map.put("bread", "butter");
      map.put("ice cream", "cherry");
    } else {
      map.put("bread", "butter");
    }
    return map;
  }
}
