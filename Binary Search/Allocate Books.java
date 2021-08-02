public class Solution {
    
    public boolean checkBooksAllotment(int[] A, int b, int n)
    {
        int sum=0,students=1;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]>n)
                return false;
           
            sum+=A[i];

            if(sum>n)
                {students++;sum=A[i];}
        
        if(students>b)
            return false;        
                
        }
        
    return true;
    }

    public int books(int[] A, int B) {
        
    int sum=0,min=Integer.MAX_VALUE;    
    
    if(A.length<B)
        return -1;
        
    for(int i=0;i<A.length;i++)
    {
        sum+=A[i];
        if(A[i]<min)
            min=A[i];
            
    }

    int l=min,r=sum,mid=0,res=0;

    while(l<r)
    {
        mid=(l+r)>>1;
        
    //System.out.print(mid+"->"+checkBooksAllotment(A,B,mid));
        if(checkBooksAllotment(A,B,mid))
            {res=mid;r=mid;}
        else
            l=mid+1;
            
    //System.out.print("1");        
            
    }

    return (l+r)>>1;    
    }
}
