package combination;

public class Perfectsquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perfectsquares ps = new Perfectsquares();
		
		System.out.println(ps.numSquares(13));
	}
	
	public int numSquares(int n) {
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		
		int root = 1;
		for(int i = 1;i <= n;i++){
			if(i == root * root){
				dp[i] = 1;
				root++;
			}
			else{
				int temp = root - 1;
				dp[i] = 1 + dp[i - temp*temp];
				temp = temp--;
				while(temp-- > 0){
					dp[i] = Math.min(dp[i], 1+dp[i - temp*temp]);
				}
			}
		}
		return dp[n];		
    }

}
