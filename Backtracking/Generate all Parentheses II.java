Generate all Parentheses II
Problem Description

Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.

Problem Constraints
1 <= A <= 20

Input Format
First and only argument is integer A.

Output Format
Return a sorted list of all possible paranthesis.

Example Input
Input 1:

A = 3
Input 2:

A = 1
Example Output
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]

Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.


public class Solution {
    ArrayList<String> list = new ArrayList<String>();

    public void makeParentheses(int no_open, int no_closed, String str)
    {

        //Base Case

        if(no_closed==0 || no_open==0)
            {
                while(no_closed-->0)
                str+=')';

                list.add(str);
                return;
            }

        //Recurrenece Relation
        if(no_closed>no_open)
        {
            makeParentheses(no_open-1, no_closed,str+'('); //Put a opening bracket
            makeParentheses(no_open, no_closed-1,str+')');//Put a closing bracket
        }
        else if(no_closed<=no_open)
             makeParentheses(no_open-1, no_closed,str+'('); //Put a opening bracket

    }

    public ArrayList<String> generateParenthesis(int A) {

        makeParentheses(A,A,"");

    return list;
    }
}

Second Solution:
public class Solution {
    
    ArrayList<String> list = new ArrayList<String>();
    public void makeParentheses(int no_open, int no_closed, String str)
    {
        //Base Case
        if(no_closed==0 && no_open==0)
            {
                list.add(str);
                return;
            }
        //Recurrenece Relation
        if(no_open>=0)
             makeParentheses(no_open-1, no_closed,str+'('); //Put a opening bracket
             
        if(no_closed>no_open)
        {
            makeParentheses(no_open, no_closed-1,str+')');//Put a closing bracket
        }
    }

    public ArrayList<String> generateParenthesis(int A) {

        makeParentheses(A,A,"");
    return list;
    }
}
