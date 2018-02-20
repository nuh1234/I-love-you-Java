
public class mergeSort2 {

	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 12, 34, 5, 0, 7, 5, 3, 42, 100, 10000, -1};
		mergeSort(arr);
		for(int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length -1, temp);
	}

	public static void mergeSort(int[] arr, int leftStart, int rightEnd, int[] temp) {
		if(leftStart >= rightEnd) {
			return;
		}else {
			int middle = (leftStart + rightEnd)/2;
			mergeSort(arr, leftStart, middle, temp);
			mergeSort(arr, middle + 1, rightEnd, temp);
			mergeHalves(arr, leftStart, rightEnd, temp);
		}

	}
	
	public static void mergeHalves(int[] arr, int leftStart, int rightEnd, int[] temp) {
		//left right index
		int size = rightEnd  - leftStart + 1;
		int leftEnd = (leftStart + rightEnd) /2;
		int rightStart = leftEnd + 1;
		int leftCount = leftStart;
		int rightCount = rightStart;
		int index = leftStart;
		
		while(leftCount <= leftEnd && rightCount <= rightEnd) {
			if(arr[leftCount] < arr[rightCount]) {
				temp[index] = arr[leftCount];
				leftCount++;
			}else {
				temp[index] = arr[rightCount];
				rightCount++;
			}
			index++;
		}
		//leftRight array copy
		System.arraycopy(arr, leftCount, temp, index, (leftEnd - leftCount) + 1);
		System.arraycopy(arr, rightCount, temp, index, (rightEnd - rightCount) + 1);
		
		//Copy all back
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}
}



