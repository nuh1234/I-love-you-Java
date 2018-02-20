//2B || !2B

public class P6_6 {

	public static void main(String[] args) {
		pattern(3);
	}
	public static void pattern(int n){
		int spaces = n;
		for(int row = 1; row <= n; row++){
			System.out.print(pad("",spaces));				
			for(int j = row; j >= 1; j--){
				System.out.print(j+" ");
			}
			System.out.println("");
			spaces--;
		}
	}

	public static String pad(String s, int n){
		for(int i = 0; i <= n; i++){
			s += "  ";
			
		}
		return s;
	}

}
