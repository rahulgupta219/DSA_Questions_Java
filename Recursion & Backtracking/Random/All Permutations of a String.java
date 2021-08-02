/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	
	public static ArrayList<String> list = new ArrayList<String>();

	public static void Permutation(String A, String str)
	{
	    if(A.equals(""))
	    {
	    	list.add(str);
	    	return;
	    }

	   for(int i=0;i<A.length();i++)
	   	Permutation((A.substring(0,i)+A.substring(i+1,A.length())),str+A.charAt(i));
	    
	}
	
	public static void main (String[] args) {
	
	String s="abcd";
	
	Permutation(s,"");
	
	System.out.println(list);	


	}
}


/*
    Program to print all permutations of a String
    
    public ArrayList<String> list = new ArrayList<String>();
    public void Permutation(String s,String str)
    {
        if(s.equals(""))
	    {
	    	list.add(str);
	    	return;
	    }

	   for(int i=0;i<s.length();i++)
	   	Permutation((s.substring(0,i)+s.substring(i+1,s.length())),str+s.charAt(i));
        
    }
    public ArrayList<String> letterCombinations(String A) {
        
    Permutation(A,"");
    
    System.out.println("No of permutations"+list.size());
    
    return list;    
    }
    */