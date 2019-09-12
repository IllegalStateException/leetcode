package combination;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * @author zwb
 *
 */
public class SqrtX {
	
	/**
	 * two binary search solution
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
        if(x == 0)
			return 0;
		
        long start = 1;
        long end = x;
        
        long temp;
        while(end-start > 1){
        	long mid = (start+end)/2;
        	if((temp = mid * mid) > x){
    			end = mid;
    		}
    		else if(temp == x)
    			return (int)mid;
    		else{
    			start = mid;
    		}
        }
        return (int)start;
    }
}
