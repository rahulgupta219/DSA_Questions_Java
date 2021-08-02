Majority Element
Problem Description

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
    
    int element=Integer.MIN_VALUE, freq=0;  
        
    for(int i=0;i<A.length-1;i=i+2)
    {
        if(A[i]==A[i+1])
        {
            if(freq<=2)
            {element=A[i];freq=2-freq;}
            else if(element == A[i])
            {
                freq+=2;
            }
            else if(element != A[i])
            {
                freq-=2;
            }
            
        }
    }
    int main_freq=0;
    for(int i=0;i<A.length;i++)
    {   
        if(A[i]==element)
            main_freq++;    
        
        if(main_freq> Math.floor(A.length/2))
            return element;
    }
    
    return A[A.length-1];    
    }
}
