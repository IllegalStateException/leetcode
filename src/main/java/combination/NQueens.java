package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens nq = new NQueens();
		
		System.out.println(nq.totalNQueens(4));
	}
	
	
	//n-queen 
	public List<List<String>> solveNQueens(int n) {
		
		char[][] board = new char[n][n];
	    
		for(int i = 0;i < n;i++){
			Arrays.fill(board[i], '.');
		}
		
		List<List<String>> result = new ArrayList<>();
		
		backTracking(board,0,result,n);
		
		return result;
		
    }
	
	private void backTracking(char[][] board,int row,List<List<String>> result,int n){
		
		if(row == n){
			List<String> item = new ArrayList<>();
			for(int i = 0;i < n;i++){
				item.add(new String(board[i]));
			}
			result.add(item);
			return;
		}
		
		for(int i = 0;i < n;i++){
			board[row][i] = 'Q';
			if(!isValid(board,row,i,n)){
				board[row][i] = '.';
			}
			else{
				backTracking(board,row+1,result,n);
				board[row][i] = '.';
			}
		}
	}
	
	private boolean isValid(char[][] board,int row,int column,int n){
		
		//判断列是否有queen
		for(int i = row-1;i >= 0;i--){
			if('Q' == board[i][column])
				return false;
		}
		
		//判断右对角线是否有queen
		for(int i = row-1,j = column+1;i >= 0 && j <= n-1;i--,j++){
			if('Q' == board[i][j])
				return false;
		}
		
		//判断左对角线是否有queen
		for(int i = row-1,j = column-1;i >= 0 && j >= 0;i--,j--){
			if('Q' == board[i][j])
				return false;
		}
		
		return true;
	}
	int count = 0;
	//n-queen ii
	public int totalNQueens(int n) {
		
		char[][] board = new char[n][n];
	    
		for(int i = 0;i < n;i++){
			Arrays.fill(board[i], '.');
		}
		
		backTracking2(board,0,n);
		
		return count;
		
    }
	
	private void backTracking2(char[][] board,int row,int n){
		
		if(row == n){
			count++;
			return;
		}
		
		for(int i = 0;i < n;i++){
			board[row][i] = 'Q';
			if(!isValid(board,row,i,n)){
				board[row][i] = '.';
			}
			else{
				backTracking2(board,row+1,n);
				board[row][i] = '.';
			}
		}
	}

}
