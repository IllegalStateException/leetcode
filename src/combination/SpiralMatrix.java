package combination;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix  sm = new SpiralMatrix();
		int n = 7;
		int[][] matrix = sm.generateMatrix(n);
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

	 public int[][] generateMatrix(int n) {
		 int[][] martix = new int[n][n];
		 
		 helper(0,n,martix,0);
		 
		 return martix;
	 }
	 
	 private void helper(int start,int end,int[][] matrix,int sum){
		 if(start >= end){
			 return;
		 }
		 for(int i = start;i < end;i++){
			 
				 matrix[start][i] =  sum + 1 + i - start;
			 
		 }
		 for(int i = start + 1;i < end;i++){
			 matrix[i][end-1] = matrix[i-1][end-1] + 1;
		 }
		 for(int i = end-2;i >= start;i--){
			 
			 matrix[end-1][i] = matrix[end-1][i+1] +1;
		 }
		 for(int i = end-2;i > start;i--){
			 matrix[i][start] = matrix[i+1][start] + 1;
		 }
		 helper(start+1,end-1,matrix,4*(end-start-1) + sum);
	 }
}
