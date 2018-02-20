//2B || !2B
import java.util.*;
public class P4_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
		double lat1 = Math.toRadians(input.nextDouble()); //converting to radians
		double lon1 = Math.toRadians(input.nextDouble());
		System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
		double lat2 = Math.toRadians(input.nextDouble());
		double lon2 = Math.toRadians(input.nextDouble());
		double radius = 6371.01; //radius of the earth
		double distance = radius * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
		System.out.println("The distance between the two point is "+ distance + " km");
	}

}
