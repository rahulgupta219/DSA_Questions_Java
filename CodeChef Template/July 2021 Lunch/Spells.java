/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Test Case Input		
		int t=Integer.parseInt(br.readLine());

		while(t>0)
		{

			
			StringTokenizer st = new StringTokenizer(br.readLine());
            
               int  a = Integer.parseInt(st.nextToken());
                int  b=Integer.parseInt(st.nextToken());
            		int c=Integer.parseInt(st.nextToken());
            
            

             
             	 System.out.println(a+b+c-Math.min(a,Math.min(b,c)));
            
			t--;
		}
	    
	}
}
