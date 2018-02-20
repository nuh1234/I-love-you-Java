//Nuh Mohamud
public class InClass_02 { //I changed the class name 
	public static void main(String[] args){
		System.out.println("Running...");
		testBox();
		testGBox();
	}
	public static void testBox(){
		String item = "Demo string";
		Integer number = 1234;

		Box box1 = new Box();
		box1.set(item);
		Box box2 = new Box();
		box2.set(number);

		Integer b2 = (Integer) box2.get();
		String b1 = (String) box1.get();
		System.out.println("box1: " + b1 + "  box2: " + b2);
	}
	
	public static void testGBox(){
        String item = "Demo string";
        Integer number = 1234;
        
        GBox<String> box1 = new GBox(); //You need to finish this line
        box1.set(item);
        GBox<Integer> box2 = new GBox();; //You need to finish this line
        box2.set(number);
        
        Integer b2 = box1.get(); //You need to finish this line
        String b1 =  box2.get(); // You need to finish this line
        System.out.println("box1: " + b1 + "  box2: " + b2);
    }


}

//The Box class stores an object with set, and retrieves it with get().  It is 
//a box that can hold one object.
class Box {
	private Object object;

	public void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}
}

class GBox <T> {
	private T object;
	
	public void set(T object){
		this.object = object;
	}
	
	public T get() {
		return object;
	}
}


