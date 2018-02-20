//Nuh Mohamud
import java.util.*;
public class FinalP_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 1;
		int temp = n;
		while(temp >= n/2){
			System.out.print(count +" "+temp);
			temp--;
			count++;
			System.out.println();
		}
	}

}
