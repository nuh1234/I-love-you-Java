//Nuh Mohamud
import java.util.*;
public class MidtermP_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a 4 digit number: ");
		int n = input.nextInt();
		int temp = 0;
		if(Math.abs(n) > 999 && Math.abs(n) < 10000){
			temp = n;
			int lastDigit = temp % 10;
			temp /= 10;
			int third = temp % 10;
			temp /= 10;
			int second = temp % 10;
			temp /= 10;
			if(n < 0){
				System.out.println(lastDigit + "" + Math.abs(temp) + "" + Math.abs(second) + "" + Math.abs(third));
			}else{
				System.out.println(second + "" + third + "" + lastDigit + "" + temp);
			}
		} else {
			System.out.println("The absolute value must be greater than 999 and less than 10000");
		}

	}

}

