import java.util.*;
public class p11_13 {

	public static void main(String[] args) {
		System.out.println("Enter 10 digits: ");
		int count = 0;
		int n = 0;
		ArrayList nums = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		while(count < 9){
			n = in.nextInt();
			nums.add(n);
			count++;
		}
		removeDuplicate(nums);
		System.out.println(nums.toString());
	}
	public static void removeDuplicate(ArrayList<Integer> list){
		ArrayList<Integer> oldnums = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++){
			if(oldnums.contains(list.get(i))){
				list.remove(list.get(i));
			}else{
				oldnums.add(list.get(i));
			}
		}
	}
}
