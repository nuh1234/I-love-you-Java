
public class P6_2_6 {

	public static void main(String[] args) {
		isPalindrome(543);

	}
	public static boolean isPalindrome(int n){
		int first = n/100;
		int last = n%10;
		if(first == last){
			System.out.println("True");
			return true;
		}
		return false;
	}

}
