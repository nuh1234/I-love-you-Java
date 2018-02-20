//Nuh Mohamud
//There wasn't an exercise check for this problem, it passed the test in the book however
import java.io.*;
import java.util.*;
public class Exercise_20_01 {

	public static void main(String[] args) {
		if(args.length > 0) {
			try {
				File text = new File(args[0]);
				Scanner read = new Scanner(text);
				System.out.println(arrayToString(sortText(read)));
				read.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("No commandline args");
		}
	}

	//This function sorts and prints out the text in a file
	public static ArrayList<String> sortText(Scanner read) {
		ArrayList<String> list = new ArrayList<String>();
		while(read.hasNext()) {
			list.add(read.next());
		}
		System.out.println("The words in the file are " + arrayToString(list));
		System.out.println("Display words in ascending order");
		Collections.sort(list);
		return list;
	}

	//This function takes a list and returns a single clean string
	public static String arrayToString(ArrayList<String> arr) { 
		String s = "";
		for(String word : arr) {
			s += word + " ";
		}
		return s;
	}


}
