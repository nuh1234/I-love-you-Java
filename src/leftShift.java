import java.util.Arrays;

public class leftShift {

	public static void main(String[] args) {
		int[] testArray = {1, 2, 3, 4, 5};
		String s = Arrays.toString(shift(testArray, 4)).replace(",", "") ;
		System.out.println(s);
	}

	public static int[] shift(int[] n, int shiftN) {
		int size = n.length - 1;
		
		for(int rotations = 0; rotations < shiftN; rotations++){
			int temp = n[0];
			for(int i = 0; i < size; i++){
				n[i] = n[i + 1];
			}
			n[size] = temp;
		}
		return n;
	}

}
