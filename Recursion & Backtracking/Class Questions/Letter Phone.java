Letter Phone
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.

Problem Constraints
1 <= |A| <= 10

Input Format
The only argument is a digit string A.

Output Format
Return a string array denoting the possible letter combinations.

Example Input
Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output
Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation
Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations.


 public class Solution {
    public String phone[]={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public ArrayList<String> list = new ArrayList<String>();
    public String A_temp="";

    public void letterPhone(int ptr,String str)
    {
        if(ptr==A_temp.length()) //When we are passing at the final part
        {
            list.add(str);
            return;
        }

        int no=A_temp.charAt(ptr)-48; //Calculating the no at the position
        String combination=phone[no]; //Finding the combination from the no

        for(int i=0;i<combination.length();i++)
            letterPhone(ptr+1,str+combination.charAt(i));//Recursive call to the next element and adding the character each time for the recursion call
    }

    public ArrayList<String> letterCombinations(String A) {

    A_temp=A;
    
    letterPhone(0,"");    

    return list;
    }
}
