package combination;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        //System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }




    public static String longestPalindrome(String str){
        if(null == str || str.length() <= 1){
            return str;
        }

        int maxLength = 1;
        int index = 0;
        for(int i = 0; i < str.length() - 1; i++){
            int j = 1;
            int tempMaxLength = 1;
            while (i - j >= 0 && i + j < str.length()){
                if(str.charAt(i - j) == str.charAt(i + j)){
                    tempMaxLength += 2;
                    j++;
                }else {
                    break;
                }
            }

            int tempLength2 = 0;
            if(str.charAt(i) == str.charAt(i+1)){
                tempLength2 = 2;
                int k = 1;
                while (i - k >= 0 && i + k + 1 < str.length()){
                    if(str.charAt(i - k) == str.charAt(i + k + 1)){
                        tempLength2 += 2;
                        k++;
                    }else {
                        break;
                    }
                }
            }

            if(Math.max(tempMaxLength, tempLength2) > maxLength){
                maxLength = Math.max(tempMaxLength, tempLength2);
                index = i;
            }
        }

        if(maxLength % 2 == 0){
            return str.substring(index + 1 - maxLength / 2, index + maxLength / 2 + 1);
        }else {
            return str.substring(index + 1 -(maxLength + 1) / 2, index + (maxLength + 1) / 2);
        }
    }
}
