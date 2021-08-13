Count Total Set Bits
Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints
1 <= A <= 109



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.



Example Input
Input 1:

 A = 3
Input 2:

 A = 1


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1

public class Solution {
    
    long mod = (long)(1e9+7);

    public long countSetBits(int A) {
        
        if(A==1)
          return 1;
        if(A==0)
          return 0;  
          

      int x=1;
      long sum=1;

      while(Math.pow(2,x+1)<=A)
        sum=(long)(((long)Math.pow(2,x++)+2*sum)%mod); //Calculating  values till multiple of 2

      return (long)((sum + (A-(int)Math.pow(2,x)+1) + countSetBits(A-(int)Math.pow(2,x)))%mod);
      //Calculating values after removing the above sum and recursive approach to solve this
    }
    public int solve(int A) {
        

    long sum=countSetBits(A);

    return (int)((sum+mod)%mod);
    }
}



TC Exceeded
 public class Solution {
    public int solve(int A) {
        

      int x=1;
      long mod = (long)(1e9+7),sum=1;

      while(Math.pow(2,x+1)<=A)
        sum=(long)(((long)Math.pow(2,x++)+2*sum)%mod);
    
    int limit=(int)Math.pow(2,x),count=0;
    
    for(int i=0;i<32;i++)
    {
        count=0;
        for(int j=limit;j<=A;j++)
        {
          if((j&(1<<i)) >0)
            count++;
        }

       sum=(long)((sum+count)%mod); 
    }
    
    return (int)((sum+mod)%mod);
    }
}

 public class Solution {
    
    long mod = (long)(1e9+7);

    public long countSetBits(int A) {
        
        if(A==1)
          return 1;

      int x=1;
      long sum=1;

      while(Math.pow(2,x+1)<=A)
        sum=(long)(((long)Math.pow(2,x++)+2*sum)%mod);


      return (long)((sum + A-(int)Math.pow(2,x) + countSetBits(A-(int)Math.pow(2,x)))%mod);
    }
    public int solve(int A) {
        

    long sum=countSetBits(A);

    return (int)((sum+mod)%mod);
    }
}


