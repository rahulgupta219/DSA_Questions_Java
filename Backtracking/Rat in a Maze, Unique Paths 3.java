Unique Paths III
Problem Description

Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2

Input Format
The first argument given is the integer matrix A.

Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]
Example Output
Output 1:

2
Output 2:

0

Example Explanation
Explanation 1:

We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

Answer is evident here.

public class Solution {
    public int max_no_of_ways=0;
    public int[][] arr;
    public void RatMaze(int i,int j, int steps, int sum)
    {
        //Base Case
        int flag=-1;
        if(arr[i][j]==2)
            {
                if(steps==sum)
                    max_no_of_ways++; //When our condition is met
                return;
            }
        else if(arr[i][j]==-1) //Skip when we reach -1
            return;
        else if(arr[i][j]==0) //If 0, then increment steps, set visited to -1, and change flag value to update cell value later
        {steps+=1;
        arr[i][j]=-1;
        flag=1;
        }
        
       else //Starting case of 1
       {
          arr[i][j]=-1;
        flag=2; 
       }
        
        if(i+1 <arr.length)
            RatMaze(i+1,j,steps,sum); //Moving below
        if(i-1 >=0)
            RatMaze(i-1,j,steps,sum); //Moving above
        if(j+1 <arr[0].length)
            RatMaze(i,j+1,steps,sum); //Moving right
        if(j-1 >=0)
            RatMaze(i,j-1,steps,sum); //Moving left
        
    //Backtracking now

       if(flag==1) //Revert back to orignal value
        arr[i][j]=0;
       if(flag==2) //Revert back to orignal value
        arr[i][j]=1;
        
    }

    public int solve(int[][] A) {

    int startx=-1,starty=-1;int max_steps=0;
    arr=new int[A.length][A[0].length];
    for(int i=0;i<A.length;i++)
        for(int j=0;j<A[0].length;j++)
        {
            arr[i][j]=A[i][j];
            if(A[i][j]==1)
            {
                startx=i;   //Storing start position in the matrix
                starty=j;
            }
            if(A[i][j]==0)
            {
                max_steps++;    //Calculating maximum no of steps
            }
        }


        RatMaze(startx,starty,0,max_steps);

    return max_no_of_ways;
    }
}




Another Way to solve:
public class Solution {
    
    public int[][] arr;
    public int RatMaze(int i,int j, int steps, int sum)
    {
        //Base Case

        if(i>=arr.length || i <0 ||j >=arr[0].length ||j <0)
            return 0;

        int flag=-1;
        if(arr[i][j]==2)
            {
                if(steps==sum) //When our condition is met
                return 1;
                else
                return 0;
            }
        else if(arr[i][j]==-1) //Skip when we reach -1
            return 0;
        else if(arr[i][j]==0) //If 0, then increment steps, set visited to -1, and change flag value to update cell value later
        {steps+=1;
        arr[i][j]=-1;
        flag=1;
        }
        
       else //Starting case of 1
       {
          arr[i][j]=-1;
        flag=2; 
       }
        
       
        
        int ans=RatMaze(i+1,j,steps,sum) //Moving below
        + RatMaze(i-1,j,steps,sum) //Moving above
        + RatMaze(i,j+1,steps,sum) //Moving right
        + RatMaze(i,j-1,steps,sum); //Moving left
    
        //Backtracking now
    
        if(flag==1) //Revert back to orignal value
        arr[i][j]=0;
       if(flag==2) //Revert back to orignal value
        arr[i][j]=1;
        
        return ans;
        
    }

    public int solve(int[][] A) {

    int startx=-1,starty=-1;int max_steps=0;
    arr=new int[A.length][A[0].length];
    for(int i=0;i<A.length;i++)
        for(int j=0;j<A[0].length;j++)
        {
            arr[i][j]=A[i][j];
            if(A[i][j]==1)
            {
                startx=i;   //Storing start position in the matrix
                starty=j;
            }
            if(A[i][j]==0)
            {
                max_steps++;    //Calculating maximum no of steps
            }
        }

    return RatMaze(startx,starty,0,max_steps);
    }
}




