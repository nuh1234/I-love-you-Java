//Nuh Mohamud
import java.util.*;
public class Midterm2_Q3 {

	public static void main(String[] args) {
		int n = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: ");
		n = in.nextInt();
		System.out.println("The end 0 end is: " + endZeroEnd(n));
		in.close();
	}
	public static int getLast(int n){
		return n%10;
	}
	public static int getFirst(int n){
		while(n > 10){
			n /= 10;
		}
		return n;
	}
	public static int endZeroEnd(int n){
		int first = getFirst(n);
		int last = getLast(n);
		return (first*100) + last;
	}

}
