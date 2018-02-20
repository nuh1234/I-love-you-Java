//Nuh Mohamud
//After testing with a big number, both functions crash with a stack overflow error when I try it
//I might be getting a different result because I'm using eclipse, so this isn't the most scientific test
//But according to the code I wrote, there seems to be no optimizing 
public class TailRecursionProof {

	public static void main(String[] args) {
		System.out.println("Non Tail Recursion : " + nonTailRecursion(50));
		System.out.println("Tail Recursion : " + tailRecursion(50, 0));
		System.out.println("The output of these should be exactly the same, 1275. Proof the functions behave identically. But now I'm going to try a very large number.... and it crashed");
		long veryLargeN = (int)Math.pow(9, 5);
		System.out.println("Tail Recursion : " + tailRecursion(veryLargeN, 0));
		System.out.println("Non Tail Recursion : " + nonTailRecursion(veryLargeN));		
	}
	
	//This function isn't tail recursive because it's computing an add operation before the recursive call
	public static long nonTailRecursion(long n) {
		if(n <= 0) {
			return 0; 
		} else {
			return n + nonTailRecursion(n - 1);
		}
	}
	
	//This method serves the same purpose as the one above, expect that there no operations before the recursive call, everything takes place in the call
	public static long tailRecursion(long n, long total) {
		if(n <= 0) {
			return total;
		}else {
			return tailRecursion(n - 1, total + n);
		}
		
	}

}
