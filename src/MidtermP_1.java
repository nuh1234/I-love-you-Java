//Nuh Mohamud
import java.util.*;
public class MidtermP_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lowerCase = 0;
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) <= 122 && s.charAt(i) >= 97){
				lowerCase++;
			}
		}
		System.out.println("There are " + lowerCase + " lowercase letters in " + s);
	}

}
