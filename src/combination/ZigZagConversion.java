package combination;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author zwb
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",4));
	}
	public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0)
        	return null;
        if(numRows == 1)
        	return s;
		char[] chars = s.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		int gap = 2 * numRows -2;
		for(int k = numRows;k > 0;k--){
			int pre1 = 0,pre2 = 0;
			for(int i = numRows - k;i < chars.length;i = i + gap){
				if(k == numRows || k == 1){
					sb.append(chars[i]);
				}
				else{
					if(pre1 == 0 && pre2 == 0){
						sb.append(chars[i]);
						pre1 = i;
						if(gap - i < chars.length){
							sb.append(chars[gap - i]);
							pre2 = gap - i;
						}
					}
					else{
						if(pre1 + gap < chars.length){
							sb.append(chars[pre1 + gap]);
							pre1 = pre1 + gap;
						}
						if(pre2 + gap < chars.length){
							sb.append(chars[pre2 + gap]);
							pre2 = pre2 + gap;
						}
					}
				}
			}
		}
		return sb.toString();
    }
}
