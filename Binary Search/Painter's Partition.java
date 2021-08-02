public class Solution {

    public boolean checkPartition(int[] C, long n, int A, int B)
    {
        int painters=1;
        long time=0;

        for(int i=0;i<C.length;i++)
        {
            time+=((long)(C[i])*B);
            
            if(time>n)
            {
                painters++;
                time=((long)(C[i])*B);
            }

        if(painters>A) 
            return false;   
        }

        return true;
    }

    public int paint(int A, int B, int[] C) {

        int max=Integer.MIN_VALUE;
        long sum=0,mod=10000003;

    for(int i=0;i<C.length;i++)
    {
        //C[i]=(int)((((long)C[i]*(long)B))%mod);
        sum=(sum+C[i]+mod)%mod;
        if(C[i]>max)
            max=C[i];
            
         
    }    
    
    //System.out.print((sum*B+mod)%mod+" ");   
    
    if(A>=C.length)
        return (int)((max*B+mod)%mod);

    long l=max*B,r=sum*B,mid=0,result=0;

    while(l<=r)
    {
        mid=l + (r-l)/2;

        if(checkPartition(C,mid,A,B))
            {
                r=mid-1;//Means that for the time we have, we have used less painters
                result=mid;//We can utilise more painters by reducing time limit per painter
            } 
                                
        else
            l=mid+1; //we used more painters, so we need to increase time limit
    }


    return (int)((result+mod)%mod);
    }
}