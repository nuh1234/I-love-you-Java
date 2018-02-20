import java.io.*;
import java.util.*;
public class IC1 {

	public static void main(String[] args) {
		Scanner input = null;
		try{
			input = new Scanner(new File("numbers.txt"));
			while(input.hasNext()){
				System.out.println(input.nextInt());
			}
			input.close();
		}catch(IOException e){
			System.out.println("Some problem reading file: " + e.getMessage());
		}

	}

}
