
public class P10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MyInteger{
	private int value;
	public MyInteger(int n){
		value = n;
	}
	public int getValue(){
		return value;
	}
	public boolean isEven(){
		return value % 2 == 0;
	}
	public boolean isOdd(){
		return value % 2 != 0;
	}
	public boolean isPrime(){
		int n = Math.sqrt(value);
		for(int i = 2; i < n; i++){
			if(value % i == 0){
				return false;
			}
		}
		return true;
	}
	public boolean isEven(int n){
		return n % 2 == 0;
	}
	public boolean isOdd(int n){
		return n % 2 != 0;
	}
	public boolean isPrime(int j){
		int n = Math.sqrt(j);
		for(int i = 2; i < n; i++){
			if(j % i == 0){
				return false;
			}
		}
		return true;
	}

}
