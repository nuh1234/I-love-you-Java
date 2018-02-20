
public class Repl3 {

	public static void main(String[] args) {
		//int[] list = new int[]{1, 2, 4, 5, 1, 2, 3, 1};
		int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(countDiff(list, 4));
	}

	public static int countDiff(int[] list, int diff){
		//Implement your countDiff method here.
		//If you need to make helper methods add them below (still inside this class)
		return listSplit(list, diff, list.length - 1, 1); //left side of the list //right side of the list

	}

	public static int listSplit(int[] list, int diff, int high, int low) {
		int count = 0;
		int middle = (high + low)/2;
		System.out.println("High: " + high + " Low: "+low);
		if(high == low){
			System.out.println("INDEX OF: " + list[high]);
			if(list[high] - list[high - 1] == diff) {
				return 1;
			}else if(list[high] - list[high - 1] == -diff)  {
				System.out.println("Block reached");
				return 1;
			} 
			return 0; //something else
		}else {
			int right = listSplit(list, diff, high, ((middle) + 1));
			int left = listSplit(list, diff, middle, low);
			count += right + left;
		}
		return count;
	}

}



