//Nuh Mohamud
import java.util.*;
public class HW6_1 {

	public static void main(String[] args) {
		final int N = 20;
		Data[] list = new Data[N];
		for (int i = 0; i < N; i++) {
			list[i] = new Data((int) (Math.random()*10), i);
		}
		System.out.println("Original list with number1:number2");
		print(list);
		quickSorta(list);
		System.out.println("Sorted list with number1:number2");
		print(list);
		checkResults(list);
	}

	public static void print(Data[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void checkResults(Data[] list) {
		boolean sorted = true;
		boolean stable = true;
		int lastKey = list[0].number1;
		int lastValue = list[0].number2;
		for (int i=1; i < list.length; i++) {
			if (list[i].number1 < lastKey)
				sorted = false;
			if (list[i].number1 != lastKey) {
				lastValue = list[i].number2;
			}
			if (list[i].number2 < lastValue && list[i].number1 == lastKey) {
				stable = false;

			}
			lastKey =  list[i].number1;
		}
		System.out.println("Sorted = " + sorted);
		System.out.println("Stable = " + stable);
	}
	public static void quickSorta(Data[] list) {
		quickSorta(list, 0, list.length -1);
	}

	public static void quickSorta(Data[] list, int low, int hi) {
		if(low < hi) {
			int index = partition(list, low, hi);
			quickSorta(list, low, index -1);
			quickSorta(list, index + 1, hi);
		}


	}
	public static int partition(Data[] list, int low, int hi) {
		ArrayList<Data> left = new ArrayList<>();
		ArrayList<Data> right = new ArrayList<>();
		Random rand = new Random();
		int index = rand.nextInt(hi - low) + low;
		Data pivot = list[index];

		for(int i = low; i <= index -1; i++){
			if(list[i].number1 <= pivot.number1){
				left.add(list[i]);
			}else{
				right.add(list[i]);
			}
		}

		for(int i = index +1; i <= hi; i++){
			if(list[i].number1 < pivot.number1){
				left.add(list[i]);
			}else{
				right.add(list[i]);
			}
		}

		int i = low;
		while(!left.isEmpty()) {
			list[i] = left.remove(0);
			i += 1;
		}
		list[i] = pivot;
		index = i;
		i += 1;
		while(!right.isEmpty()){
			list[i] = right.remove(0);
			i += 1;
		}

		return index;
	}

}

class Data {

	int number1;
	int number2;
	public Data(int n1, int n2){
		number1 = n1;
		number2 = n2;
	}
	@Override
	public String toString() {
		return "" + number1 + ":" + number2;
	}
}