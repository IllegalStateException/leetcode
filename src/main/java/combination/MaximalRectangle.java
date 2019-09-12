package combination;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][]{
			{'0','1','1','1'},
			{'1','1','1','1'},
			{'1','1','1','1'},
			{'1','1','1','1'},
			{'1','1','1','1'}
		};
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(matrix));
	}
	
	static class Rectangle{
		int length;
		int width;
		int areaSize;
		
		public Rectangle(int length,int width){
			this.length = length;
			this.width = width;
			this.areaSize = this.width*this.length;
		}
	}
	
	public int maximalRectangle(char[][] matrix) {
		int xLen,yLen;
        if(matrix == null || (xLen = matrix.length) == 0)
        	return 0;
        yLen = matrix[0].length;
        
        Rectangle[][] dp = new Rectangle[xLen+1][yLen+1];
        Rectangle rect = new Rectangle(0,0);
        
        for(int i = 0;i <= xLen;i++){
        	dp[i][0] = rect;
        }
        
        for(int j = 0;j <= yLen;j++)
        	dp[0][j] = rect;
        
        int max = 0;
        for(int i = 0;i < xLen;i++){
        	for(int j = 0;j < yLen;j++){
        		dp[i+1][j+1] = helper(i,j,matrix,dp);
        		max = Math.max(max, dp[i+1][j+1].areaSize);
        	}
        }
        
        return max;
    }
	
	private Rectangle helper(int x,int y,char[][] matrix,Rectangle[][] dp){
		int length = 0;
		int width = 0;
		
		int tempX = x;
		int tempY = y;
		
		Rectangle preTop = dp[x][y+1];
		Rectangle preLeft = dp[x+1][y];
		
		while(y>= 0 && matrix[tempX][y--] == '1'){
			length++;
		}
		while(x>= 0 && matrix[x--][tempY] == '1'){
			width++;
		}
		
		Deque<Rectangle> stack = new ArrayDeque<>();
		
		
		if (length >= width)
			stack.push(new Rectangle(length, 1));
		else
			stack.push(new Rectangle(1, width));
		
		Rectangle r1 = new Rectangle(preLeft.length+1,Math.min(width, preLeft.width));
		Rectangle r2 = new Rectangle(Math.min(length, preTop.length),preTop.width+1);
		
		Rectangle r3 = stack.peek();
		if(r3.areaSize < r1.areaSize){
			stack.pop();
			stack.push(r1);
		}
		r3 = stack.peek();
		if(r3.areaSize < r2.areaSize){
			stack.pop();
			stack.push(r2);
		}
			
		return stack.pop();
			
	}

}
