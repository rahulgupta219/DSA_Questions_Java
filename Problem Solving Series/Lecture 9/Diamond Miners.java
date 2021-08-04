Diamond Miner
Problem Description

Diamond Miner is a game that is similar to Gold Miner, but there are n miners instead of 1 in this game.

The mining area can be described as a plane. The n miners can be regarded as n points on the y-axis. There are n diamond mines in the mining area. We can regard them as n points on the x-axis. For some reason, no miners or diamond mines can be at the origin (point (0,0)).

Every miner should mine exactly one diamond mine. Every miner has a hook, which can be used to mine a diamond mine.

If a miner at the point (a,b) uses his hook to mine a diamond mine at the point (c,d), he will spend √(a−c)2+(b−d)2 energy to mine it (the distance between these points). The miners can't move or help each other.
The object of this game is to minimize the sum of the energy that miners spend. Can you find this minimum?



Problem Constraints
1<=n<=1e5
-1e5<=x,y<=1e5


Input Format
First Argument denotes n which if no. miners and mines.
Second Argument contains array of integers of size 2n which denotes X-coordinate of points.
Third Argument contains array of integers of size 2n; which denotes Y-coordinated of points.
NOTE: Any point (x,y) to describe a miner's or a diamond mine's position. Either x=0, meaning there is a miner at the point (0,y), or y=0, meaning there is a diamond mine at the point (x,0). There can be multiple miners or diamond mines at the same point.
It is guaranteed that no point is at the origin. It is guaranteed that the number of points on the x-axis is equal to n and the number of points on the y-axis is equal to n.



Output Format
Return the the integer which is  minimal sum of energy that should be spent.
NOTE: if the minimal sum of energy is 3.54 then you have to return its integer part that is 3 only


Example Input
Input-1
A=2
B=[0,1,0,-2]
C=[1,0,-1,0]
Input-2

A=1
B=[0,1]
C=[1,0]


Example Output
Output-1
3
Output-2

1


Example Explanation
Explanation-1

The miners are at (0,1) and (0,−1), while the diamond mines are at (1,0) and (−2,0). If you arrange the miners to get the diamond mines in the way, shown in the picture, you can get the sum of the energy sqrt(2)+sqrt(5). 

Explanation-2

Only one 1 possiblity is there minimal energy is sqrt(2).

public class Solution {
    public int solve(int A, int[] B, int[] C) {

    //Mod both the arrays

    for(int i=0;i<B.length;i++)
    {
        if(B[i]<0)
            B[i]*=-1;

        if(C[i]<0)
            C[i]*=-1;
    }

    Arrays.sort(B);
    Arrays.sort(C);

    double sum=0.0;

    for(int i=A;i<B.length;i++)
        sum+=Math.sqrt(B[i]*B[i]+C[i]*C[i]);

    return (int)(sum);
    }
}
