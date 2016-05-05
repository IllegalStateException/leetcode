package combination;

import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("3+4"));
	}
	
	public static boolean isNumber(String s) {
		if(s == null || s.length() == 0)
			return false;
		//去除前后空格
		char[] chars = s.trim().toCharArray();
		if(chars.length == 0)
			return false;
		//只有一位,必须为数字
		else if(chars.length == 1)
			return chars[0] >= 48 && chars[0] <= 57;
			
		boolean containsE = false;
		boolean containsDot = false;
		boolean hasNumBehindE = false;
		boolean hasNum = false;
		
		int indexOfE = 0;
		
		for(int i = 0;i < chars.length;i++){
			//第一位只可能是: 符号位(+,-),小数点(.),数字(0-9).
			if(i == 0){
				if(chars[i] == '-' || chars[i] == '+')
					continue;
				
				else if(chars[i] == '.'){
					containsDot = true;
					continue;
				}
				else if(chars[i] >= 48 && chars[i] <= 57){
					hasNum = true;
					continue;
				}
				return false;
					
			}
			
			if(chars[i] >= 48 && chars[i] <= 57){
				if(!containsE)
					hasNum = true;
				else
					hasNumBehindE = true;
				continue;
			}
			else if(chars[i] == '.'){
				//e之后不能有小数点,不能同时有两个小数点
				if(!containsE && !containsDot){
					containsDot = true;
					//当小数点为最后一位时,小数点前面需要有数字.
					if(!hasNum && i == chars.length - 1)
						return false;
					continue;
				}
				return false;
			}
			//只能有一个e
			else if(chars[i] == 'e' && !containsE){
				containsE = true;
				indexOfE = i;
				//e之前需要有数字
				if (!hasNum)
					return false;
				continue;
			}
			//非首位的符号位,只能存在于e之后,且紧跟着e.
			else if((chars[i] == '-' || chars[i] == '+') && containsE && i - indexOfE == 1)
				continue;
			
			return false;
		}
		//e之后需要有数字
		/*if(containsE && !hasNumBehindE)
			return false;*/
		return !containsE || hasNumBehindE;
    }
	
	//正则表达式
	public boolean isNumber2(String s) {
        return Pattern.compile("[+-]?(([0-9]+[\\.]?[0-9]*)|([0-9]*[\\.]?[0-9]+))(e[+-]?[0-9]+)?").matcher(s.trim()).matches();
    }

}
