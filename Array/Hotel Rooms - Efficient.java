public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        
       int hotel[]=new int[arrive.size()*2];
        HashMap<Integer,Integer> arrival = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> departure = new HashMap<Integer,Integer>();


        for(int i=0;i<arrive.size();i++)
        {
            hotel[i*2]=arrive.get(i);
            if(!arrival.containsKey(hotel[i*2]))
                arrival.put(hotel[i*2],1);
            else
                arrival.put(hotel[i*2],arrival.get(hotel[i*2])+1);
            
            hotel[i*2+1]=depart.get(i);
            if(!departure.containsKey(hotel[i*2+1]))
                departure.put(hotel[i*2+1],1);
            else
                departure.put(hotel[i*2+1],departure.get(hotel[i*2+1])+1);
        }

        Arrays.sort(hotel);
        
        
        
        int rooms=0;
        
        for(int i=0;i<hotel.length;i++)
        {
            //System.out.println(hotel[i]+"->"+rooms);
            
            if(arrival.containsKey(hotel[i]))
                rooms+=arrival.get(hotel[i]);
            
            if(rooms>K)
                return false;
            
            if(departure.containsKey(hotel[i]))
                rooms-=departure.get(hotel[i]);
        
            
        
        if(arrival.containsKey(hotel[i]) && departure.containsKey(hotel[i]))
            i+=(arrival.get(hotel[i])+departure.get(hotel[i])-1);
        else if(arrival.containsKey(hotel[i]))
            i+=(arrival.get(hotel[i])-1);
        else if(departure.containsKey(hotel[i]))
            i+=departure.get(hotel[i])-1;
        
        }
    
    return true;
    }
}

Time: O(n*log(n))
Space: O(n)

//Not efficient

Collections.sort(arrive);
        Collections.sort(depart);
        int ar=0, de=0, nos=0,satisfy=0 , roomoccupancy=0;
        while(ar<arrive.size() && de<depart.size()){
            if(arrive.get(ar)<depart.get(de)){
                ar++;
                nos++;
                roomoccupancy++;
                satisfy= Math.max(nos,satisfy);
            }else{
                de++;
                nos--;
            }
        }
        return (satisfy<=K)?true:false;