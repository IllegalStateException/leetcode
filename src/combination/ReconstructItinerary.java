package combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructItinerary ri = new ReconstructItinerary();
		String[][] tickets = new String[][]{
			{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
		};
		System.out.println(ri.findItinerary(tickets));
	}
	
	
	public List<String> findItinerary(String[][] tickets) {
		Map<String,List<String>> map = new HashMap<>();
		
        for(String[] route : tickets){
        	String departure = route[0];
        	String arrival = route[1];
        	List<String> list;
        	if((list = map.get(departure)) == null){
        		list = new ArrayList<>();
        		list.add(arrival);
        		
        		map.put(departure, list);
        	}
        	else
        		list.add(arrival);
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        	Collections.sort(entry.getValue());
        
        List<String> result = new ArrayList<>(tickets.length+1);
        
        result.add("JFK");
        
        helper("JFK",result,tickets.length+1,map);
        
        return result;
        
    }
	
	private boolean helper(String start,List<String> result,int length,Map<String,List<String>> map){
		if(result.size() == length)
			return true;
		
		List<String> arrivals = map.get(start);
		if(arrivals == null)
			return false;
		
		for(int i = 0;i < arrivals.size();i++){
			String end = arrivals.get(i);
			result.add(end);
			arrivals.remove(i);
			
			if(!helper(end,result,length,map)){
				result.remove(result.size()-1);
				arrivals.add(i, end);
			}
			else
				return true;
		}
		return false;
	}

}
