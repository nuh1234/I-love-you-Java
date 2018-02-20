//Nuh Mohamud
//No Exercise check available but I think this works
import java.util.*;
public class Exercise_20_10 {

	public static void main(String[] args) {
		PriorityQueue<String> names1 = new PriorityQueue<String>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
		PriorityQueue<String> names2 = new PriorityQueue<String>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
		System.out.println("Queue 1: " + names1);
		System.out.println("Queue 2: " + names2);
		PriorityQueue<String> union = new PriorityQueue<String>(names1);
		PriorityQueue<String> diff = new PriorityQueue<String>(names1); 
		PriorityQueue<String> intersect = new PriorityQueue<String>(names1);
		
		for(String s: names2) {
			if(!union.contains(s)) {
				union.add(s);
			}
		}
		System.out.println("Union: " + union);
		
		intersect.retainAll(names2); //does almost the opposite of removeAll
		System.out.println("Intersection: " + intersect);
		
		diff.removeAll(names2);
		System.out.println("Difference: " + diff);
		
	}

}
 