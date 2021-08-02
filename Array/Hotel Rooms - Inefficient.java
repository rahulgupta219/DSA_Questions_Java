public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        
        
        
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        
        for(int i=0;i<arrive.size();i++)
        {
        	if(min>arrive.get(i))
        		min=arrive.get(i);
        }
        
        for(int i=0;i<depart.size();i++)
        {
        	if(max<depart.get(i))
        		max=depart.get(i);
        }
        

        long arr[] = new long[max+2];

        for(int i=0;i<arrive.size();i++)
        {
        	arr[depart.get(i)+1]--;
        	arr[arrive.get(i)]++;
        }

        for(int i=1;i<arr.length;i++)
        {

        	arr[i]+=arr[i-1];

        	if(arr[i]>K)
        		return false;
        }
    return true;
    }
}

Time: O(n)
Space: O(maximum value)

//Not efficient