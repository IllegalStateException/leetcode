package combination;

public class NumMatrix {

	long[][] sumMatrix;
	
	public NumMatrix(int[][] matrix) {
		if(matrix != null && matrix.length > 0){
			int length = matrix.length;
			int high = matrix[0].length;

			sumMatrix = new long[length + 1][high + 1];

			for (int i = 0; i < length; i++) {
				long tempSum = 0;
				for (int j = 0; j < high; j++) {
					tempSum += matrix[i][j];
					sumMatrix[i + 1][j + 1] = sumMatrix[i][j + 1] + tempSum;
				}
			}
		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(sumMatrix == null)
    		return 0;
       return (int)(sumMatrix[row2+1][col2+1] - sumMatrix[row1][col2+1] - sumMatrix[row2+1][col1] 
    		   + sumMatrix[row1][col1]);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
				{3, 0, 1, 4, 2},
			  {5, 6, 3, 2, 1},
			  {1, 2, 0, 1, 5},
			  {4, 1, 0, 1, 7},
			  {1, 0, 3, 0, 5}};
			 
		 NumMatrix nm = new NumMatrix(matrix);
		 
		 System.out.println(nm.sumRegion(1, 2, 2, 4));
	}
}
