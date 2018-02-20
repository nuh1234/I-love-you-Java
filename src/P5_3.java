//2B || !2B
public class P5_3 {

	public static void main(String[] args) {
		System.out.println("Kilograms  Pounds");
		for(int i = 1; i < 200; i++){
			double pounds = i * 2.2;
			System.out.printf("%2d%15.1f\n", i, pounds);
		}
		

	}

}
