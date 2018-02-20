//Nuh Mohamud
//This Program shuffles without loosing any numbers
import java.util.*;
public class P11_7 {

	public static void main(String[] args) {
		//Test Program to show shuffling works
		ArrayList<Integer> n = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println(n.toString());
		shuffle(n);
		System.out.println(n.toString());

	}
	public static void shuffle(ArrayList<Integer> list){
		Random rand = new Random();
		int temp = 0;
		int len = list.size() - 1;
		int r = rand.nextInt(len + 1);
		for(int i = 0; i <= len; i++){
			//checks if the random index is the same as the loop index
			if(i != r){
				temp = list.get(i);
				//these statements switch the value of the index at i with with value at the random index 
				list.set(i, list.get(r));
				list.set(r, temp);
				r = rand.nextInt(len + 1);
			}else{
				r = rand.nextInt(len + 1);
			}
		}
	}

}
