//Nuh Mohamud
//Exercise check tool was broken for me. Did not let me see my output at all. Complied successfully in the check tool
//but the automatic check button wouldn't work.
//My program successfully sorted both lists as you can see from the output

import java.util.*;

public class Exercise_20_21 {

	public static void main(String[] args) {
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
				new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};

		//This portion here is from the check tool, since I was trying to match the check tool output exactly I kept it the same
		selectionSort(list, new GeometricObjectComparator());
		for (GeometricObject g: list) {
			System.out.print(g.getArea() + " ");
		}
		System.out.println();

		String[] list2 = {"red", "blue", "green", "yellow", "orange", "pink"};
		//This closure is from the check tool and it doesn't work at all. I made my own comparator class below this however
		//selectionSort(list2, (s1, s2) -> { 
		//return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
		//})
		selectionSort(list2, new StringLastLetterComparator()); //Using my own comparator, which  works
		for (String s: list2) {
			System.out.print(s + " ");    
		}


	}

	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
		for(int i = 0; i < list.length - 1; i++) {
			E min = list[i];
			int indexOfMin = i;
			for(int j = i + 1; j < list.length; j++) {
				if(comparator.compare(list[j], min) == -1) {
					min = list[j];
					indexOfMin = j;
				}
				// 
			}

			E actualMinValue = list[indexOfMin];
			list[indexOfMin] = list[i];
			list[i] = actualMinValue;
		}
	}


}

//I made my own comparator for comparing the last letter of a string
class StringLastLetterComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		char c1 = o1.charAt(o1.length() - 1);
		char c2 = o2.charAt(o2.length() - 1);
		if(c1 < c2) {
			return -1;
		} else if (c1 == c2) {
			return 0;
		}else {
			return 1;
		}
	}

}

class GeometricObjectComparator implements Comparator<GeometricObject>, java.io.Serializable {
	public int compare(GeometricObject o1, GeometricObject o2) {
		double area1 = o1.getArea();
		double area2 = o2.getArea();

		if (area1 < area2)
			return -1;
		else if (area1 == area2)
			return 0;
		else
			return 1;
	}
}

//GeometricObject From Canvas
abstract class GeometricObject {
	private String color = "white";
	private boolean filled;

	/**Default construct*/
	protected GeometricObject() {
	}

	/**Construct a geometric object*/
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	/**Getter method for color*/
	public String getColor() {
		return color;
	}

	/**Setter method for color*/
	public void setColor(String color) {
		this.color = color;
	}

	/**Getter method for filled. Since filled is boolean,
  so, the get method name is isFilled*/
	public boolean isFilled() {
		return filled;
	}

	/**Setter method for filled*/
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**Abstract method findArea*/
	public abstract double getArea();

	/**Abstract method getPerimeter*/
	public abstract double getPerimeter();
}




class Rectangle extends GeometricObject {
	private double width;
	private double height;

	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/** Return width */
	public double getWidth() {
		return width;
	}

	/** Set a new width */
	public void setWidth(double width) {
		this.width = width;
	}

	/** Return height */
	public double getHeight() {
		return height;
	}

	/** Set a new height */
	public void setHeight(double height) {
		this.height = height;
	}

	/** Return area */
	public double getArea() {
		return width * height;
	}

	/** Return perimeter */
	public double getPerimeter() {
		return 2 * (width + height);
	}
}


//Circle.java: The circle class that extends GeometricObject
class Circle extends GeometricObject {
	private double radius;

	/**Default constructor*/
	public Circle() {
		this(1.0);
	}

	/**Construct circle with a specified radius*/
	public Circle(double radius) {
		this(radius, "white", false);
	}

	/**Construct a circle with specified radius, filled, and color*/
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	/**Return radius*/
	public double getRadius() {
		return radius;
	}

	/**Set a new radius*/
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**Implement the getArea method defined in GeometricObject*/
	public double getArea() {
		return radius*radius*Math.PI;
	}

	/**Implement the getPerimeter method defined in GeometricObject*/
	public double getPerimeter() {
		return 2*radius*Math.PI;
	}

	/**Override the equals() method defined in the Object class*/
	public boolean equals(Circle circle) {
		return this.radius == circle.getRadius();
	}

	@Override 
	public String toString() {
		return "[Circle] radius = " + radius;
	}
}


class SelectionSort {
	/** Main method */
	public static void main(String[] args) {
		// Initialize the list
		double[] myList = {5.0, 4.4, 1.9, 2.9, 3.4, 3.5};

		// Print the original list
		System.out.println("My list before sort is: ");
		printList(myList);

		// Sort the list
		selectionSort(myList);

		// Print the sorted list
		System.out.println();
		System.out.println("My list after sort is: ");
		printList(myList);
	}

	/** The method for printing numbers */
	static void printList(double[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + "  ");
		System.out.println();
	}

	/** The method for sorting the numbers */
	static void selectionSort(double[] list) {
		for (int i = list.length - 1; i >= 1; i--) {
			// Find the maximum in the list[0..i]
			double currentMax = list[0];
			int currentMaxIndex = 0;

			for (int j = 1; j <= i; j++) {
				if (currentMax < list[j]) {
					currentMax = list[j];
					currentMaxIndex = j;
				}
			}

			// Swap list[i] with list[currentMaxIndex] if necessary;
			if (currentMaxIndex != i) {
				list[currentMaxIndex] = list[i];
				list[i] = currentMax;
			}
		}
	}
}


