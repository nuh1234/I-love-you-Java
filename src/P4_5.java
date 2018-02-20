//2B || !2B
import java.util.*;
public class P4_5 {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the number of sides: ");
	int sides = input.nextInt();
	System.out.print("Enter the side: ");
	double length = input.nextDouble();
	double area = (sides * Math.pow(length, 2))/ (4 * (Math.tan(Math.PI/sides)));
	System.out.println("The area of the polygon is " + area);
	}

}
