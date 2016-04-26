package combination;

import prepared.SegmentNode;

public class SumRangeQuery {
	
	private SegmentNode root;
	
	public SumRangeQuery(int[] nums){
		if(nums == null || nums.length == 0){
			root = null;
		}
		else{
			root = buildTree(nums,0,nums.length-1);
		}
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
	
	private SegmentNode update(int index,int value,SegmentNode root){
		if(root.leftIndex == root.rightIndex && root.leftIndex == index){
			root.value = value;
			return root;
		}
		if(index <= (root.leftIndex + root.rightIndex)/2)
			root.value = root.rightChild.value + update(index,value,root.leftChild).value;
		else
			root.value = root.leftChild.value + update(index,value,root.rightChild).value;
		return root;
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
	
	public void update(int i,int val){
		update(i,val,root);
	}
	
	public int sumRange(int i,int j){
		return count(i,j,root);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,3,5};
		SumRangeQuery sumRange = new SumRangeQuery(nums);
		System.out.println(sumRange.sumRange(1, 2));
		sumRange.update(1, 2);
		System.out.println(sumRange.sumRange(1, 2));
	}

}


