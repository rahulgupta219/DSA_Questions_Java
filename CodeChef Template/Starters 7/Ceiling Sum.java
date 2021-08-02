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

			//int ra=Integer.parseInt(br.readLine());
			
			//String a=br.readLine();
			//String b=br.readLine();
            
            //int[] A = new int[3];
            //int[] B = new int[3];
            
            //First Line of Input for test case
			StringTokenizer st = new StringTokenizer(br.readLine());
            
                a = Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
            
            //Second line of input for test case
            //st = new StringTokenizer(br.readLine());
            
            //for (int i = 0; i <3; i++) 
              //  B[i] = Integer.parseInt(st.nextToken());
            
            //System.out.println(A[0]);
                int x=a+b;
                if(x<3)
	           		System.out.println(1);
	           	else if(x>=3 && x<=10)
	           			System.out.println(2);
	           else if(x>=11 && x<=60)
	           	System.out.println(3);
				else if(x>60)
    				System.out.println(4);
            
			t--;
		}
	    
	}
}
