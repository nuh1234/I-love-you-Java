import java.util.*;

public class P11_4 {
	public static void main(String[] args){
		int n = 0;
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("Enter a list of numbers: ");
		n = input.nextInt();
		while(n != 0){
			list.add(n);
			n = input.nextInt();
		}
		System.out.println("Max is: " + max(list));
	}

	public static Integer max(ArrayList<Integer> list){
		int max = 0;
		for(int i = 0; i < list.size() -1; i++){
			if(list.get(i) > max){
				max = list.get(i);
			}
		}
		return max;
	}
}