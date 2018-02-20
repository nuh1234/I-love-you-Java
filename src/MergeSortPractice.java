
public class MergeSortPractice {

	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 12, 34, 5, 0, 7, 5, 3, 42, 100, 10000, -1};
		mergeSort(arr);
		for(int i : arr) {
			System.out.print(i + ", ");
		}
	}
	
	public static void mergeSort(int[] array) {
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length -1);
	}
	
	public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}else {
			int middle = (leftStart + rightEnd)/2; //different middle everytime
			mergeSort(array, temp, leftStart, middle);
			mergeSort(array, temp, middle + 1, rightEnd);
			mergeHalves(array, temp, leftStart, rightEnd);
		}
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int size = (rightEnd - leftStart) + 1;
		int leftEnd = (leftStart + rightEnd)/2; //middle
		int rightStart = leftEnd + 1; //middle + 1
		int index = leftStart;
		
		int left = leftStart;
		int right = rightStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			}else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		//LeftCopy 
		System.arraycopy(array, left, temp, index, (leftEnd - left) + 1); //how many are left
		//RightCopy Only one will ever be called
		System.arraycopy(array, right, temp, index, (rightEnd - right) + 1);
		//Copy Everything Back
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}

}
