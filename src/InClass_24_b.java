//Nuh Mohamud
//Passed all tests in ProcessTestTemplate
//Ran Successfully in the TaskManager template 
public class InClass_24_b {

}
class Process {
	public String name;
	public long address;
	public long duration;
	public Process next;

	public Process(String name, long address, long duration){
		this.name = name;
		this.address = address;
		this.duration = duration;
	}



}

class ProcessQueue{
	private Process current;
	private int size;

	public ProcessQueue() {
		this.size = 0;
	}

	public void add(Process p) {
		if(size == 0) {
			this.current = p;
			current.next = current;
		} else {	
			p.next = current.next;
			current.next = p;
		}
		size += 1;
	}
	public boolean kill(String name) {
		if(size <= 1) {
			return false;
		}
		Process temp = current;
		int count = 0;
		while(count < size) {
			if(temp.name == name) {
				getPrevious().next = temp.next;
				current = temp.next;
				size -=1;
				return true;
			}
			count +=1;
			temp = temp.next;
		}
		return false;
	}

	public void change() {
		current = current.next;		
	}

	public Process current() {
		return this.current;

	}

	private Process getPrevious() {
		Process temp = current;
		int count = 0;
		while(count < size) {
			if(temp.next.name == current.name) {
				return temp;
			}
			temp = temp.next;
			count += 1;
		}
		//We needed a return
		return current;
	}
	public int size() {
		return size;
	}

}