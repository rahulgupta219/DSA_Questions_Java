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
            
            int[] A = new int[3];
            int[] B = new int[3];
            
            int awins=0,bwins=0;

            //First Line of Input for test case
			StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i <3; i++) 
                A[i] = Integer.parseInt(st.nextToken());
            
            //Second line of input for test case
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i <3; i++) 
                B[i] = Integer.parseInt(st.nextToken());
            
            for(int i=0;i<A.length;i++)
            {
            	if(A[i]>B[i])
            		awins++;
            	else
            		bwins++;
            }

            String winner = (awins>bwins?"A":"B");
            System.out.println(winner);
            
			t--;
		}
	    
	}
}
