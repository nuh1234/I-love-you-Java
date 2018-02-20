//Nuh Mohamud
//Submitted/Passed on Repl
import java.util.*;
public class ReplProblem {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		String text = "For smart people like me it is better to use your brain";
		map.put("smart", "intelligent");
		map.put("use", "utilize");
		map.put("me", "the World Champion");
		System.out.println(substitute(map, text));
	}

	public static String substitute(Map<String,String> map, String text){
		String s = "";
		Scanner read = new Scanner(text);
		while(read.hasNext()) {
			String currentString = read.next();
			if(map.containsKey(currentString)) {
				s += map.get(currentString) + " ";
			} else {
				s += currentString + " ";
			}

		}
		read.close();
		return s.trim();
	}
}