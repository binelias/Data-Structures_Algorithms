// Sample Input 0
// 3

// Sample Output 0
// Weird

// Sample Input 1
// 24

// Sample Output 1
// Not Weird


package HackerRank.JavaPython.30 Days of Code;

import java.io.*;




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if(N%2 == 0) {
            if(N>=2 && N<=5) {
                System.out.println("Not Weird");
            }else if(N>=6 && N<=20) {
                System.out.println("Weird");
            }else if(N>20) {
                System.out.println("Not Weird");
            }
        }else {
            System.out.println("Weird");
        }
        bufferedReader.close();
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if(N%2 == 1 || N>=6 && N<=20 ) {
            System.out.println("Weird");
            
        }else {
            System.out.println("Not Weird");
        }
        bufferedReader.close();
    }
}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if(N%2 == 0 && (N>20 || N>=2 && N<=5) ) {
            System.out.println("Not Weird");
            
        }else {
            System.out.println("Weird");
        }
        bufferedReader.close();
    }
}

