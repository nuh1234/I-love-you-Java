/*Nuh Mohamud
 * Works but may not fit description of the question. The Exercise check tool was no help. The program does compile
 * and accomplish the task for creating a queue and removing from the queue.
 * Queue
 * elements: int[]
 * size: int
 * ------------------------
 * +Queue()
 * +Queue(int)
 * +enqueue(int v)
 * +dequeue() : int
 * +empty : boolean
 * +getSize : int
 */
public class P10_10 {
	public static void main(String[] args){
		Queue n = new Queue(20);
		for(int i = 1; i <= 20; i++){
			n.enqueue(i);
		}
		System.out.println();
		for(int j = 0; j <= 20; j++){
			n.dequeue();
		}
	}
	
	
}

class Queue {
	private int[] elements;
	private int size;
	public Queue(){
		this.elements = new int [8];
	}
	public Queue(int n){
		this.elements = new int [n];
	}
	public void enqueue(int v){
		for(int i = 0; i < elements.length; i++){
			if(elements[i] == 0){ 
				elements[i] = v; 
				break;
			}
		}
	}
	public int dequeue(){
		int temp = elements[0];
		elements[0] = 0;
		for(int i = 0; i < elements.length - 1; i++){
			elements[i] = elements[i+1];
		}
		//elements = new int[elements.length - 1];
		return temp;
		
	}
	public int getSize(){
		return elements.length;
	}
	public boolean empty(){
		return (elements.length == 0);
	}
	
}
