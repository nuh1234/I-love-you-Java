//Nuh Mohamud
//Passed the Exercise check tool, the check tool only had a single test 
import java.util.*;
public class Exercise18_03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int m = in.nextInt();
		System.out.println("Enter the second number: ");
		int n = in.nextInt();
		System.out.println("The GCD of " + m + " and " + n + " is " + gcd(m, n));
		in.close();
	}
	public static int gcd(int m, int n) {
		if(m % n == 0) {
			return n;
		} else {
			return gcd(n, m%n);
		}
	}

}
