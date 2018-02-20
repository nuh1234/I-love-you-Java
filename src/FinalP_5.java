//Nuh Mohamud, Didn't test
import java.util.*;
public class FinalP_5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a sentence to translate: ");
		String s = in.next();
		while(in.hasNext()){
			
			if(firstVowel(s) == 0){
				
				System.out.print(s + "yay ");
				s = in.next();
			}
			else if(firstVowel(s) != 0){
				int index = firstVowel(s);
				System.out.print(s.substring(index, s.length()-1) + s.substring(0, index));
				s = in.next();
			}
		}
	}
	public static int firstVowel(String s){
		String temp = "";
		for(int i = 0; i < s.length(); i++){
			temp = s.charAt(i) + "";
			if(temp.equals("a") || temp.equals("e")|| temp.equals("i")|| temp.equals("o")|| temp.equals("u")|| temp.equals("y")){
				System.out.print(temp + " " + i);
				return i;
			}
		}
		return 0;
	}

}
