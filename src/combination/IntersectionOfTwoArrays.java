package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		int length1,length2;
		if(nums1 == null || (length1=nums1.length) == 0 || nums2 == null || (length2=nums2.length) == 0)
			return new int[0];
		
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		for(int i = 0,j = 0;i < length1 && j < length2;){
			if(nums1[i] < nums2[j])
				i++;
			else if(nums1[i] == nums2[j]){
				result.add(nums1[i]);
				i++;
				j++;
			}
			else
				j++;
		}
		int[] temp = new int[result.size()];
		int index = 0;
		for(int i : result){
			temp[index++] = i;
		}
		return temp;
    }
	
	public int[] intersection(int[] nums1, int[] nums2) {
		int length1,length2;
		if(nums1 == null || (length1=nums1.length) == 0 || nums2 == null || (length2=nums2.length) == 0)
			return new int[0];
		
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		for(int i = 0,j = 0;i < length1 && j < length2;){
			if(nums1[i] < nums2[j])
				i++;
			else if(nums1[i] == nums2[j]){
				if(result.isEmpty() || result.get(result.size()-1) != nums1[i])
					result.add(nums1[i]);
				i++;
				j++;
			}
			else
				j++;
		}
		int[] temp = new int[result.size()];
		int index = 0;
		for(int i : result){
			temp[index++] = i;
		}
		return temp;
    }

}
