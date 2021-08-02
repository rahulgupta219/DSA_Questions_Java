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
            
            int  n = Integer.parseInt(st.nextToken());
            int  d=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            
             //Second line of input for test case
            st = new StringTokenizer(br.readLine());

            int[] A = new int[n];
            
            for (int i = 0; i <n; i++) 
          	  A[i] = Integer.parseInt(st.nextToken());
            int flag=-1,rain=0;
            for (int i = 0; i <n; i++){

            	if(A[i]>0)
            		rain+=A[i];
            	else
            	{
            		if(rain>D)
            			rain-=D;
            		else
            			rain=0;
            	}


            	if(rain>H)
            		{
            			flag=1;
            		break;}



            }
            
            if(flag==1)
            	System.out.println("YES");
            else
            	System.out.println("NO");

            
			t--;
		}
	    
	}
}
