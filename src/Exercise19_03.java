//Nuh Mohamud
import java.util.*;
public class Exercise19_03 {

	public static void main(String[] args) {
		//I made a quick thing to test this since this problem was just a function and the check tool seemed broken
		//It's so cool 
		ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 5, 5, 5, 6, 7, 7, 7, 8, 9));
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("hello", "hello", "world", "world"));
		System.out.println(removeDuplicates(ints).toString());
		System.out.println(removeDuplicates(strings).toString());
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> arr) {
		ArrayList<E> nonDuplicates = new ArrayList<E>();
		for(int i = 0; i < arr.size(); i++){
			if(!nonDuplicates.contains(arr.get(i))){
				nonDuplicates.add(arr.get(i));
			}
		}
		return nonDuplicates;
	}
}
