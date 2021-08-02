Gray Code
Problem Description

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.



Problem Constraints
1 <= A <= 16



Input Format
First argument is an integer A.



Output Format
Return an array of integers representing the gray code sequence.



Example Input
Input 1:

A = 2
Input 1:

A = 1


Example Output
output 1:

[0, 1, 3, 2]
output 2:

[0, 1]


Example Explanation
Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].

public class Solution {
    
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public HashSet<Integer> codes = new HashSet<Integer>();
    public int limit;
    public int index=-1;
    public StringBuilder s = new StringBuilder();

    public void findCode(){
    //Base Case

        if(list.size()==limit)
            return;
    //Logic        

        for(int i=s.length()-1;i>=0;i--)
        {
            StringBuilder temp = new StringBuilder(s);
            
            if(i==index)
                continue; //Index I was altered in the given string builder s from recursion

            if(s.charAt(i)=='0')
                s.setCharAt(i,'1'); //Changing 0 to 1
            else
                s.setCharAt(i,'0');//Changing 1 to 0
            
            int number=Integer.parseInt(s.toString(),2); //Convert stringbuilder to number for storing
            
            if(!codes.contains(number)) //If new string is not present in hashset
            {
                list.add(number); //Adding number to arraylist
                codes.add(number);//Addng number to hashset
                index=i;            //Changing the global index i
                findCode();     //Recursive call
            }
            
            s=temp; //Setting temp to orignal public string after each change at index
            //This is backtracking
        }
    }
    public ArrayList<Integer> grayCode(int a) {
    
        //Setting the limit of hashset and arraylist
        limit = (int)(Math.pow(2,a));
        //Form a StringBuilder of a length having a zeroes
        for(int i=0;i<a;i++)
            s.append("0");

        //Add initial string of zeroes to list and hashset
        list.add(0);
        codes.add(0);
        //Calling the recursive code
        findCode();
    
    //System.out.println(list);
    
    return list;    
    }
}
