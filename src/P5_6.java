public class P5_6{
	public static void main(String[] args){
		System.out.printf("%6s%15s%3s%12s%10s\n", "Miles", "Kilometers", "|", "Kilometers", "Miles");
		for(int i = 1, k = 20; i < 11 && k <= 65; i++, k+=5){
			System.out.printf("%2d%14.3f%8s%4d%18.3f", i, i*1.609, "|", k, k/1.609);
			System.out.println("");

		}
	}
	
}