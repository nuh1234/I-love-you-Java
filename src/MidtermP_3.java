//Nuh Mohamud
import java.util.*;
public class MidtermP_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a 4 digit number: ");
		int n = input.nextInt();
		int temp = 0;
		if(n > 999 && n < 10000){
			temp = n;
			int lastDigit = temp % 10;
			temp /= 10;
			int third = temp % 10;
			temp /= 10;
			int second = temp % 10;
			temp /= 10;
			System.out.println(second + "" + third + "" + lastDigit + "" + temp);
		} else {
			System.out.println("A four digit number must be greater than 999 and less than 10000");
		}

	}

}
