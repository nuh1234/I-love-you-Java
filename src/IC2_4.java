import java.io.*;
import java.util.*;
public class IC2_4 {

	public static void main(String[] args) {
		Scanner input = null;
		PrintWriter write = null;
		File newFile = new File("FileIC2_4.txt");
		int n = 0;
		try{
			write = new PrintWriter(newFile);
			input = new Scanner(new File("hnumbers2.txt"));
			while(input.hasNext()){
				n = input.nextInt();
				System.out.println(n);
				write.println(n);
			}
			input.close();
			write.close();
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}catch(InputMismatchException f){
			System.out.println("invalid integer: " + f.getMessage());
			input.close();
			write.println("invalid integer: " + f.getMessage());
			write.close();
		}

	}

}
