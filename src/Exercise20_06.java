import java.util.*;
public class Exercise20_06 {

	public static void main(String[] args) {
		LinkedList<Integer> huge = new LinkedList<Integer>();
		for(int i = 0; i <= 5000000; i++) {
			huge.add(i);
		}
		//Iterator Example
		Iterator it = huge.iterator();
		double startIterator = System.currentTimeMillis();
		while(it.hasNext()){
			it.next();
		}
		double endIterator = System.currentTimeMillis();
		//Get example
		double startGet = System.currentTimeMillis();
		for(int k = 0; k < huge.size(); k++) {
			huge.get(k);
		}
		double endGet = System.currentTimeMillis();
		
		System.out.println("Iterator took " + (endIterator - startIterator) + " seconds");
		System.out.println(".Get took " + (endGet - startGet) + " seconds");
	}

}
