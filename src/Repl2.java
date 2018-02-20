//Nuh Mohamud
//Passed on Repl
import java.util.*;
public class Repl2 {
	public static HashMap<Integer, Long> map = new HashMap<>();
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			long temp = drz(i);
			System.out.println(temp);
		}		
	}
	
	public static long drz(int n) {
		if(n == 1) {
			return 3;
		}else if(n == 2) {
			return 1;
		}else if(n == 3) {
			return 2;
		}else if(map.containsKey(n)){
			return map.get(n);
		}else{
			map.put(n, -drz(n - 1) - drz(n -2) + drz(n - 3));
			return map.get(n);
		}
	}
}


