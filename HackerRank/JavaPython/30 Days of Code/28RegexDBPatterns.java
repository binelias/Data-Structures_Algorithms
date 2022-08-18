// Sample Input
// 6
// riya riya@gmail.com
// julia julia@julia.me
// julia sjulia@gmail.com
// julia julia@gmail.com
// samantha samantha@gmail.com
// tanya tanya@gmail.com

// Sample Output
// julia
// julia
// riya
// samantha
// tanya

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        String [] names = new String[N];
        int a = 0;
        
        for (int NItr = 0; NItr < N; NItr++) {
            
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                String firstName = firstMultipleInput[0];
                String emailID = firstMultipleInput[1];
                String check[] = emailID.split("@", 2);
                if(check[1].equals("gmail.com")) {
                    names[a] = firstName;
                    a++;
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        };

        bufferedReader.close();
        
        for(int i = 0; i < N-1; ++i) {
            for(int j = i + 1; j < N; ++j) {
                if(names[j] != null) {
                    if(names[i].compareTo(names[j]) > 0) {
                        String temp = names[i];
                        names[i] = names[j];
                        names[j] = temp;
                    }
                }
            }
        }
        for(String s : names) {
            if(s != null) System.out.println(s);
        }
    }
}
