package combination;

public class MaxiumSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][]{
			{'0','0','0','1'},
			{'1','1','0','1'},
			{'1','1','1','1'},
			{'0','1','1','1'},
			{'0','1','1','1'}
		};
		
		MaxiumSquare ms = new MaxiumSquare();
		System.out.println(ms.maximalSquare(matrix));
	}
	
	public int maximalSquare(char[][] matrix) {
		int xLen,yLen;
        if(matrix == null || (xLen = matrix.length) == 0)
        	return 0;
        yLen = matrix[0].length;
        
        int[][] dp = new int[xLen+1][yLen+1];
        int max = 0;
        for(int i = 0;i < xLen;i++){
        	for(int j = 0;j < yLen;j++){
				dp[i + 1][j + 1] = allEquals1(i, j, matrix,dp[i][j]);
        		
        		max = Math.max(max, dp[i+1][j+1]);
        	}
        }
        return max*max;
        
    }
	
	private int allEquals1(int x,int y,char[][] matrix,int step){
		int tempX = x;
		int tempY = y;
		int result = 0;
		while(step >= 0){
			if(matrix[tempX][tempY] == '0' || matrix[x][y] == '0')
				return result;
			else
				result++;
			tempX--;
			step--;
			y--;
		}
		return result;
	}

}
