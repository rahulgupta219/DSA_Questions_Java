NQueens
Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10

Input Format
First argument is an integer n denoting the size of chessboard

Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Example Input
Input 1:

A = 4
Input 2:

A = 1

Example Output
Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation
Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:

public class Solution {
        
    public HashSet<Integer> Column = new HashSet<Integer>();    
    public HashSet<Integer> IMinusJ = new HashSet<Integer>();
    public HashSet<Integer> IPlusJ = new HashSet<Integer>();
    public ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();    
    public int arr[][];
    public int N;
    
    public void addArray(){

        ArrayList<String> list = new ArrayList<String>();
        String s="";
        for(int i=0;i<N;i++)
        {   
            s=""; 
            for(int j=0;j<N;j++)
            {
                if(arr[i][j]==0)
                    s+='.'; //When blank
                else
                    s+='Q'; //When queen is at a position
            }
            list.add(s);
        }

        solution.add(list);
    }

    public boolean checkPossibility(int i, int j){

        //Check for Column entry
        if(Column.contains(j))
            return false; //Present in Column
        if(IMinusJ.contains(i-j))
            return false;//Present in diagonal
        if(IPlusJ.contains(i+j))
            return false; //Present in diagonal

        return true;
    }

    public void NQueen(int row){
        //Base Case
        if(row==N)
            {
                addArray(); //Store result in string
                return;
            }

        //Logic
        for(int col=0;col<N;col++)
        {
            if(checkPossibility(row,col))
            {
                //Add elements in hashset
                Column.add(col);
                IPlusJ.add(row+col);
                IMinusJ.add(row-col);

                //Recursion for placing another queen now
                arr[row][col]=1;
                NQueen(row+1);

                //Remove elements from hashset and do backtracking by setting value to 0
                arr[row][col]=0;
                Column.remove(col);
                IPlusJ.remove(row+col);
                IMinusJ.remove(row-col);
            }
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
    
    arr=new int[A][A];
    N=A;

    NQueen(0);

    return solution;
    }
}
