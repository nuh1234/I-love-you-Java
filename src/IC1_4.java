import java.io.*;
import java.util.*;
public class IC1_4 {

	public static void main(String[] args) {
		Scanner input = null;
		PrintWriter writer = null;
		int n = 0;
		File f = new File("newFile.txt");
		try{
			writer = new PrintWriter(f);
			input = new Scanner(new File("numbers.txt"));
			while(input.hasNext()){
				n = input.nextInt();
				System.out.println(n);
				writer.println(n);
			}
			input.close();
			writer.close();
			System.out.println("Copied file below : ");
			input = new Scanner(f);
			while(input.hasNext()){
				System.out.println(input.next());
			}
			
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}

	}

}
