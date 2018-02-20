import java.util.*;
public class PerformanceTest {
	public static void main(String[] args) {
		getTime(1000);
		getTime(4000);
		getTime(16000);
		getTime(64000);
		getTime(256000);
	}   

	public static void getTime(long n) {
		long startTime = System.currentTimeMillis();
		long k = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				k = k + i + j;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time for n = " + n 
				+ " is " + (endTime - startTime) + " milliseconds");
	}
}

