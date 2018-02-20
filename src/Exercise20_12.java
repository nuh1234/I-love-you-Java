//Nuh Mohamud
//Made the function didn't make the test
import java.util.*;
public class Exercise20_12 {

	public static void main(String[] args) {
	}
	
	class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {

		@Override
		public Object clone() {
			PriorityQueue<E> queue = new PriorityQueue<E>();
			for(E i : this) {
				queue.add(i);
			}
			return queue;
		}
	}

}
