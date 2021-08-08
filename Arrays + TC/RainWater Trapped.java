Rain Water Trapped
Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.

TC: O(N), SC: O(N)

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        
    int maxleft[]=new int[A.length];
    int maxright[]=new int[A.length];  


    int max=Integer.MIN_VALUE;

    //Maxleft
    for(int i=0;i<A.length;i++)      
    {
        //Calculating the maximum value on the left for each index and storing in an array
        if(max<A[i])
            max=A[i];

        maxleft[i]=max;

    }   

    max=Integer.MIN_VALUE;
    int water=0;
    for(int i=A.length-1;i>=0;i--)      
    {
        //Calculating the maximum value on the right for each index and storing in an array
        if(max<A[i])
            max=A[i];

        maxright[i]=max;

        //Formula for calculating the water stored, important to subract A[i]
      water+=Math.min(maxright[i],maxleft[i])-A[i];  
    }    
    
    return water;
    }
}

TC: O(N), SC: O(1)

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        
    int maxleft=A[0];
    int maxright=A[A.length-1];  

    //Maxleft
    int maxi=0;

    for(int i=0;i<A.length;i++)      //Calculating the maximum element index in the array 
        maxi=A[i]>A[maxi]?i:maxi;

    int water=0;

    //All elements to the left of maximum element, will have max element as its max right

    for(int i=1;i<maxi;i++)
    {   
        maxleft = Math.max(maxleft,A[i]);
        water+=Math.min(A[maxi],maxleft)-A[i];  
    }   

     //All elements to the right of maximum element, will have max element as its max left
    for(int i=A.length-1;i>=maxi;i--)      
    {
        maxright = Math.max(maxright,A[i]);
        water+=Math.min(A[maxi],maxright)-A[i]; 

    }    
    
    return water;
    }
}
