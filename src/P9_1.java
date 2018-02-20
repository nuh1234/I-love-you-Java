/*Nuh Mohamud
 * Rectangle
 * width: double
 * height: double
 * ------------------------
 * +Rectangle()
 * +Rectangle(width: double, height: double)
 * +getArea(): double
 * +getPerimeter(): double
 */
public class P9_1 {

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(4, 40);
		System.out.println(rect1.width);
		System.out.println(rect1.height);
		System.out.println(rect1.getArea());
		System.out.println(rect1.getPerimeter());
		Rectangle rect2 = new Rectangle(3.5, 35.9);
		System.out.println(rect2.width);
		System.out.println(rect2.height);
		System.out.println(rect2.getArea());
		System.out.println(rect2.getPerimeter());
	}


}

class Rectangle{
	public double width = 1;
	public double height = 1;
	
	public Rectangle(){
		
	}
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public double getArea(){
		return width*height;
	}
	public double getPerimeter(){
		return (width*2) + (height*2);
	}
}
