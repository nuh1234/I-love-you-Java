//Nuh Mohamud
//Passed All Tests on Exercise check tool
import java.util.*;

public class Excercise_18_02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an index for a Fibonacci number: ");
		long n = in.nextLong();
		System.out.println("The Fibonacci number at index " + n + " is " + fib(n));
		in.close();
	}

	public static long fib(long index) {
		if(index == 1) {
			return 1;
		} else {
			Long currentN = null;
			long f0 = 0;
			long f1 = 1;
			for(int i = 1; i < index; i++){
				currentN = f0 + f1;
				f0 = f1;
				f1 = currentN;	
			}
			return currentN == null ? 0: currentN;
		}
	}
}
