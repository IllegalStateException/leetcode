package combination;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersWithUniqueDig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNumbersWithUniqueDig cnwu = new CountNumbersWithUniqueDig();
		System.out.println(cnwu.countNumbersWithUniqueDigits(3));
		
		System.out.println(cnwu.countNumbersWithUniqueDigitsWithBT(3));
	}
	
	public int countNumbersWithUniqueDigits(int n) {
		if(n == 0)
			return 1;
        int[] dp = new int[n];
        dp[0] = 10;
        int temp = 9;
        for(int i = 1; i < n;i++){
        	
        	temp *= (10 - i);
        	dp[i] = dp[i-1] + temp;
        }
        
        return dp[n-1];
        
    }
	
	//backtracking 
	int count = 0;
	public int countNumbersWithUniqueDigitsWithBT(int n){
		if(n == 0)
			return 1;
		backtracking(new HashSet<Integer>(),n);
		int temp = count;
		this.count = 0;
		
		return temp + countNumbersWithUniqueDigitsWithBT(n-1);
		
	}
	
	private void backtracking(Set<Integer> set,int n){
		if(set.size() == n){
			count++;
			return;
		}
		if(set.size() == 0){
			for(int i = 1; i <= 9;i++){
				set.add(i);
				backtracking(set,n);
				set.remove(i);
			}
		}
		else{
			for(int i = 0; i <= 9;i++){
				if(!set.contains(i)){
					set.add(i);
					backtracking(set, n);
					set.remove(i);
				}
			}
		}
			
	}
	

}
