Single Number III
Problem Description

Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
First argument is an array of interger of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once.

 public class Solution {
    public int[] solve(int[] A) {
        
        int arr[] = new int[2];
        
        int xorval=0;
        
        for(int i=0;i<A.length;i++)
            xorval = xorval^A[i]; //Take the XOR for all elements
        
        int c=0,d=0;
        int index=0;
        
        while(xorval>0)
        {
            if((xorval & (1<<index))>0)
                break;
            index++; //Calculate the index for the first set bit
        }
        
        for(int i=0;i<A.length;i++)
        {
            if((A[i] & (1<<index))>0) //For each bit at that index, check if element contributes a set bit or not
                c=c^A[i]; //Xoring the elements which contribute a set bit at index
            else
                d=d^A[i]; //Xoring the elements which contribute a 0 bit at index
        }
        arr[0]=c<d?c:d;
        arr[1]=c+d-arr[0];
       
    return arr;   
    }
}


public class Solution {
    public int[] solve(int[] A) {
        
        int arr[] = new int[2];
        
        int xorval=0;
        
        for(int i=0;i<A.length;i++)
            xorval = xorval^A[i]; //Take the XOR for all elements
        
        int c=0,d=0;
        int mask=0;
        
        mask = (xorval&(xorval-1))^xorval;
        
        for(int i=0;i<A.length;i++)
        {
            if((A[i] & mask)>0) //For each bit at that index, check if element contributes a set bit or not
                c=c^A[i]; //Xoring the elements which contribute a set bit at index
            else
                d=d^A[i]; //Xoring the elements which contribute a 0 bit at index
        }
        arr[0]=c<d?c:d;
        arr[1]=c+d-arr[0];
       
    return arr;   
    }
}