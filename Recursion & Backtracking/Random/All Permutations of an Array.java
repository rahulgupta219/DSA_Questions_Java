/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	
public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

public static int A[]=new int[4];

public static void Permutation(ArrayList<Integer> temp,HashSet<Integer> index, int ptr)
	{    
	     if(temp.size()==A.length)
	    {
	        if(!list.contains(temp))
	    	list.add(new ArrayList<Integer>(temp));
	    	
	    	return;
	    }
	    
	    for(int i=0;i<A.length;i++)
	    {	
	        
	        if(index.contains(i))
	            continue;
	        
	        temp.add(A[i]);
	        index.add(i);
	        
	        Permutation(temp,index,i);
	        
	        temp.remove(temp.size()-1);
	        index.remove(i);
	        
	    }
	    
	}
	
	public static void main (String[] args) {
	
	int arr[]={2,2,2,3};

	//A[] = new int[arr.length];
	
	for(int i=0;i<arr.length;i++)
		A[i]=arr[i];

	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    HashSet<Integer> index = new HashSet<Integer>();
	    
	    Permutation(temp,index,0);
	
	for(int i=0;i<list.size();i++)
	System.out.println(list.get(i));	


	}
}
