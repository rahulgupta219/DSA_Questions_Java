Non decreasing subarray queries
Problem Description

Given an array A of size N. You will be given M queries to process. Each query will be of the form B[i][0] B[i][1].

If the subarray from B[i][0] to B[i][1] is non decreasing, the output should be 1 else output should be 0.

Return an array of integers answering each query.


Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109

1 <= M <= 105

1 <= B[i][0], B[i][1] <= N


Input Format
First argument contains the array A.

Second argument contains B, denoting the queries.


Output Format
Return an array of integers consisting of 0 and 1


Example Input
Input :
A = [1, 7, 3, 4, 9]
B = [ 
      [1, 2], 
      [2, 4]
    ]


Example Output
Input :
[1, 0]


Example Explanation
Explanation :
Query 1: The subarray in the range [1, 2] is {1, 7} which is non-decreasing. Therefore, ans = 1
Query 2: The subarray in the range [2, 4] is {7, 3, 4, 9} which is not non-decreasing. Therefore, ans = 0

public class Solution {
    public int[] solve(int[] A, int[][] B) {
    
    //Brute Force Approach TC: O(N*M), SC O(1)

      int res[]=new int[B.length];
      int flag=1,x=0,y=0;

      for(int i=0;i<B.length;i++)
      {     
            x=B[i][0];
            y=B[i][1];

            flag=1;

            for(int j=x-1;j<y-1;j++)
            {
                  if(A[j]>A[j+1])
                  {
                        flag=-1;
                        break;
                  }
            
            }

            if(flag==-1)
                  res[i]=0;
            else
                  res[i]=1;
      }
      
      return res;
    }
}

public class Solution {
    public int[] solve(int[] A, int[][] B) {
    
    //Optimized Approach TC: O(M), SC O(N)


      int prefix[]=new int[A.length];
      int res[]=new int[B.length];
      int difference=0,x=0,y=0;

      prefix[0]=0;

      for(int i=0;i<A.length-1;i++)
      {
            if(A[i]>A[i+1])
                  prefix[i+1]=1+ prefix[i]; // Increasing prefix sum by 1 in case of irregularity
            else
                prefix[i+1]=prefix[i]; // No irregularity
      }

      for(int i=0;i<B.length;i++)
      {     
            x=B[i][0]-1;
            y=B[i][1]-1;

            difference = prefix[y]-prefix[x];

            if(difference==0)
                  res[i]=1;
            else
                  res[i]=0;
      }
      
      return res;
    }
}

