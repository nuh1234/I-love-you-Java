//Nuh Mohamud
import java.util.*;
public class Midterm2_Q1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		System.out.print("Enter a positive integer: ");
		n = in.nextInt();
		while(n != 1){
			n = syr(n);
			System.out.print(n + " ");
		}
		in.close();
	}

	public static int syr(int n){
		if(n % 2 == 0){
			return n/2;
		}else{
			return (3*n) + 1;
		}
	}

}
