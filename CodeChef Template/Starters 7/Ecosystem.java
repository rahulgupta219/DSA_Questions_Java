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

			
            
            //First Line of Input for test case
			StringTokenizer st = new StringTokenizer(br.readLine());
            
                int e = Integer.parseInt(st.nextToken());
                int k=Integer.parseInt(st.nextToken());
            
            int counter=0;


            while(e>0)
            {
            	e=(int)Math.floor(e/k);
            	counter++;

            }
    				System.out.println(counter);
    				
            
			t--;
		}
	    
	}
}
