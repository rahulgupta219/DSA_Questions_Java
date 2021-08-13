Reverse Bits
Problem Description

Reverse the bits of an 32 bit unsigned integer A.

Problem Constraints
0 <= A <= 232

Input Format
First and only argument of input contains an integer A.

Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Example Input
Input 1:

 0
Input 2:

 3
Example Output
Output 1:

 0
Output 2:

 3221225472

Example Explanation
Explanation 1:

        00000000000000000000000000000000    
=>      00000000000000000000000000000000
Explanation 2:

        00000000000000000000000000000011    
=>      11000000000000000000000000000000

public class Solution {
        public long reverse(long a) {

    //Forming the number from the end, getting the last digit and adding it to the number

    long number=0;
    long d=0;
    for(int i=0;i<32;i++)
    {   
        number<<=1; //Right shift number by 1, now in that position, it can be either a 0 or 1. everything depends on the ith bit
        //Getting the ith bit by doing an and operation 
        d=a&(1<<i);
        if(d!=0)//If the ith digit we got is not 0, means that for ith position, bit is set. We add 1 to the bit that we just added earlier.
            number|=1;
    }
    
    return number;
        }
}


public class Solution {
    public long reverse(long a) {

    long x=0, no=0;
    for(int i=31;i>=0;i--)
        {
            x=(a & 1); //Check the ith Bit from the end for either 0 or 1
             //If bit is 1, then do or operation with 1 left shifted by ith value
            no = (no | (x<<i));
            a=a>>1; //Right shift element a to continue further in operation
            if(a==0)
                break;
        }

    return no;
    }
}

