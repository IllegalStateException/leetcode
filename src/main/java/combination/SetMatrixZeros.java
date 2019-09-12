package combination;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void setZeroes(int[][] matrix) {
       
		if(matrix == null || matrix.length == 0)
			return;
		
		int rowNum = matrix.length;
		int columnNum = matrix[0].length;
		
		boolean[] row = new boolean[rowNum];
		boolean[] column = new boolean[columnNum];
		for(int i = 0;i < rowNum;i++){
			
			for(int j = 0;j < columnNum;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0;i < rowNum;i++){
			if(row[i]){
				for(int j = 0;j < columnNum;j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 0;i < columnNum;i++){
			if(column[i]){
				for(int j = 0;j < rowNum;j++){
					matrix[j][i] = 0;
				}
			}
		}
    }

}
