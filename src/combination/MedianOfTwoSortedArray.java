package combination;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1,2,3,4};
		int[] nums2 = new int[]{4,5,6,7,8};
		
		MedianOfTwoSortedArray mta = new MedianOfTwoSortedArray();
		
		System.out.println(mta.findMedianSortedArrays(nums1, nums2));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        
        int i = 0,j = 0,k = 0;
        
        Integer temp1 = null;
        Integer temp2 = null;
        
        int mid = (n + m) /2;
        //int[] combin = new int[mid+1];
        int temp = 0;
        for(;i < n && j < m;k++){
        	
        	if(nums1[i] < nums2[j]){
        		temp = nums1[i++];
        	}
        	else if(nums1[i] == nums2[j]){
        		temp = nums1[i++];
        		//combin[k] = nums2[j++];
        	}
        	else{
        		temp = nums2[j++];
        	}
        	if(k == mid - 1)
        		temp1 = temp;
        	else if(k == mid){
        		temp2 = temp;
        		break;
        	}
        }
        if(temp1 == null || temp2 == null){
			if (i < n) {
				for (; i < n; i++,k++) {
					temp = nums1[i];
					if (k == mid - 1)
						temp1 = temp;
					else if (k == mid){
						temp2 = temp;
						break;
					}
				}
			} 
			else if (j < m) {
				for (; j < m; j++,k++) {
					temp = nums2[j];
					if (k == mid - 1)
						temp1 = temp;
					else if (k == mid){
						temp2 = temp;
						break;
					}
				}
			}
        }
        if((n+m) % 2 == 1)
        	return temp2;
        else{
        	return (temp1 + temp2) / 2.0;
        }
    }
	

}
