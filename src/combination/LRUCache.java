package combination;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	
	private int capacity;
	
	//use parameter string to separate LinkedList.remove(int index) from LinkedList.remove(Object obj),
	//if not ,this may result in w
	private LinkedList<Integer> cache; 
	
	private Map<Integer,Integer> data;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache = new LRUCache(5);
		lruCache.set(0, 0);
		lruCache.set(1, 1);
		lruCache.set(2, 2);
		lruCache.get(0);
		lruCache.set(3, 3);
		lruCache.set(4, 4);
		lruCache.set(5, 5);
		lruCache.get(2);
		lruCache.set(0, 0);
		System.out.println(lruCache.isPowerOfFour(1));
		lruCache.iterator();
	

	}
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		cache = new LinkedList<>();
		data = new HashMap<>();
	}
	
	public int get(int key){
		if(data.isEmpty() || !data.containsKey(key)){
			return -1;
		}
		cache.remove((Object)key);
		cache.addLast(key);
		return data.get(key);
		
	}
	
	public void set(int key,int value){
		if(data.size() == capacity && !data.containsKey(key)){
			int firstKey = cache.poll();
			data.remove(firstKey);
		}
		else if(data.containsKey(key)){
			cache.remove((Object)key);
		}
		cache.addLast(key);
		data.put(key, value);
		
	}
	
	public void iterator(){
		for(Integer i : cache){
			System.out.println(data.get(i));
		}
	}
	
	public boolean isPowerOfFour(int num){
		return (num > 0 && Integer.bitCount(num) == 1 && (num & 0xAAAAAAAA) == 0);
	}

}
