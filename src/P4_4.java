//2B || !2B
import java.util.*;
public class P4_4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double s = input.nextDouble();
		double area = ((3.0 * Math.sqrt(3)) / (2.0)) * Math.pow(s, 2);
		System.out.println("The area of the hexagon is " + area);

	}

}
