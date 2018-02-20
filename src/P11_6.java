import java.util.*;

//pegasus
//This Program uses a Loan and Circle Class that have not been included but the implementation of those classes is what the question asked for, so this won't run. 
//Also there isn't anything in the check tool for this program
public class P11_6 {

	public static void main(String[] args) {
		ArrayList n = new ArrayList<>();
		Date date = new Date();
		Loan loan = new Loan();
		Circle c = new Circle();
		n.add(date);
		n.add(loan);
		n.add(c);
		for(int i = 0; i < 2; i++){
		System.out.println(n.get(i).toString());
		}
	}

}
