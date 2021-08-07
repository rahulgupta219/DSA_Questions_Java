Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9

Input Format
The first argument given is the integer array A.

The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

 
A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1

Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.

//Brute Force O(N2)

 public class Solution {
    public int solve(int[] A, int B) {


        long count=0,mod=(long)(1e9+7);


        for(int i=0;i<A.length-1;i++)
            for(int j=i+1;j<A.length;j++)
            {
                if(A[i]+A[j]==B)
                    count=(long)((count+1)%mod);
                if(A[i]+A[j]>B)
                    break;
            }
        
    return (int)((count+mod)%mod);
    }
}

public class Solution {
    public int solve(int[] A, int B) {

        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();

        for(int i=0;i<A.length;i++)
        {

            if(freq.containsKey(A[i]))
                freq.put(A[i],freq.get(A[i])+1);
            else
                freq.put(A[i],1);
        }

        //If we want to remove frequency map,  we can check each time we get an answer == B, count the no of duplicate values for start and end.
        //That will help us avoid using O(n) space
        int start=0,end=A.length-1;

        long count=0,mod=(long)(1e9+7),sum=0;

        while(start<end)
        {
            sum=A[start]+A[end];

            if(sum<B)
                start+=freq.get(A[start]);
            else if(sum>B)
                end-=freq.get(A[end]);
            else
            {

                if(A[start]==A[end])
                {
                    count=(long)((count+((long)freq.get(A[start])*(freq.get(A[end])-1))/2)%mod);
                    break;
                }
                else
                {
                    count=(long)((count+freq.get(A[start])*freq.get(A[end]))%mod);
                    start+=freq.get(A[start]);
                    end-=freq.get(A[end]);
                }
            }

        }

    return (int)((count+mod)%mod);        
    }
}
