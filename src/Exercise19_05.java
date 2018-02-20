//Nuh Mohamud
//Passed the exercise check tool
import java.util.Arrays;

public class Exercise19_05 {
	public static void main(String[] args) {
		Integer[] numbers = {1, 2, 3};
		System.out.println(max(numbers));

		String[] words = {"red", "green", "blue"};
		System.out.println(max(words));

		Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
		System.out.println(max(circles));
	}

	static class Circle implements Comparable <Circle> {

		double radius;

		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public int compareTo(Circle c) {
			if (radius < c.radius) {
				return -1;
			} else if (radius == c.radius) {
				return 0;
			} else {
				return 1;
			}
		}

		@Override
		public String toString() {
			return "Circle radius: " + radius;
		}
	}

	
	public static <E extends Comparable <E>> E max(E[] arr) {
		E max = arr[0];
		for(E n: arr){
			if(n.compareTo(max) > 0){
				max = n;
			}
		}
		return max;
	}
	//Put in your max method here
	//it should have a function header similar to the max method in the
	//MaxUsingGenericType.java example (Listing 19.6 in the physical book)
}
