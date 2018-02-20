//Nuh Mohamud
//Passed Exercise check tool
import java.util.*;
public class Exercise21_01 {

	public static void main(String[] args) {
		Set<String> names1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
		Set<String> names2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
		
		Set<String> union = new LinkedHashSet<>();
		Set<String> difference = new LinkedHashSet<>(names1);
		Set<String> intersection = new LinkedHashSet<>(names1);

		union.addAll(names1);
		union.addAll(names2);
		System.out.println("The union of the two sets is " + union.toString());
		
		difference.removeAll(names2);
		System.out.println("The difference between the two sets is " + difference.toString());
		
		intersection.retainAll(names2);
		System.out.println("The intersection of the two sets is " + intersection.toString());
	}

}
