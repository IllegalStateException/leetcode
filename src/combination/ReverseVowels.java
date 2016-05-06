package combination;

public class ReverseVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowels rv = new ReverseVowels();
		
		System.out.println(rv.reverseVowels("leetcode"));
	}
	
	enum Vowel{
		a('a'),e('e'),i('i'),o('o'),u('u');
		
		private char c;
		
		Vowel(char c){
			this.c = c;
		}
		
		public static boolean isVowel(char c){
			
			for(Vowel vowel : Vowel.values()){
				if(c == vowel.c || c + 32 == vowel.c)
					return true;
			}
			return false;
		}
	}
	
	public String reverseVowels(String s) {
        if(s == null || s.length() == 0)
        	return s;
        
        char[] chars = s.toCharArray();
        
        int start = 0,end = s.length() - 1;
        
        while(start < end){
        	if(Vowel.isVowel(chars[start]) && !Vowel.isVowel(chars[end]))
        		end--;     	
        	else if(!Vowel.isVowel(chars[start]) && Vowel.isVowel(chars[end]))
        		start++;
        	else if(Vowel.isVowel(chars[start]) && Vowel.isVowel(chars[end])){
        		char temp = chars[start];
        		chars[start] = chars[end];
        		chars[end] = temp;
        		start++;
        		end--;
        	}
        	else{
        		start++;
        		end--;
        	}	
        }
        return new String(chars);
    }

}
