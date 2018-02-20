//Pegasus
//Nuh
import java.util.*;

public class P11_12 {

	public static void main(String[] args) {
		System.out.println("Enter 5 numbers: ");
		Scanner input = new Scanner(System.in);
		ArrayList<Double> nums = new ArrayList<>();
		int count = 0;
		double n = 0;
		while(count < 5){
			n = input.nextDouble();
			nums.add(n);
			count++;
		}
		System.out.println("The sum of all numbers is: " + sum(nums));
	}
	public static double sum(ArrayList<Double> list){
		double sum = 0;
		for(int i = 0; i <= list.size() - 1; i++){
			sum += list.get(i);
		}
		return sum;
	}

}
