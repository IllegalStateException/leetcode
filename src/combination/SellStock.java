package combination;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

	prices = [1, 2, 3, 0, 2]
	maxProfit = 3
	transactions = [buy, sell, cooldown, buy, sell]

 * @author zwb
 *
 */
public class SellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[]{1,2,4};
		System.out.println(maxProfit3(prices));
	}
	
	
	public static int maxProfit(int[] prices) {
		//List<? super Integer> list = new ArrayList<>();
        // special case
        if (prices.length == 0) return 0;
        if (prices.length == 1) return 0;

        // main loop
        int inclusive = 0; // may include current profit
        int exclusive = 0; // not include current profit
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            int newInclusive = Math.max(inclusive + profit, exclusive);
            int newExclusive = Math.max(inclusive, exclusive);
            inclusive = newInclusive;
            exclusive = newExclusive;
        }

        // return result
        return Math.max(inclusive, exclusive);
    }
	
	/**
	 * my solution
	 * @param prices
	 * @return
	 */
	public static int maxProfit2(int[] prices) {
	    if(prices.length <= 1)
	        return 0;
	    //coolDown[i] 表示在prices[i]时,进入coolDown的最大收益
	    int[] coolDown = new int[prices.length];
	    //sell[i] 表示在prices[i]时,卖出的最大收益
	    int[] sell = new int[prices.length];
	    coolDown[0] = 0;
	    coolDown[1] = 0;
	    sell[1] = prices[1] - prices[0];
	    for(int i = 2; i < prices.length; i++){
	    	coolDown[i] = Math.max(sell[i-1], coolDown[i-1]);
	        
	    	sell[i] = prices[i] - prices[i-1] + Math.max(coolDown[i-2], sell[i-1]); 
	   	}
	    return Math.max(coolDown[prices.length-1], sell[prices.length-1]);
	}
	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
	 * design an algorithm to find the maximum profit.
	 * 本质上是一个数组的最大子序列和问题.
	 * @param prices
	 * @return
	 */
	public static int maxProfit3(int[] prices){
		if(prices.length <= 1)
	        return 0;
		
		int maxProfit = 0;
		
		int sum = 0;
		for(int i = 0;i < prices.length - 1;i++){
			sum = sum + (prices[i+1] - prices[i]);
			if(sum < 0){
				sum = 0;
			}
			if(sum > maxProfit){
				maxProfit = sum;
			}
		}
			return maxProfit;
	}

}
