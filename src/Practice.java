import java.util.*;
public class Practice {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer between 0 and 1000: ");
		int num = input.nextInt();
		int temp = num;
		int firstDigit = num % 10;
		num /= 10;
		int secondDigit = num % 10;
		num /= 10;
		int thirdDigit = num % 10;
		System.out.print("Sum of all digits in " + temp + " is "+ (firstDigit + secondDigit + thirdDigit));
		;
		
	}
	//merge 2 sorted lists
    public static ArrayList<Integer> mergeList(int[] list1, int[] list2) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        for(int i : list1) {
            mergedList.add(i);
        }
        for(int k : list2) {
            mergedList.add(k);
        }
        
        Collections.sort(mergedList);
        return mergedList;
    }
    
    public static ArrayList<Integer> mergeList2(int[] list1, int[] list2) {
        int list1Index = 0;
        int list2Index = 0;
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        while(list1Index < list1.length && list2Index < list2.length) {
            if(list1[list1Index] < list2[list2Index]) {
                mergedList.add(list1[list1Index]);
                list1Index += 1;
            } else {
                mergedList.add(list2[list2Index]);
                list2Index += 1;
            }
        }
        
        return mergedList;
    }
}
