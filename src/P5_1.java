//2B || !2B
import java.util.*;
public class P5_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integers ending with 0: ");
		int n = input.nextInt();
		int pos = 0;
		int neg = 0;
		int total = 0;
		while(n != 0){
			if(n < 0){
				neg++;
			}else{
				pos++;
			}
			total += n;
			n = input.nextInt();
		}
		System.out.println("The number of positives is " +pos);
		System.out.println("The number of negatives is " +neg);
		System.out.println("The total is "+ total);
		System.out.println("The average is " + (double)total/(neg+pos));

	}

}
