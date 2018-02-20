//Nuh Mohamud
import java.util.*;
public class MidtermP_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many sides for your die? ");
		int n = input.nextInt();
		for(int i = 1; i < 6; i++){
			System.out.println("Roll " + i + " : " + (int)((Math.random()* n) + 1));
		}
	}

}
