// Input
// [1,8,6,2,9,4]

// Output
// [8,9]
// area = 8*3 = 24

package FAANG.Arrays.ContainerWater;

public class Solution {
  public int maxArea(int[] height) {
      int p1 = 0, p2 = height.length-1, maxxArea = 0;
      while(p1<p2) {
          int heights = Math.min(height[p1],height[p2]);
          int width = p2-p1;
          int area = heights*width;
          maxxArea = Math.max(maxxArea, area);

          if(height[p1] <= height[p2]) p1++;
          else p2--;
      }
      return maxxArea;
  }
} ContainerWater {
  
}
