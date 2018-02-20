//Nuh Mohamud
//Passed All Tests on Exercise check tool
import java.math.BigInteger;
import java.util.*;
public class P_18_1 {

	public static void main(String[] args) {
		System.out.println("Enter an integer of any size: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Factorial of " + n + " is " + factorial(n));
		in.close();
	}
	public static BigInteger factorial(int n) {
		if(n == 0) {
			return new BigInteger("1");
		}else {
			return new BigInteger(n + "").multiply(factorial(n - 1));
		}
		
	}

}
