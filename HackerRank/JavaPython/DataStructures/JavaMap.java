// Sample Input
// 3
// uncle sam
// 99912222
// tom
// 11122222
// harry
// 12299933
// uncle sam
// uncle tom
// harry

// Sample Output
// uncle sam=99912222
// Not found
// harry=12299933


public class JavaMap {
  public static void main(String []argh)  throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
         HashMap<String, Integer> map = new HashMap<>();
		while(n-- > 0) {
            String name = br.readLine();
            int phone = Integer.parseInt(br.readLine());
            map.put(name, phone);
        }
        //Query
        String s;
		while((s = br.readLine()) != null)
		{
			if(map.containsKey(s)) System.out.println(s + "=" + map.get(s));
            else System.out.println("Not found");
		}
        br.close();
	}
}
