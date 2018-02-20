/*Nuh Mohamud
 * QuadraticEquation
 * a: double
 * b: double
 * c: double
 * ------------------------
 * +QuadraticEquation(a: double, b: double, c: double)
 * +getA(): double
 * +getB(): double
 * +getC(): double
 * +getDiscriminant(): double
 * +getRoot1(): double
 * +getRoot2(): double
 */
import java.util.*;
public class p9_10 {

	public static void main(String[] args) {
		double a = 0;
		double b = 0;
		double c = 0;
		System.out.println("Enter a, b, and c: ");
		Scanner input = new Scanner(System.in);
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		QuadraticEquation qe = new QuadraticEquation(a,b,c);
		double discriminant = qe.getDiscriminant();
		if(discriminant < 0){
			System.out.println("The equation has no roots");
		}else if(discriminant == 0){
			System.out.println("The equation has one root " + qe.getRoot1());
		}else{
			System.out.println("The equation has two roots " + qe.getRoot1() + "and" + qe.getRoot2());
		}
	}

}
class QuadraticEquation{
	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA(){
		return a;
	}
	public double getB(){
		return b;
	}
	public double getC(){
		return c;
	}
	public double getDiscriminant(){
		return (b*b) - (4*a*c); 
	}
	public double getRoot1(){
		if(getDiscriminant() < 0){
			return 0;
		}else{
			return ((-b + Math.sqrt((b*b) - (4*a*c)))) / (2*a);
		}
	}
	public double getRoot2(){
		if(getDiscriminant() < 0){
			return 0;
		}else{
			return ((-b - Math.sqrt((b*b) - (4*a*c)))) / (2*a);
		}
	}
}
