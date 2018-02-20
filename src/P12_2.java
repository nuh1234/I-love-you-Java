//Nuh
//Pegasus
import java.util.*;

public class P12_2 {

	public static void main(String[] args) {
		System.out.println("Enter two integers: ");
		boolean successful = false;
		Integer n = 0;
		Integer n2 = 0;
		Scanner input = new Scanner(System.in);
		while(!successful){
			try{
				n = Integer.parseInt(input.next());
				n2 = Integer.parseInt(input.next());
				System.out.println(n + " + " + n2 + " = " + (n + n2));
				successful = true;
			}catch(Exception e){
				successful = false;
				input.nextLine();
				System.out.println("Enter again: ");
				n = 0;
				n2 = 0; 
			}
		}
	}

}
