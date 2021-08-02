Circle of Monsters
Problem Description

You are playing another computer game, and now you have to slay n monsters. These monsters are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th monster has ai health.

You may shoot the monsters to kill them. Each shot requires exactly one bullet and decreases the health of the targeted monster by 1 (deals 1 damage to it). Furthermore, when the health of some monster i becomes 0 or less than 0, it dies and explodes, dealing bi damage to the next monster (monster i+1, if i < n, or monster 1, if i=n). If the next monster is already dead, then nothing happens. If the explosion kills the next monster, it explodes too, damaging the monster after it and possibly triggering another explosion, and so on.

You have to calculate the minimum number of bullets mod 10 9 + 7 you have to fire to kill all n monsters in the circle.

NOTE: If the minimum no. of bullets are x then you have to return x % 1e9 + 7 .



Problem Constraints
2<= n <=300000
1<= A[i], B[i]<= 1e9


Input Format
First Argument is array of integers of N size denoting array A Second Argument is array of integers of N size denoting array B


Output Format
Return the miniumum number of bullets mod 10 9 + 7 you have to fire to kill all of the monsters.


Example Input
Input- 1
A=[7,2,5]
B=[15,14,3]
Input- 2

A=[1 2]
B=[2 1]


Example Output
Output- 1
6
Output- 2

1


Example Explanation
Explanation-1
Firstly we shoot 2nd monster whose health is 2 with 2 bullets and then this monster will create damage of 14 to another monster.
Now 3rd monster health will decrease by 14 units . hence 3rd monster also died . hence it will create damage of 3 units to 1st monster
Now 1st monster health is 7-3=4 . and now 4 more bullets are required to kill 1st monster.
Total bullets required to kill all the monsters = 2+4= 6
Explanation-2

Kill 1st monster with 1 bullet so it will cause 2 units of damage to 2nd monster.
Hence 2nd monster automatically died.
Total bullets required=1


public class Solution {
    public HashSet<Integer> monsters = new HashSet<Integer>();
    public int findMin(int [] A){

        int min_index=-1,min=Integer.MAX_VALUE;

        for(int i=0;i<A.length;i++)
        {
            if(!monsters.contains(i))
            {
                if(min>A[i])
                {
                    min=A[i];
                    min_index=i;
                }
            }
        }
    return min_index;
    }


    public int solve(int[] A, int[] B) {

        int min_index=-1,i=0,damage=0;
        long bullets=0,mod=(long)(1e9+7);


        while(monsters.size()<A.length){

            min_index=findMin(A);
            System.out.println(min_index);
            bullets=(long)(bullets + A[min_index])%mod;
            damage=B[min_index];
            
            monsters.add(min_index);

            //Inflict Damage on the next monsters

            //blast_damage=(int)(i+1)%A.length;

            
            min_index=(int)(min_index+1)%A.length;
            
                while(damage>A[min_index] && !monsters.contains(min_index))
                {
                    monsters.add(min_index);
                    damage=B[min_index];
                    min_index=(int)(min_index+1)%A.length;
                }

                A[min_index]-=damage;
        }


    return (int)(bullets%mod);
    }
}

O(N) Space Complexity

public class Solution {

    public int solve(int[] A, int[] B) {

        
        long bullets=0,mod=(long)(1e9+7),sum=0;

        int C[]= new int[A.length];

        C[0]=Math.max(0,A[0]-B[A.length-1]);
        sum+=C[0];
        int min=A[0]-C[0];

        for(int i=1;i<A.length;i++){
            C[i]=Math.max(0,A[i]-B[i-1]);
            sum=(long)(sum+C[i])%mod;
            if(min>(A[i]-C[i]))
                min=A[i]-C[i];

        }

    return (int)((long)(sum+min)%mod);
    }
}

O(N) TC, O(1) Space Complexity - Final Solution
public class Solution {

    public int solve(int[] A, int[] B) {

        
        long mod=(long)(1e9+7),sum=0;

        //int C[]= new int[A.length];

        
        sum+=Math.max(0,A[0]-B[A.length-1]);;
        int min=A[0]-Math.max(0,A[0]-B[A.length-1]);;

        for(int i=1;i<A.length;i++){
            sum=(long)(sum+Math.max(0,A[i]-B[i-1]))%mod;
            if(min>(A[i]-Math.max(0,A[i]-B[i-1])))
                min=A[i]-Math.max(0,A[i]-B[i-1]);

        }

    return (int)((long)(sum+min)%mod);
    }
}


