package combination;

public class ExcelSheetColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumn esc = new ExcelSheetColumn();
		
		System.out.println(esc.titleToNumber(esc.convertToTitle(25)));
	}
	
	public String convertToTitle(int n) {
		
		
		StringBuilder sb = new StringBuilder();
		
		while(n > 0){
			int k = n % 26;
			n = n/26;
			
			if(k == 0){
				sb.append("Z");
				n--;
			}
			else{
				sb.append((char)('A' + k -1));
			}
		}
		sb.reverse();
		
		return sb.toString();
		
    }
	
	public int titleToNumber(String s) {
        
		char[] chars = s.toCharArray();
		int result = 0;
		
		for(int i = 0;i < chars.length;i++){
			result = result + (chars[i]-64) * (int)Math.pow(26, chars.length - i - 1);
		}
		
		return result;
    }

}
