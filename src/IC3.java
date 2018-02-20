import java.io.*;
import java.util.*;
public class IC3 {

	public static void main(String[] args) {
		Scanner input = null;
		try{
			input = new Scanner(new File("numbers2.txt"));
			while(input.hasNext()){
				try{
					System.out.println(input.nextInt());
				}catch(InputMismatchException f){
					System.out.println("<<Not and integer>>");
					input.next();
				}
			}
			input.close();
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}
	}
}
