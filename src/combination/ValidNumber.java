package combination;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("+.e3"));
		/*System.out.println(isNumber(" 0.1 "));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("2e+10"));*/
	}
	
	public static boolean isNumber(String s) {
		if(s == null || s.length() == 0)
			return false;
		char[] chars = s.trim().toCharArray();
		if(chars.length == 0)
			return false;
		else if(chars.length == 1)
			return chars[0] >= 48 && chars[0] <= 57;
		boolean containsE = false;
		boolean containsDot = false;
		boolean containsSymbol = false;
		int indexOfE = 0;
		int indexOfDot = 0;
		boolean hasNum = false;
		
		for(int i = 0;i < chars.length;i++){
			if(i == 0){
				if(chars[i] == '-' || chars[i] == '+'){
					containsSymbol = true;
					continue;
				}
				else if(chars[i] == '.'){
					containsDot = true;
					continue;
				}
				else if(chars[i] < 48 || chars[i] > 57)
					return false;
					
			}
			
			if(chars[i] >= 48 && chars[i] <= 57){
				hasNum = true;
				continue;
			}
			else if(chars[i] == '.'){
				if(!containsE && !containsDot){
					containsDot = true;
					indexOfDot = i;
					if(i == chars.length - 1 && i == 1 && containsSymbol)
						return false;
					continue;
				}
				return false;
			}
			else if(chars[i] == 'e'){
				if(!containsE){
					containsE = true;
					indexOfE = i;
					if(!hasNum)
						return false;
					else if(containsDot && i - indexOfDot == 1 && !hasNum)
						return false;
					continue;
				}
				return false;
			}
			else if(chars[i] == '-' || chars[i] == '+'){
				if(containsE && i - indexOfE == 1){
					if(i == chars.length -1)
						return false;
					continue;
				}
				return false;
			}
			
			return false;
		}
		if(containsE && indexOfE == chars.length -1)
			return false;
		return true;
    }

}
