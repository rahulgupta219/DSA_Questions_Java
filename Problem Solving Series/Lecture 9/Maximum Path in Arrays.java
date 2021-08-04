Problem Description

Given two sorted arrays A and B, such that the arrays may have some common elements.

Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays.

We can switch from one array to another array only at common elements.

NOTE:

The common elements do not have to be at the same indexes.


Problem Constraints
1 <= |A|, |B| <= 105

1 <= A[i], B[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer array B.



Output Format
Return a single integer denoting the maximum sum path.



Example Input
Input 1:

 A = [2, 3, 7, 10, 12]
 B = [1, 5, 7, 8]
Input 2:

 A = [10, 12]
 B = [5, 7, 9]


Example Output
Output 1:

 35
Output 2:

 22


Example Explanation
Explanation 1:

 35 is sum of 1 + 5 + 7 + 10 + 12. We start from the first element of B which is 1, then we move to 5, then 7.
 From 7, we switch to A (as 7 is common) and traverse 10 and 12.
Explanation 2:

 22 is the sum of 10 and 12. Since there is no common element, we need to take all elements from the array with more sum.

My Solution 

TC: O(NA + NB)
SC: O(N)

public class Solution {

 	public int sum(int [] A){
 		int sum=0;

 	for(int i=0;i<A.length;i++)
 		sum+=A[i];

 	return sum;
 	}

    public int solve(int[] A, int[] B) {
    
    HashMap<Integer,Integer> Array1 = new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> Array2 = new HashMap<Integer,Integer>();
    ArrayList<Integer> common = new ArrayList<Integer>();

    int pssumA=0; //prefix sum for array A
    for(int i=0;i<A.length;i++)
    {
    	pssumA+=A[i];
    	if(!Array1.containsKey(A[i]))
    	    Array1.put(A[i],pssumA); //Adding first occurence of PS sum in the hashmap
    	     
       }

    int pssumB=0; //prefix sum for array B
    for(int i=0;i<B.length;i++)
    {
    	pssumB+=B[i];
    	if(!Array2.containsKey(B[i]) && Array1.containsKey(B[i]))//Adding first occurence of common element and PS sum in the hashmap and list
    	    {
    	    	Array2.put(B[i],pssumB);
    	    	
    	    	//Adding only distinct elements in the common list

    	    	if(common.size()==0)
                    common.add(B[i]);
                else if(common.size()>0 && common.get(common.size()-1)!=B[i])
                    common.add(B[i]);

    	    } 
    }
    
    //Remove common elements from First HashMap
    
    for(int i=0;i<A.length;i++)
    {   
        if(!Array2.containsKey(A[i]))
    		Array1.remove(A[i]);    
    }
    
    if(common.size()==0)
    	return Math.max(sum(A),sum(B));

    
    int element=common.get(0),prev=0;
   	int sum=Math.max(Array1.get(element),Array2.get(element)); //First common element

   	for(int i=1;i<common.size();i++)
   	{	
   		element=common.get(i);
   		prev=common.get(i-1);
   		sum+=Math.max((Array1.get(element)-Array1.get(prev)),(Array2.get(element)-Array2.get(prev))); //Add maximum of the common element
	}
	element=common.get(common.size()-1);//Find the last common element

	return sum + Math.max(pssumA-Array1.get(element),pssumB-Array2.get(element)); //Add the remaining sum after removing the sum of common element
    }
}
 