public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
    
    int la=0;
    int lb=B.length-1,amin=0,bmin=B.length-1;
        
    int sum=0,diff=0,min_diff=Integer.MAX_VALUE;    
        
    //while(la!=A.length && lb!=-1 && la!=-1 && lb!=B.length)
    while(la<A.length && lb>=0)
    {
        sum=A[la]+B[lb];
        diff=Math.abs(C-sum);
        //System.out.print(diff+" . ");
        if(diff==min_diff)
        {
            if(amin>=la && bmin>=lb)
                {
                    //amin=la;
                    bmin=lb;
                }
        }
        else if(diff<min_diff)
        {
            min_diff=diff;
            amin=la;
            bmin=lb;
        //System.out.println(A[la]+" . "+B[lb]);    
        }
        
        if(sum>=C)
            lb--;
        else if(sum<C)
            la++;
    }
    
    int res[]=new int[2];
    res[0]=A[amin];
    res[1]=B[bmin];
        
    return res;    
    }
}
