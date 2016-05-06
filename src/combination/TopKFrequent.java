package combination;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TopKFrequent tf = new TopKFrequent();
		
		int[] nums = new int[]{1,1,1,1,2,2,2,3,3,4};
		System.out.println(tf.topKFrequent(nums, 2).toString());

	}
	
	class Item{
		int number;
		int times;
		
		void increaseTimes(){
			this.times = times + 1;
		}
		
		
		Item(int number,int times){
			this.number = number;
			this.times = times;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Item> map = new HashMap<>();
        
		for(Integer number : nums){
			Item item;
			if((item = map.get(number)) == null){
				item = new Item(number,1);
				map.put(number, item);
			}
			else{
				item.increaseTimes();
			}
		}
		
		Queue<Item> pqueue = new PriorityQueue<>(map.size(),new Comparator<Item>(){
			
			@Override
			public int compare(Item item1,Item item2){
				return item2.times - item1.times;
			}
		});
		
		for(Map.Entry<Integer, Item> entry : map.entrySet()){
			pqueue.offer(entry.getValue());
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(k > 0){
			result.add(pqueue.poll().number);
			k--;
		}
		
		return result;
		
    }
}
