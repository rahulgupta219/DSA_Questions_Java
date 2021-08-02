Number of Squareful Arrays
Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

Problem Constraints
1 <= length of the array <= 12

1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of permutations of A that are squareful.

Example Input
Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output
Output 1:

 1
Output 2:

 2

Example Explanation
Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1].


 public class Solution {
    
    public ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    public ArrayList<Integer> Arr = new ArrayList<Integer>();
    
    public void Permutation(ArrayList<Integer> temp,HashSet<Integer> index, int ptr)
    {
         if(temp.size()==Arr.size())
        {
            if(!list.contains(temp))
            list.add(new ArrayList<Integer>(temp));
            
            return;
        }
        
//System.out.println(temp);
        for(int i=0;i<Arr.size();i++)
        {   
            
            if(index.contains(i))
                continue;
            
            temp.add(Arr.get(i));
            index.add(i);
            
            if(checkSquareful(temp))
                Permutation(temp,index,i);
            
            temp.remove(temp.size()-1);
            index.remove(i);
            
        }
        
    }
    
    public boolean checkPerfectSquare(long no)
    {
        long ans=(long)Math.sqrt(no);
        
        if(ans*ans==no)
            return true;
       
      return false;
      }

    public boolean checkSquareful(ArrayList<Integer> temp)
    {
        int flag=1;
        for(int j=0;j<temp.size()-1;j++)
        {
            if(!checkPerfectSquare((long)temp.get(j) + (long)temp.get(j+1)))
              {flag=-1;break;} 
        }

        if(flag==-1)
            return false;

      return true;
      }
    
    public int solve(int[] A) {
        
        if(A.length==1)
            return 0;
    
    for(int i=0;i<A.length;i++)
        Arr.add(A[i]);

        ArrayList<Integer> temp = new ArrayList<Integer>();
        HashSet<Integer> index = new HashSet<Integer>();
        
        Permutation(temp,index,0);
        
    //System.out.println(list.size());
    
    return counter;    
    }
}
