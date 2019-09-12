package combination;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = countBits(16);
		for(int i : counts)
			System.out.print(i + " ");
	}
	
	public static int[] countBits(int num) {
        int[] bitCounts = new int[num + 1];
        
        bitCounts[0] = 0;
        
        int index = 0;
        
        for(int i = 1;i <= num;i++){
        	if(i == (int)Math.pow(2, index)){
        		bitCounts[i] = 1;
        		index++;
        	}
        	else{
        		bitCounts[i] = 1 + bitCounts[i - (int)Math.pow(2, index - 1)];
        	}
        	
        }
        
        return bitCounts;
        
    }

}
