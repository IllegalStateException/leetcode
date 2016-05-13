package combination;

import java.util.HashMap;
import java.util.Map;

import prepared.SegmentNode;

public class CountOfRangeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOfRangeSum cor = new CountOfRangeSum();
		
		int[] nums = new int[]{-2,3,-1};
		
		System.out.println(cor.countRangeSum3(nums,-2,2));
	}
	
	int count = 0;
	public int countRangeSum(int[] nums, int lower, int upper) {
		
		if(nums == null || nums.length == 0)
			return 0;
		divideAndConquer(nums,0,nums.length-1,lower,upper);
		
		return count;
    }
	
	
	private int divideAndConquer(int[] nums,int from,int to,int lower,int upper){
		
		if(from == to){
			if(nums[from] >= lower && nums[from] <= upper)
				count++;
			return nums[from];
		}
		else{
			int mid = (from + to) /2;
			int leftCount = divideAndConquer(nums,from,mid,lower,upper);
			int rightCount = divideAndConquer(nums,mid+1,to,lower,upper);
			
			Map<Integer,Integer> leftSumMap = new HashMap<>();
			int leftRangeCount = 0;
			for(int i = mid;i>= from;i--){
				leftRangeCount += nums[i];
				leftSumMap.put(i, leftRangeCount);
			}
			
			Map<Integer,Integer> rightSumMap = new HashMap<>();
			int rightRangeCount = 0;
			for(int i = mid+1;i<= to;i++){
				rightRangeCount += nums[i];
				rightSumMap.put(i, rightRangeCount);
			}
			
			for(int i = mid;i >= from;i--){
				
				int left = leftSumMap.get(i);
				for(int j = mid+1;j <= to;j++){
					int right = rightSumMap.get(j);
					
					int total = left + right;
					
					if(total >= lower && total <= upper)
						count++;
				}
			}
			
			
			/*int leftRangeCount = 0;
			for(int i = mid;i >= from;i--){
				leftRangeCount += nums[i];
				int rightRangeCount = 0;
				for(int j = mid+1;j <= to;j++){
					rightRangeCount += nums[j];
					int total = leftRangeCount + rightRangeCount;
					
					if(total >= lower && total <= upper)
						count++;
				}
			}*/
			return leftCount + rightCount;
		}
			
	}
	
	public int countRangeSum2(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	              + countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	        while (k < end && sums[k] - sums[i] < lower) k++;
	        while (j < end && sums[j] - sums[i] <= upper) j++;
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r] = sums[i];
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
	public int countRangeSum3(int[] nums, int lower, int upper) {
		if(nums == null || nums.length == 0)
			return 0;
		
		SegmentNode root =  buildTree(nums,0,nums.length-1);
		
		int total = 0;
		for(int i = 0;i < nums.length;i++){
			
			for(int j = i;j < nums.length;j++){
				int sum = count(i,j,root);
				
				if(sum >= lower && sum <= upper)
					total++;
			}
		}
		
		return total;
		
	}
	
	private int count(int from,int to,SegmentNode root){
		if(root == null || from > to)
			return 0;
		if(root.leftIndex == from && root.rightIndex == to)
			return root.value;
		int mid = (root.leftIndex + root.rightIndex)/2;
		if(to <= mid)
			return count(from,to,root.leftChild);
		else if(from > mid){
			return count(from,to,root.rightChild);
		}
	
		return count(from,mid,root.leftChild) + count(mid+1,to,root.rightChild);
		
	}
	
	
	private SegmentNode buildTree(int[] nums,int from,int to){
		/*if(nums == null || nums.length == 0)
			root = null;*/
		SegmentNode root = new SegmentNode(from,to);
		if(from < to){
			root.leftChild = buildTree(nums,from,(from+to)/2);
			root.rightChild = buildTree(nums,(from+to)/2 +1,to);
			root.value = root.leftChild.value + root.rightChild.value;
		}
		else if(from == to){
			root.value = nums[from];
		}
		return root;
		
	}


}
