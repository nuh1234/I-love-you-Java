import java.util.*;
//Group C:
//Train was not completed, car was completed
interface CanRoll {
	public abstract void goForward(double speed);
	public abstract void goBackward(double speed);
}
interface CanTurn{
	public abstract void goRight();
	public abstract void goLeft();
}
interface HasSegments{
	public abstract int count();
}
public class Car implements CanRoll, CanTurn, Comparable<Object>{
	double speed;
	int direction;
	public Car(){
		this.speed = 0;
		this.direction = 0;
	}
	public Car(double speed, int direction){
		this.speed = speed;
		this.direction = direction;
	}
	public void goForward(double speed){
		this.speed += speed;
	}
	public void goBackward(double speed){
		this.speed -= speed;
	}
	public void goRight(){
		this.direction += 1;
	}
	public void goLeft(){
		this.direction -= 1;
	}
	@Override
	public Object clone(){
		return new Car(this.speed, this.direction);
	}
	@Override
	public int compareTo(Object o) throws ClassCastException{
		if(o instanceof Car){
			if (((Car) o).speed > speed){
				return 1;
			}else if (((Car) o).speed == speed){
				return 0;
			}else{ 
				return -1;
			}
		}else{
			throw new ClassCastException("Not Same Object"); 
		}

	}
}
class Train implements CanRoll, HasSegments{
	double speed;
	int segments;
	ArrayList<Car> train = new ArrayList<Car>();
	public Train(){
		this.speed = 0;
		this.segments = 0;
	}
	public Train(double speed, int segments){
		this.speed = speed;
		this.segments = segments;
	}
	public void goForward(double speed){
		this.speed += speed;
	}
	public void goBackward(double speed){
		this.speed -= speed;
	}
	public int count(){
		return this.segments;
	}
}

