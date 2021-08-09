Xor queries
Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints
1<=N,Q<=100000
1<=L<=R<=N


Input Format
First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format
Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input
A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output
[[0 3]
[0 3]
[1 2]]


Example Explanation
In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.


public class Solution {
    public int[][] solve(int[] A, int[][] B) {
        
        int ones[]=new int[A.length+1]; //For storing prefix sum of 1's in the array
        int result[][]=new int[B.length][2];
        ones[0]=0;
        
        if(A[0]==1)
            ones[1]=1;
        
         int l=0,r=0;   
        //Calculating offset bits array    
            
        for(int i=2;i<A.length+1;i++)
            ones[i]=A[i-1] + ones[i-1];
    
    for(int i=0;i<B.length;i++)
    {
       l=B[i][0];r=B[i][1]; 
    //XOR
    
    if((ones[r]-ones[l-1])%2!=0) //If no of 1's are odd, XOR will be 1, else 0
        result[i][0]=1;

    //Unset Bits
    result[i][1]=(r-l+1)-(ones[r]-ones[l-1]); //No of 0's will be total length of segment - no of 1's present in the segment
        
    }
       
    return result;    
    }
}
