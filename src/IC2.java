import java.io.*;
import java.util.*;
public class IC2 {

	public static void main(String[] args) {
		Scanner input = null;
		try{
			input = new Scanner(new File("hnumbers2.txt"));
			while(input.hasNext()){
				System.out.println(input.nextInt());
			}
			input.close();
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}catch(InputMismatchException f){
			System.out.println("invalid integer: " + f.getMessage());
			input.close();
		}

	}

}
