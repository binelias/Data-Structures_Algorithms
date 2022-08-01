// Sample Input 1
// 5

// Sample Output 1
// 1

// Sample Input 2
// 13

// Sample Output 2
// 2


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int count = 0;
        int res = 0;
        
        while(n>0) {
            if(n%2==1){
                count++;
                if(count>=res){
                    res = count;
                }
            }else {
                count = 0;
            }
            n/=2;
        }
        System.out.print(res);
        bufferedReader.close();
    }
}

