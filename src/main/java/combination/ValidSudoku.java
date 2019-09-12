package combination;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid
 * 
 * There are just 3 rules to Sudoku:
 * 1. Each row must have the numbers 1-9 occuring just once
 * 2. Each column must have the numbers 1-9 occuring just once
 * 3. And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid
 * @author zwb
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','4','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		
		System.out.println(isValidSudoku(board));
	}
	
	public static boolean isValidSudoku(char[][] board) {
        
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
		for(int i = 0;i < board[0].length;i++){
			Arrays.fill(exist, false);
			for(int j = 0;j < board.length;j++){
				if(board[j][i] != '.'){
					int num = Character.getNumericValue(board[j][i]);
					if(exist[num - 1])
						return false;
					exist[num - 1] = true;
				}
			}
		}
		
		for(int i = 0;i < 3;i++){
			for(int j = 0;j < 3;j++){
				Arrays.fill(exist, false);
				for(int k = 0;k < 3;k++){
					for(int p = 0;p < 3;p++){
						if(board[3*i + k][3*j+p] != '.'){
							int num = Character.getNumericValue(board[3*i + k][3*j+p]);
							if(exist[num - 1])
								return false;
							exist[num - 1] = true;
						}
					}
				}
			}
			
		}
		return true;
    }
}
