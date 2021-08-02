public class Solution {
    
    public boolean checkCows(int[] A, int n, int cows)
    {
        long dist=A[0]+n;
        
        if(A[A.length-1]<n)
            return false;
        
        for(int i=1;i<A.length;i++)
        {
            if(A[i]>=dist)
                {
                    dist=n+A[i];
                    cows--;
                }
         if(cows==0)
            return true;       
        }

        return false;
    }

    public int solve(int[] A, int B) {
    
    Arrays.sort(A);
    
    if(B==2)
        return A[A.length-1]-A[0];
    
    int l=0,r=A[A.length-1],mid=0,res=0;
    
        while(l<=r)
        {
            //mid=(int)Math.floor((l+r)/2);
                mid=(l+r)>>1;
        //System.out.print(mid+"->"+checkCows(A,mid,B-1)+" ");
            if(checkCows(A,mid,B-1))
                {l=mid+1;res=mid;}
            else
            {
                r=mid-1;
            }
        }
     return res; 
    }
}
