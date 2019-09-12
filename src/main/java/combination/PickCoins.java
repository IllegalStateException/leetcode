package combination;

import java.util.Arrays;

public class PickCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(pickCoins(new Integer[]{1,2,5},11));
		System.out.println(coinChange(new int[]{1,2,5},22));
		System.out.println(maxSubString(new int[]{-1,-2,5,-3,-1,3,1}));
	}
	
	public static int coinChange(int[] coins, int amount) {
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, -1);
	    dp[0] = 0;
	    for(int i = 1; i <= amount; i++) {
	        for(int j = 0; j < coins.length; j++) {
	            if(coins[j] == i) {
	                dp[i] = 1;
	                break;
	            }
	            else if(coins[j] < i && dp[i - coins[j]] > 0) {
	                dp[i] = (dp[i] == -1) ? dp[i - coins[j]] + 1 : Math.min(dp[i], dp[i - coins[j]] + 1);
	            }
	        }
	    }

	    return dp[amount];
	}
	
	public static int maxSubString(int[] args){
		int thisSum = 0;
		int maxSum = 0;
		
		for(int i : args){
			thisSum += i;
			
			if(thisSum > maxSum){
				maxSum = thisSum;
			}
			if(thisSum < 0){
				thisSum = 0;
			}
		}
		return maxSum;
	}

}
