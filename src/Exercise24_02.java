//Nuh Mohamud
//Exercise check tool is obviously broken. 
//The String at index 5 (the 6th element) in the given list is Jean not George
//So no mine didn't pass in the tool but my code does work

import java.util.*;

public class Exercise24_02 {
	public static void main(String[] args) {
		new Exercise24_02();
	}

	public Exercise24_02() {
		String[] names = {"Tom", "Susan", "Kim", "George", "Peter", 
				"Jean", "George", "Jane", "Denise", "Jenny", "Kathy", "Jane"};
		MyList<String> list = new MyLinkedList<>(names);   

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a name: ");
		String name = input.next();

		System.out.print("Enter an index: ");
		int index = input.nextInt();

		System.out.println(list.contains(name));
		System.out.println(list.get(index));
		System.out.println(list.indexOf(name));
		System.out.println(list.lastIndexOf(name));
		list.set(index, name);

		System.out.println(list);
	}
}
class MyLinkedList<E> implements MyList<E> {
	private Node<E> head, tail;
	private int size = 0; // Number of elements in the list

	/** Create an empty list */
	public MyLinkedList() {
	}

	/** Create a list from an array of objects */
	public MyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]); 
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Create a new for element e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		}
		else {
			tail.next = newNode; // Link the new with the last node
			tail = newNode; // tail now points to the last node
		}

		size++; // Increase size
	}

	@Override /** Add a new element at the specified index 
	 * in this list. The index of the head element is 0 */
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		}
		else if (index >= size) {
			addLast(e);
		}
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/** Remove the head node and
	 *  return the object that is contained in the removed node. */
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		else {
			E temp = head.element;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp;
		}
	}

	/** Remove the last node and
	 * return the object that is contained in the removed node. */
	public E removeLast() {
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			E temp = head.element;
			head = tail = null;
			size = 0;
			return temp;
		}
		else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			E temp = tail.element;
			tail = current;
			tail.next = null;
			size--;
			return temp;
		}
	}

	@Override /** Remove the element at the specified position in this 
	 *  list. Return the element that was removed from the list. */
	public E remove(int index) {   
		if (index < 0 || index >= size) {
			return null;
		}
		else if (index == 0) {
			return removeFirst();
		}
		else if (index == size - 1) {
			return removeLast();
		}
		else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override /** Override toString() to return elements in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			}
			else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override /** Clear the list */
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override /** Return true if this list contains the element e */
	public boolean contains(Object e) {
		if(this.size < 1) {
			return false;
		}else {
			Node<E> temp = head;
			while(temp != null) {
				if(temp.element.equals(e)) {
					return true;
				}
				temp = temp.next;
			}
			return false;	
		}
	}

	@Override /** Return the element at the specified index */
	public E get(int index) {
		if(this.size < 1 || index < 0) {
			return null;
		}else {
			int count = 0;
			Node<E> temp = head;
			while(count < index) {
				temp = temp.next;
				count++;
			}
			return temp.element;
		}
	}

	@Override /** Return the index of the first matching element in 
	 *  this list. Return -1 if no match. */
	public int indexOf(Object e) {
		if(this.size < 1) {
			return -1;
		}else {
			int count = 0;
			Node<E> temp = head;
			while(count < this.size) {
				if(temp.element.equals(e)) {
					return count;
				}
				temp = temp.next;
				count++;
			}
			return -1;
		}
	}

	@Override /** Return the index of the last matching element in 
	 *  this list. Return -1 if no match. */
	public int lastIndexOf(E e) {
		if(this.size < 1) {
			return - 1;
		}else {
			int lastIndex = -1;
			int count = 0;
			Node<E> temp = head;
			while(count < this.size) {
				if(temp.element.equals(e)) {
					lastIndex = count;
				}
				temp = temp.next;
				count++;
			}
			return lastIndex;
		}
	}

	@Override /** Replace the element at the specified position 
	 *  in this list with the specified element. */
	public E set(int index, E e) {
		if(this.size < 1 || index > this.size -1 || index < 0) {
			return null;
		}else {
			int count = 0;
			Node<E> temp = head;
			while(count < index) {
				temp = temp.next;
				count++;
			}
			return temp.element = e;
		}
	}

	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator 
	implements java.util.Iterator<E> {
		private Node<E> current = head; // Current index 

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			// Left as an exercise
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	@Override /** Return the number of elements in this list */
	public int size() {
		return size;
	}
}
interface MyList<E> extends java.util.Collection<E> {
	/** Add a new element at the specified index in this list */
	public void add(int index, E e);

	/** Return the element from this list at the specified index */
	public E get(int index);

	/** Return the index of the first matching element in this list.
	 *  Return -1 if no match. */
	public int indexOf(Object e);

	/** Return the index of the last matching element in this list
	 *  Return -1 if no match. */
	public int lastIndexOf(E e);

	/** Remove the element at the specified position in this list
	 *  Shift any subsequent elements to the left.
	 *  Return the element that was removed from the list. */
	public E remove(int index);

	/** Replace the element at the specified position in this list
	 *  with the specified element and returns the new set. */
	public E set(int index, E e);

	@Override /** Add a new element at the end of this list */
	public default boolean add(E e) {
		add(size(), e);
		return true;
	}

	@Override /** Return true if this list contains no elements */
	public default boolean isEmpty() {
		return size() == 0;
	}

	@Override /** Remove the first occurrence of the element e 
	 *  from this list. Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public default boolean remove(Object e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}

	@Override
	public default boolean containsAll(Collection<?> c) {
		// Left as an exercise
		return false;
	}

	@Override
	public default boolean addAll(Collection<? extends E> c) {
		boolean added = true;
		for(E element : c) {
			added = this.add(element);
		}
		return added;
	}

	@Override
	public default boolean removeAll(Collection<?> c) {
		boolean removed = true;
		for(Object element : c) {
			removed = this.remove(element);
		}
		return true;
	}

	@Override
	public default boolean retainAll(Collection<?> c) {
		boolean retained = true;
		int i = size() - 1;
		while(i >= 0) {
			if(!c.contains(this.get(i))) {
				this.remove(i);
			}
			i--;
		}
		return retained;
	}

	@Override
	public default Object[] toArray() {
		if(this.size() < 1) {
			return null;
		}else {
			Object[] arr = new Object[this.size()];
			for(int i = 0; i < this.size(); i++) {
				arr[i] = this.get(i);
			}
			return arr;
		}
	}

	@Override
	public default <T> T[] toArray(T[] array) {
		if(this.size() < 1){
			return null;
		}else if(this.size() <= array.length) {
			for(int i = 0; i < this.size(); i++) {
				array[i] = (T) this.get(i);
			}
			return array;
		} else {
			T[] newArray = (T[]) new Object[this.size()];
			for(int i = 0; i < this.size(); i++) {
				newArray[i] = (T) this.get(i);
			}
			return newArray;
		}
	}
}


