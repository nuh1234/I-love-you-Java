/*
 * Nuh Mohamud
 */
import java.util.*;
public class P9_3 {
	public static void main(String[] args){
		Date n = new Date();
		long i = 10000L;
		while(i <= 1.0*Math.pow(10, 11)){
			n.setTime(i);
			System.out.println(n.toString());
			i*=10;
			
		}
		
	}
}

