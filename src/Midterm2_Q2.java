//Nuh Mohamud
public class Midterm2_Q2 {

	public static void main(String[] args) {
		for(int i = 9; i > 0; i--){
			for(int j = i; j <= i*9; j+=i){
				System.out.printf("%2d%2s", j, "");
			}
			System.out.println("");
		}

	}

}
