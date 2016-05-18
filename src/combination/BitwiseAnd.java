package combination;

public class BitwiseAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseAnd ba = new BitwiseAnd();
		
		System.out.println(ba.rangeBitwiseAnd(9,15));
	}
	
	public int rangeBitwiseAnd(int m, int n) {
        if(m == 0)
        	return 0;
        
        int k = (int)(Math.log(m)/Math.log(2));
        int p = (int)(Math.log(n)/Math.log(2));
        
        if(Math.pow(2, k) == m && p == k)
        	return m;
        else if(p - k >= 1)
        	return 0;
        else{
        	int sum = (int)Math.pow(2, k);
        	
        	while(k > 0){
        		int temp = (int)Math.pow(2, --k);
        		sum = sum + temp;
        		if(n < sum){
        			sum -= temp;
        		}
        		else if(m < sum && n >= sum){
        			sum -= temp;
        			return sum;
        		}
        	}
        	return sum;
        }
        		
        
        
    }

}
