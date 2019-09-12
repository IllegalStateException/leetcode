package combination;

public class WaterAndJug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaterAndJug waj = new WaterAndJug();
		
		System.out.println(waj.canMeasureWater(104659, 104677, 142424));
		
		
	}
	
	public boolean canMeasureWater(int x,int y,int z){
		if(z == x || z == y || z == x+y || z == 0)
			return true;
		
		int max = Math.max(x, y);
		int min = Math.min(x,y);
		
		if(z > max)
			z -= max;
		if(min == 0)
			return z == max;
		
		int temp = max % min;
		while(temp > 0){
			int total = 0;
			while(total <= max){
				total += temp;
				if(total == z)
					return true;
			}
			temp = (max+temp) % min;
		}
		
		return false;	
	}

}
