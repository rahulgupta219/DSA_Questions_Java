/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	
	public static void subsets(String s,String subset, int ptr)
	{
	    //Base case:
	    if(ptr==s.length())
	        {System.out.println(subset);
	        return;}
	        
	   subsets(s,subset,ptr+1);
	   subsets(s,subset+s.charAt(ptr),ptr+1);
	   
	    
	}
	
	public static void main (String[] args) {
	
	String s="123";
	subsets(s,"",0);
	
		
	}
}