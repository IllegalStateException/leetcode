package combination;

public class BulbSwitcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bulbSwitch(4));
	}
	
	public static int bulbSwitch(int n){
		if(n <= 0)
			return 0;
		int count = 1;
		for(int i = 2;i <= n;i++){
			int num = 0;
			int a = (int)Math.sqrt(i);
			for(int j = 1;j <= a;j++){
				if(i % j == 0)
					num += 2;
			}
			if(a * a == i)
				num--;
			
			if(num % 2 == 1)
				count++;	
		}
		return count;
	}
	
	public static int bulbSwitch2(int n){
		if(n <= 0)
			return 0;
		return (int)Math.sqrt(n);
	}

}
