Little Girl and Maximum Sum
Problem Description

The little girl loves the problems on array queries very much.

One day she came across a rather well-known problem: you've got an array of n elements (the elements of the array are indexed starting from 1); also, there are q queries, each one is defined by a pair of integers li, ri (1 < =li<=ri<=n).
You need to find for each query the sum of elements of the array with indexes from li to ri, inclusive.

The little girl found the problem rather boring. She decided to reorder the array elements before replying to the queries in a way that makes the sum of query replies maximum possible. Your task is to find the value of this maximum sum% 10 9 + 7



Problem Constraints
1<=n,q,A[i]<=1e5


Input Format
First Argument contains array of integers of size n denoting array A.
Second Argument contains 2d array B of size q in which B[i][0] =l and B[i][1]=r


Output Format
Return the value of this maximum sum% 10 9 + 7



Example Input
Input-1
A=[5,3,2]
B=[[1,2],[2,3],[1,3]];
Input-2

A=[1]
B=[[1,1]];


Example Output
OUTPUT-1
25
OUTPUT-2

1


Example Explanation
Explanation-1
convert given array into A=[3,5,2] to gain maxium sum.
Explanation-2

Do not change the array 

//Using Custom Comparator
public class Solution {
    
    public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
            new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() 
        {
        
            public int compare(Map.Entry<Integer, Integer> o1,
                            Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    
    public int solve(int[] A, int[][] B) {
    
    int index[]=new int[A.length];

    HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();

    for(int i=0;i<B.length;i++)
    {
        index[B[i][0]-1]+=1;

        if(B[i][1]<=A.length-1)
            index[B[i][1]]+=-1;
    }   

    mapping.put(0,index[0]);//System.out.print(index[0]+" ");

    for(int i=1;i<A.length;i++)
    {
        index[i]+=index[i-1];
        mapping.put(i,index[i]);
        //System.out.print(index[i]+" ");

    }

    Arrays.sort(A);

    Map<Integer, Integer> mapping_sorted = sortByValue(mapping);

    long sum=0,mod=(long)(1e9+7);
    int i=0;

    for (Map.Entry<Integer, Integer> en : mapping_sorted.entrySet()) {
          { 

            sum=(long)(( sum+ (long)(en.getValue()*A[i++]))%mod);
            
          }
    
     
    }
    return (int)((sum+mod)%mod);
}

}


Solution without this complexity

public class Solution {
    
    public int solve(int[] A, int[][] B) {
    
    int index[]=new int[A.length];

    for(int i=0;i<B.length;i++)
    {
        index[B[i][0]-1]+=1;

        if(B[i][1]<=A.length-1)
            index[B[i][1]]+=-1;
    }   

    for(int i=1;i<A.length;i++)
        index[i]+=index[i-1];
        
    Arrays.sort(A);
    Arrays.sort(index);

    long sum=0,mod=(long)(1e9+7);

    for(int i=0;i<A.length;i++)
        sum=(long)(( sum+ (long)(index[i]*A[i]))%mod);

    return (int)((sum+mod)%mod);
}

}