package combination;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NthUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthUglyNumber nun = new NthUglyNumber();
		System.out.println(nun.nthUglyNumberWith3List(10));

	}
	
	public int nthUglyNumber(int n) {
		if(n <= 0)
			return 0;
		
		Queue<Long> queue = new PriorityQueue<>();
		
		queue.offer(1l);
		int index = 0;
		while(index < n-1){
			long num = queue.poll();
			if(num % 30 == 0){
				queue.poll();
				queue.poll();
			}
			else if(num % 6 == 0 || num % 10 == 0 || num % 15 == 0)
				queue.poll();
			
			long doubleNum = 2 * num;
			long tripleNum = 3 * num;
			long fiveTimeNum = 5 * num;

			queue.offer(doubleNum);
			queue.offer(tripleNum);
			queue.offer(fiveTimeNum);
			index++;
			
		}
		return queue.poll().intValue();		
    }
	
	public int nthUglyNumberWith3List(int n){
		List<Long> twoList = new ArrayList<>();
		List<Long> threeList = new ArrayList<>();
		List<Long> fiveList = new ArrayList<>();
		
		twoList.add(1L);
		threeList.add(1L);
		fiveList.add(1L);
		
		int indexOfTwoList = 0,indexOfThreeList = 0,indexOfFiveList = 0;
		for(int i = 1;i < n;i++){
			
			long min = Math.min(twoList.get(indexOfTwoList), threeList.get(indexOfThreeList));
			min = Math.min(min, fiveList.get(indexOfFiveList));
			
			if(min == twoList.get(indexOfTwoList))
				indexOfTwoList++;
			if(min == threeList.get(indexOfThreeList))
				indexOfThreeList++;
			if(min == fiveList.get(indexOfFiveList))
				indexOfFiveList++;
			
			twoList.add(2*min);
			threeList.add(3*min);
			fiveList.add(5*min);	
		}
		
		return (int)Math.min(Math.min(twoList.get(indexOfTwoList), threeList.get(indexOfThreeList)),
				fiveList.get(indexOfFiveList));
		
	}

}
