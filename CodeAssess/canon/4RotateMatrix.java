// Input
// 3
// 10 11 6
// 7 7 12
// 11 9 10

// Output
// 11 7 10
// 9 7 11
// 10 12 6

// Input1
// 1
// 9

// Output
// 9


package CodeAssess.canon;

public class RotateMatrix {
	public void solution(int n, int matrix[][]) {
		int row= 0;
		int col= 0;
		//Reverse each row 
		for(row=0; row<matrix.length/2;row++) {
			int[] rotate = matrix[row];
			matrix[row] = matrix[matrix.length - row -1];
			matrix[matrix.length - row -1] = rotate;
		}
		
		//Rotate 90 degree clockwise
		for(row=0; row<matrix.length-1;row++) {
			for(col=row+1; col<matrix.length; col++) {
				int rotate = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = rotate;
			}
		}
		//Print rotated matrix
		for(int i=0; i<n;i++) {
			for (int j = 0; j <n; j++) {
				System.out.print( matrix[i][j] + " ");
		  }
			System.out.print("\n");
		}
    }
	
	public static void main(String[] args) throws java.lang.Exception{
		RotateMatrix rm = new RotateMatrix();
		rm.solution(3, new int[][] {{10,11,6},{7,7,12},{11,9,10}});
	}
}
