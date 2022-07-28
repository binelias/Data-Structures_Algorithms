package Leetcode.Medium.Arrays;

public class RotateImage {
  public void rotate(int[][] matrix) {
    for (int row = 0; row < matrix.length/2; row++) {
      int[] rotate = matrix[row];
      matrix[row] = matrix[matrix.length - row - 1];
      matrix[matrix.length - row - 1] = rotate;
    }

    for (int row = 0; row < matrix.length - 1; row++) {
      for (int col = row+1; col < matrix.length; col++) {
        int rotate = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = rotate;
      }
    } 
  }
}
