//Nuh Mohamud, Did not finish writing all methods
public class FinalP_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Segment{
	private double Left;
	private double Right;
	
	Segment(double x1, double x2){
		this.Left = x1;
		this.Right = x2;
	}
	public boolean contains(double x){
		for(double i = Left; i <= Right; i+= 0.1){
			if(i == x){
				return true;
			}
		}
		return false;
	}
	public boolean overlaps(Segment other){
		if()
	}
}
