package combination;

/**
 *  You are a product manager and currently leading a team to develop a new product. Unfortunately, 
 *  the latest version of your product fails the quality check. Since each version 
 *  is developed based on the previous version, all the versions after a bad version are also bad.
 *  
 *  Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes 
 *  all the following ones to be bad.
 *  You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a 
 *  function to find the first bad version. You should minimize the number of calls to the API. 
 * @author zwb
 *
 */
public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstBadVersion(2126753390));
		System.out.println(Character.getNumericValue('2'));
	}
	
	public static int firstBadVersion(int n) {
        int lastGoodVersion = 0;
        int firstBadVersion = n;
        
        while(firstBadVersion - lastGoodVersion > 1){
        	//不能使用 int mid = (firstBadVersion + lastGoodVersion)/2;会导致int超出范围.
        	int mid = lastGoodVersion + (firstBadVersion - lastGoodVersion) / 2;
        	if(isBadVersion(mid)){
        		firstBadVersion = mid;
        	}
        	else{
        		lastGoodVersion = mid;
        	}
        }
        
		return firstBadVersion;
    }
	
	//使用递归导致内存溢出.
	/*private int helper(int start,int end){
		int lastGoodVersion
		if(end == start)
			return start;
	
		if(isBadVersion((start + end) / 2))
			return helper(start,(start + end)/2);
		else
			return helper((start + end) / 2 + 1,end);
		
	}*/
	
	//模拟方法实现.
	static boolean isBadVersion(int version){
		if(version >= 1702766719)
			return true;
		return false;
	}

}
