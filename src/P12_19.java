//Nuh Mohamud
import java.util.*;
import java.io.*;
public class P12_19 {

	public static void main(String[] args) {
		int count = 0;
		Scanner in = null;
		try{
			in = new Scanner(new File("gettysburg.txt"));
			while(in.hasNext()){
				in.next();
				count++;
			}
			in.close();
			System.out.println("There are " + count + " words");
		}catch(IOException e){
			System.out.println("You've made a fatal error: " + e.getMessage());
		}
	}

}
