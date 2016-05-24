package combination;

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = new int[][]{
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};
		UniquePath uq = new UniquePath();
		
		System.out.println(uq.uniquePathsWithObstacles(obstacleGrid));
				
	}
	
	public int uniquePaths(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m;i++){
			if(i == 0){
				Arrays.fill(dp[0], 1);
				continue;
			}
			for(int j = 0;j < n;j++){
				if(j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
			}
		}
		return dp[m-1][n-1];
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
		int[][] dp =  new int[m][n];
		
		for(int i = 0;i < m;i++){
			
			for(int j = 0;j < n;j++){
				if(i == 0){
					if(j == 0)
						dp[i][j] = obstacleGrid[0][0] == 1 ? 0 : 1;
					else{
						if (obstacleGrid[i][j] == 0)
							dp[i][j] = dp[i][j - 1];
						else
							dp[i][j] = 0;
					}
				}
				else{
					if(j == 0){
						if (obstacleGrid[i][j] == 0)
							dp[i][j] = dp[i-1][j];
						else
							dp[i][j] = 0;
					}
					else{
						if(obstacleGrid[i][j] == 0)
							dp[i][j] = dp[i-1][j] + dp[i][j-1];
						else
							dp[i][j] = 0;
					}
				}
			}
		}
		return dp[m-1][n-1]; 
    }

}
