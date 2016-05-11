package combination;

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

}
