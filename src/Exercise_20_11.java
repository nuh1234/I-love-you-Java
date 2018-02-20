//Nuh Mohamud
//Tested with the the example given on canvas, passed
import java.util.*;
import java.io.*;
public class Exercise_20_11 {

	public static void main(String[] args) {
		if(args.length > 0) {
			try {
				File f = new File(args[0]);
				String text = "";
				Scanner scanFile = new Scanner(f);
				while(scanFile.hasNextLine()) {
					text += scanFile.nextLine() + " ";
				}
				scanFile.close();
				StringTokenizer tokens = new StringTokenizer(text, "[](){}", true);
				stringTokens(tokens);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			} 
		} else {
			System.out.println("No Command Line Args");
		}
	}

	public static void stringTokens(StringTokenizer tokens) {
		Stack<String> words = new Stack<String>(); 
		ArrayList<String> openDelimeter = new ArrayList<String>(Arrays.asList("[", "(", "{"));
		ArrayList<String> closeDelimeter = new ArrayList<String>(Arrays.asList("]", ")", "}"));
		while(tokens.hasMoreTokens()) {
			String temp = tokens.nextToken();
			System.out.println(temp);
			if(openDelimeter.contains(temp)) {
				System.out.println(words.push(tokens.nextToken()));
			}else if(closeDelimeter.contains(temp)) {
				words.pop();
			}
		}	
	}
}
