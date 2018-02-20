import java.util.*;

public class Exercise20_04 {

	public static void main(String[] args) {
		Point2D[] points = new Point2D[100];
		for(int i = 0; i < 100; i++) {
			points[i] = randomPoint();
		}
		System.out.println(Arrays.toString(points));
		Arrays.sort(points);
		System.out.println(Arrays.toString(points));
	}

	public static Point2D randomPoint() {
		int rX = (int)(Math.random()*11);
		int rY = (int)(Math.random()*11);
		return new Point2D(rX, rY);
	}

}

class Point2D implements Comparable<Point2D>{
	private int x;
	private int y;

	public Point2D(int x, int y) { 
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}


	@Override
	public int compareTo(Point2D o) {
		if(this.y != o.y) {
			if(this.y < o.y) {
				return -1;
			} else {
				return 1;
			}
		}else {
			if(this.x == o.x) {
				return 0;
			}else {
				if(this.x < o.x) {
					return -1;
				}else {
					return 1;
				}
			}
		}
	}
	@Override
	public String toString() {
		return "x:" + this.x + " , y:" + this.y;
	}

}