package combination;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3,2,1,5,6,4};
		KthLargestElement kle = new KthLargestElement();
		
		System.out.println(kle.findKthLargest(nums, 2));
	}
	
	public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(nums.length,new Comparator<Integer>(){
        	@Override
        	public int compare(Integer num1,Integer num2){
        		return num2 - num1;
        	}
        });
        
        for(int num : nums)
        	heap.offer(num);
        
        int result = 0;
        while(k-- > 0)
        	result = heap.poll();
        
        return result;
    }

}
