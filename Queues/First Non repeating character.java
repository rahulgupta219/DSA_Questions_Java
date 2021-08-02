public class Solution {
    
    public StringBuilder checkRepeat(HashMap<String,Integer> HM,Queue<String> que, StringBuilder s)
    {
        while(HM.get(que.peek())>=2)
    	{
    	    que.poll();
    		if(que.peek()==null)
    		    break;
    	}
    		if(que.peek()==null)
		    	s.append("#");
		    else
    		s.append(que.peek());
    return s;    
    }
    
    public String solve(String A) {

    	Queue<String> que = new LinkedList<>();
        HashMap<String,Integer> HM = new HashMap<String,Integer>();
        
    	String c="";
    	StringBuilder s = new StringBuilder();

    	for(int i=0;i<A.length();i++)
    	{
    		c=A.charAt(i)+"";
            
    		if(HM.containsKey(c))
    		{
    			HM.put(c,HM.get(c)+1);
    			//Yes, entry is already in hashmap
    			//Meaning first element from the queue needs to be added
    			if(que.peek()==null)
    				s.append("#");
    			else
    				s=checkRepeat(HM,que,s);
    		}
    		else
    		{
    			//Element is occuring first time
    			HM.put(c,1);
    			if(que.peek()==null)
    			{
    				s.append(c);
    				que.add(c);
    			}
    			else
    			{
    			    que.add(c);
    				s.append(que.peek());
    			}
    		}
		}
		return s.toString();
	}
}
