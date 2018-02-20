import java.io.*;
import java.util.*;
public class IC3_4 {

	public static void main(String[] args) {
		Scanner input = null;
		PrintWriter write = null;
		File newFile = new File("FileIC3_4.txt");
		int n = 0;
		try{
			write = new PrintWriter(newFile);
			input = new Scanner(new File("numbers2.txt"));
			while(input.hasNext()){
				try{
					n = input.nextInt();
					System.out.println(n);
					write.println(n);
				}catch(InputMismatchException f){
					System.out.println("<<Not and integer>>");
					write.println("<<Not and integer>>");
					input.next();
				}
			}
			input.close();
			write.close();
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}
	}
}
