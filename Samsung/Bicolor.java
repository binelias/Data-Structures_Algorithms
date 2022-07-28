// Problem Details

// Maximum Points: 150
// Description

// The problem asks you to check if a graph is bicolorable. The graph is only bicolorable if every node can be colored using two colors, where neighbors would not have the same color. 

// The problem describes the graph using its edges; it is up to you to connect together the whole graph since the only thing given per edge is two points connected with each other. The problem also makes sure of the following: 

//     there is no edge that would point from a node to the same node
//     the graph is undirected; when node a is connected to node b, node b is also connected to node a
//     the graph is strongly connected; every node is reachable from any node, and there is at least one path from any node to any other node

// Constraints:

//     Number of test cases T: 1 <= T <= 1000
//     Number of nodes N: 1 < N < 200
//     Number of edges L: 0 <= L < N

// Input

// The first line contains the number of test cases T. 

// The next lines contain the test cases. The first line of each test case contains the number of nodes N of the graph. The second line contains the number of edges L. The next L lines each contains two numbers describing nodes connected by an edge on the graph. 
// Output

// For each test case, output a line containing "Case #x: " where x is the case number, followed by "BICOLORABLE" if the graph is bicolorable, or "NOT BICOLORABLE" otherwise. 
// Sample Input

// 3
// 3
// 3
// 0 1
// 1 2
// 2 0
// 3
// 2
// 0 1
// 1 2
// 9
// 8
// 0 1
// 0 2
// 0 3
// 0 4
// 0 5
// 0 6
// 0 7
// 0 8
// Sample Output

// Case #1: NOT BICOLORABLE
// Case #2: BICOLORABLE
// Case #3: BICOLORABLE

package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static boolean [][] mat;
	public static int [] color;
	
	public static boolean fillColor (int id, int toFill) {
		if (color[id]==Integer.MAX_VALUE) {
			boolean flag=true;
			color[id]=toFill;
			for (int i=0;i<mat.length && flag;i++) {
				if (mat[id][i]) {
					flag=fillColor(i,1-toFill);
				}
			}
			return flag;
		} else if (color[id]!=toFill) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n=Integer.parseInt(br.readLine());
			if (n==0) {
				break;
			}
			int l=Integer.parseInt(br.readLine());
			mat=new boolean [n][n];
			color=new int [n];
			Arrays.fill(color, Integer.MAX_VALUE);
			
			for (int i=0;i<l;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				if (src!=dest) {
					mat[src][dest]=true;
					mat[dest][src]=true;
				}
			}
			
			if (fillColor(0,0)) {
				System.out.println("BICOLORABLE.");
			} else {
				System.out.println("NOT BICOLORABLE.");
			}
		}
	}
}


