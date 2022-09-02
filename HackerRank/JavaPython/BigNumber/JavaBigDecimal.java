// Sample Input
// 9
// -100
// 50
// 0
// 56.6
// 90
// 0.12
// .12
// 02.34
// 000.000

// Sample Output
// 90
// 56.6
// 50
// 02.34
// 0.12
// .12
// 0
// 000.000
// -100

import java.math.BigDecimal;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        // We want to sort in descending order while preserving the contents 
        // of each String. A comparator can achieve this for us. We convert  
        // to BigDecimal inside our comparator so that the change is not 
        // permanent and our String's form for each number is preserved. 
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                BigDecimal a = new BigDecimal(s1);
                BigDecimal b = new BigDecimal(s2);
                //descending order
                return b.compareTo(a);
            }
        };
        
        Arrays.sort(s, 0, n, comp);
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}