package combination;

/**
 *  You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, 
 *  then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so 
 *  on. In other words, after each move your direction changes counter-clockwise.
 *  
 *  Write a one-pass algorithm with O(1) extra space to determine, if your path crosses 
 *  itself, or not. 
 * @author zwb
 *
 */
public class SelfCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[]{1,2,3,4};
		System.out.println(isSelfCrossing(x));
	}
	
	
	
	public static boolean isSelfCrossing(int[] x) {
		
		for(int i = 3;i < x.length;i++){
			if(x[i] >= x[i-2] && x[i-1] <= x[i-3])
				return true;
			
			if(i >= 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4])
				return true;
			
			if(i >= 5 && x[i-2] > x[i-4] && x[i-3] > x[i-5] && x[i-1] >= x[i-3]-x[i-5] && x[i]>x[i-2]-x[i-4])
				return true;
		}
		return false;
    }
	
	
	public boolean isSelfCrossing2(int[] x) {
	    if(x.length<4){
	        return false;
	    }
	    else{
	        int up = x[0];
	        int left = x[1];
	        int down = x[0]-x[2];
	        int right = x[1]-x[3];
	        if(right<=0&&down>=0){
	            return true;
	        }
	        if(right>0){
	            //Squeezing pattern, then the later parameters should less than the previous parameters--->
	        	//Keep squeezing
	            return squeeze(x, 4, up, left, down, right);
	        }
	        else if(right==0){//Notice this corner case
	            return squeeze(x, 4, 0, left, down, right);
	        }
	        else{
	            //Expanding pattern
	            return expand(x, 4, up, left, down, right);
	        }
	    }
	}
	private boolean squeeze(int[] x, int index, int up, int left, int down, int right){
	    for(int i = index; i<x.length; i++){
	        int dir = i%4;
	        if(dir==0){
	            int p = down+x[i];
	            if(p>=up){
	                return true;
	            }
	            else{
	                up = p;
	            }
	        }
	        else if(dir==1){
	            int p = right+x[i];
	            if(p>=left){
	                return true;
	            }
	            else{
	                left = p;
	            }
	        }
	        else if(dir==2){
	            int p = up-x[i];
	            if(p<=down){
	                //Notice the signal
	                return true;
	            }
	            else{
	                down = p;
	            }
	        }
	        else{
	            int p = left-x[i];
	            if(p<=right){
	                return true;
	            }
	            else{
	                right = p;
	            }
	        }
	    }
	    return false;        
	}

	private boolean expand(int[] x, int index, int up, int left, int down, int right){
	    int prevUp = up;
	    int prevLeft = left;
	    int prevDown = down;
	    int prevRight = right;
	    for(int i = index; i<x.length; i++){
	        int dir = i%4;
	        if(dir==0){
	            int p = down+x[i];
	            if(p<=up){
	                if(i>=8){
	                    return squeeze(x, i+1, p, prevRight, down, right);
	                }
	                else{
	                    if(p>=0){
	                        return squeeze(x, i+1, p, 0, down, right);
	                    }
	                    else{
	                        return squeeze(x, i+1, p, left, down, right);
	                    }
	                }
	            }
	            else{
	                prevUp = up;
	                up = p;
	            }
	        }
	        else if(dir==1){
	            int p = right+x[i];
	            if(p<=left){
	                return squeeze(x, i+1, up, p, prevUp, right);
	            }
	            else{
	                prevLeft = left;
	                left = p;
	            }
	        }
	        else if(dir==2){
	            int p = up-x[i];
	            if(p>=down){
	                //Notice the signal
	                return squeeze(x, i+1, up, left, p, prevLeft);
	            }
	            else{
	                prevDown = down;
	                down = p;
	            }
	        }
	        else{
	            int p = left-x[i];
	            if(p>=right){
	                return squeeze(x, i+1, prevDown, left, down, p);
	            }
	            else{
	                prevRight = right;
	                right = p;
	            }            
	        }
	    }
	    return false;
	}


}
