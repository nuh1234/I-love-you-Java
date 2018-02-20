//Nuh Mohamud
//The recursive function is supposed to break so I commented out the call for it
public class P_18_3 {

	public static void main(String[] args) {
		//Below I have written a for loop that generates an extremely long string of "s"
		//Technically this still a palindrome but the recursive function breaks with a stackoverflow error
		//I suspect this is because there is a limit to how many things you can add to a stack, 
		//probably limited by how much memory you have. The loop version doesn't break because it isn't modifying the stack
		//PS: Takes a bit to finish running but I had to do this in order to prove my theory
		String a = "";
		for(int n = 0; n < (1000000000 * 100000); n += 1000){
			a = a + "s";
		}
		System.out.println("Loop function s is:");
		System.out.println(isPalindromeLoop(a));
		//System.out.println("Recrusive function s is:");
		//System.out.println(isPalindrome(a));
		System.out.println("Done");
	}

	//The following is DR.Z's code, all credit to the honorable Zupke
	public static boolean isPalindromeLoop(String s) {
		// The index of the first character in the string
		int low = 0;

		// The index of the last character in the string
		int high = s.length() - 1;

		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				return false; // Not a palindrome
			}
			low++;
			high--;
		}

		return true; // The string is a palindrome
	}
	//Recursive 
	 public static boolean isPalindrome(String s) {
		 if(s.length() <= 1) {
			 return true;
		 }else if(s.charAt(0) != s.charAt(s.length() -1)) {
			 return false;
		 }else {
			 return isPalindrome(s.substring(1, s.length() -1));
		 }
	 }

}
