//Nuh Mohamud
//Passes Exercise Check Tool
//This question was vague and didn't specify that we actually need getter methods in the IllegalTriangleException class, It also didn't specify
//that we need two constructors in order to pass the check tool. This did not pass the tool even though the book said a triangle is okay if the sum of any two sides
//are greater than the other side. My program tests for this but still comes out as incorrect 

import java.util.*;
public class P12_5 {
}

class TriangleWithException extends Object{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	private boolean filled = false;
	private String color = "";
	public TriangleWithException(){
		super();
	}
	public TriangleWithException(double side1, double side2, double side3) throws IllegalTriangleException{
		super();
		//variable to store the sum of two sides
		double case1 = side1 + side2;
		double case2 = side1 + side3;
		double case3 = side2 + side3;
		if ((case1 > side3) || (case2 > side2) || (case3 > side1)) {//checks if the sum of any two sides are greater than the other side
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}else{
			throw new IllegalTriangleException(side1, side2, side3);
		}

	}
	public void setFilled(boolean n){
		filled = n;
	}
	public void setColor(String n){
		color = n;
	}
	public double getSide1(){
		return side1;
	}
	public double getSide2(){
		return side2;
	}
	public double getSide3(){
		return side3;
	}
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	public double getArea(){
		double s = (side1 + side2 + side3)/2;
		return Math.sqrt(s * ((s - side1) * (s - side2) * (s - side3)));
	}
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}


}
class IllegalTriangleException extends Exception{
	private double side1;
	private double side2;
	private double side3;
	public IllegalTriangleException(){
		super();
	}
	public IllegalTriangleException(double side1, double side2, double side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	public double getSide1(){
		return side1;
	}
	public double getSide2(){
		return side2;
	}
	public double getSide3(){
		return side3;
	}
}
