package combination;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid
 * @author zwb
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSudoku(char[][] board) {
        
		boolean[] exist = new boolean[9];
		
		
		for(int i = 0;i < board.length;i++){
			Arrays.fill(exist, false);
			for(int j = 0;j < board[i].length;j++){
				if(board[i][j] != '.'){
					int num = Character.getNumericValue(board[i][j]);
					if(exist[num - 1])
						return false;
					exist[num - 1] = true;
				}
			}
		}
    }

}
