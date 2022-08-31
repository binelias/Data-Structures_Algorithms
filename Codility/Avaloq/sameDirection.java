package Avaloq;

// write a java program for you are given a string representing a sequence of N arrows,each pointing in one of the four cardinal directions:up(^),down(v),left(<),right(>) . write a function solution that,given a string S denoting the direction of the arrows,returns the minimum number of arrows that must be rotated to make them all point in the same direction.

public class sameDirection {
  static int lowestArrowDirection(String S){
    char up = '^';
    char down = 'v';
    char left = '<';
    char right = '>';

    //Now count the number of each to determine the count for each
    int upCount = 0;
    int downCount = 0;
    int leftCount = 0;
    int rightCount = 0;
    for(int i = 0; i < S.length(); i++){
      int index = i;
      // Get the specific character
      char ch = S.charAt(index);
      if (ch == up){
        upCount += 1;
      }else if (ch == down){
        downCount += 1;
      }else if (ch == left){
        leftCount += 1;
      }else if (ch == right){
        rightCount += 1;
      }
    }
    //now determine the maximum in order to know which direction others sholud follow
    int[] directions ={upCount,downCount,leftCount,rightCount};
    int maximumIndex = 0;
    int maximum = 0;
    int lowestSum = 0;
    for(int j = 0; j < 4; j++){
      if(directions[j]>maximum){
        maximum = directions[j];
        maximumIndex = j;
      }
    }

    //Now add the three lowest
    for(int x = 0; x < 4; x++){
      if(maximumIndex != x){
        lowestSum += directions[x];
      }
    }
    return  lowestSum;
  }
}
