package combination;

import java.util.Arrays;

public class Serach2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serach2DMatrix sm = new Serach2DMatrix();
		
		int[][] matrix = new int[][]{
			{1,4,7,11,15},
			{2,5,8,12,19},
			{3,6,9,16,22},
			{10,13,14,17,24},
			{18,21,23,26,30},
		};
		System.out.println(sm.searchMatrix(matrix, 20));
	}
	
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
        	return false;
        
		int m = matrix.length;
		int n = matrix[0].length;
		if(matrix[0][0] > target || matrix[m-1][n-1] < target)
			return false;
		
		for(int i = 0;i < m;i++){
			if(matrix[i][0] < target && matrix[i][n-1] > target){
				
				int index = Arrays.binarySearch(matrix[i], target);
				if(index >= 0)
					return true;
				
				/*for(int j = 0;j < n;j++){
					if(matrix[i][j] == target)
						return true;
					else if(matrix[i][j] > target)
						break;
				}*/
			}
			else if(matrix[i][n-1] < target)
				continue;
			else if(matrix[i][0] > target)
				return false;
			else if(matrix[i][0] == target || matrix[i][n-1] == target)
				return true;
		}
		return false;
    }
	
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null)
        	return false;
        
		int m = matrix.length;
		int n = matrix[0].length;
		
		if(matrix[0][0] > target || matrix[m-1][n-1] < target)
			return false;
		
		for(int i = 0;i < m;i++){
			if(matrix[i][0] < target && matrix[i][n-1] > target){
				int index = Arrays.binarySearch(matrix[i], target);
				if(index >= 0)
					return true;
			}
			else if(matrix[i][0] > target)
				return false;
			else if(matrix[i][n-1] < target)
				continue;
			else
				return true;
		}
		return false;
	}

}
