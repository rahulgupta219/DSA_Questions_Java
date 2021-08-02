public class Solution {
    public int[] maxone(int[] A, int B) {
    
    int n=A.length;
    int l=0,r=0,maxl=-1,maxr=-1,count=0;

    for(r=0;r<n;r++){

        if(A[r]==0)
            count++;

        while(l<=r && count>B)
        {
            if(A[l]==0)
                count--;
            l++;
        }



        if((r-l+1)>(maxr-maxl+1) ||  (maxr==-1 && maxl==-1))
        {
            maxr=r;
            maxl=l;
        }

    }

    int res[]=new int[maxr-maxl+1];

    for(int i=maxl;i<=maxr;i++)
        res[i-maxl]=i;


    return res;
    }
}
