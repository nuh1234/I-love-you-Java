//Nuh Mohamud
//Passed the Exercise check tool, the check tool only had a single test 
import java.util.*;
public class Exercise18_15 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String word = in.nextLine();
		System.out.println("Enter a character: ");
		String character = in.next();
		char c = character.charAt(0);
		System.out.println(c + " appears " + count(word, c) + " times in " + word);
		in.close();
	}

	public static int count(String s, char c, int high) {
		if(high < 0){
			return 0;
		} else if(s.charAt(high) == c) {
			return 1 + count(s, c, high -1);
		} else {
			return count(s, c, high - 1);
		}
	}
	
	public static int count(String s, char c) {
		return count(s, c, s.length() - 1);
	}
}
