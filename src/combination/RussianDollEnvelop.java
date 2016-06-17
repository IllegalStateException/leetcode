package combination;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelop {
	
	public static void main(String[] args){
		RussianDollEnvelop rde = new RussianDollEnvelop();
		int[][] envelopes = new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},
			{6,370},{6,360},{7,380}};
		
		System.out.println(rde.maxEnvelopes(envelopes));
	}
	
	
	public int maxEnvelopes(int[][] envelopes) {
		int n;
        if(envelopes == null || (n = envelopes.length) == 0)
        	return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] param1,int[] param2){
				if(param1[0] == param2[0])
					return param1[1] - param2[1];
				else
					return param1[0] - param2[0];
			}
		});
        int[] dp = new int[n];
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1;i < n;i++){
        	dp[i] = 1;
        	for(int j = i-1;j >= 0;j--){
        		if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]
        				&& dp[i] < dp[j] + 1){
        			dp[i] = dp[j] + 1;
        			max = Math.max(max, dp[i]);
        		}
        	}
        }
        return max;
    }
}



