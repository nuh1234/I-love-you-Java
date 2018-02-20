//Nuh Mohamud
//Passed Exercise Check tool
import java.util.*;
public class Exercise24_03 {
	public static void main(String[] args) {
		new Exercise24_03();
	}

	public Exercise24_03() {
		TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
		System.out.print("Enter 5 integers: ");
		Scanner input = new Scanner(System.in);
		double[] v = new double[5];
		for (int i = 0; i < 5; i++) 
			v[i] = input.nextDouble();

		list.add(v[1]);
		list.add(v[2]);
		list.add(v[3]);
		list.add(v[4]);
		list.add(0, v[0]);
		list.add(2, 10.55);
		list.remove(3);

		java.util.ListIterator<Double> iterator1 = list.listIterator();
		while (iterator1.hasNext())
			System.out.print(iterator1.next() + " ");

		java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
		System.out.println();
		while (iterator2.hasPrevious())
			System.out.print(iterator2.previous() + " ");
	}

	public static class TwoWayLinkedList<E> implements MyList<E> {
		// Implement it. Pay attention to implementing the methods that utilize the 
		// doubly linked list data structure. For example, when implementing remove(index),
		// you need to adjust both the previous and next to avoid broken links.
		private Node<E> head, tail;
		private int size = 0;

		public TwoWayLinkedList() {

		}

		public E getFirst() {
			if (size == 0) {
				return null;
			}
			else {
				return head.element;
			}
		}
		public E getLast() {
			if (size == 0) {
				return null;
			}
			else {
				return tail.element;
			}
		}
		public void addFirst(E e) {
			Node<E> newNode = new Node<>(e); 
			if(head == null) {
				head = newNode;
				tail = head;
			}else {
				head.previous = newNode;
				newNode.next = head;
				head = newNode;
			}
			size++;
		}

		public void addLast(E e) {
			Node<E> newNode = new Node<>(e); 
			if(head == null) {
				head = newNode;
				tail = head;
			}else {
				newNode.previous = tail;
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}

		@Override
		public void add(int index, E e) {
			Node<E> newNode = new Node<>(e);
			if(index == 0) {
				addFirst(newNode.element);
			}else if(index >= size()) {
				addLast(newNode.element);
			}else {
				Node<E> current = head;
				int count = 0;
				while(count < index) {
					current = current.next;
					count++;
				}
				Node<E> temp = current.next;
				current.next = newNode;
				newNode.previous = current;
				newNode.next = temp;
				temp.previous = newNode;
				size++;
			}

		}


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

		public E removeLast() {
			if (size == 0) {
				return null;
			}
			else if (size == 1) {
				E temp = head.element;
				removeFirst();
				return temp;
			}
			else {
				E temp = tail.element;
				Node<E> current = tail.previous;
				tail = current;
				tail.next = null;
				size--;
				return temp;
			}
		}

		@Override
		public E remove(int index) {
			if(index < 0 || index >= size) {
				return null;
			}else if(index == 0) {
				return removeFirst();
			}else if(index == this.size - 1) {
				return removeLast();
			}else {
				Node<E> current = head;
				int count = 0;
				while(count < index) {
					current = current.next;
					count++;
				}
				Node<E> temp = current.next;
				current.next = temp.next;
				current.previous = current;
				size--;
				return temp.element;
			}
		}

		@Override
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
		@Override
		public int size() {
			return this.size;
		}


		@Override
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
				return temp.element = (E)e;
			}
		}

		@Override
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

		@Override
		public int lastIndexOf(Object e) {
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

		public java.util.ListIterator<E> listIterator() {
			return new LinkedListIterator();
		}
		
		public java.util.ListIterator<E> listIterator(int index) {
			return new LinkedListIterator(index);
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
		@Override
		public void clear() {
			this.size = 0;
			head = tail = null;
		}
		
		@Override
		public boolean contains(Object o) {
			if(this.size < 1) {
				return false;
			}else {
				Node<E> temp = head;
				while(temp != null) {
					if(temp.element.equals(o)) {
						return true;
					}
					temp = temp.next;
				}
				return false;	
			}
		}
		
		class LinkedListIterator implements java.util.ListIterator<E> {
			private Node<E> current; // Current index 

			public LinkedListIterator() {
				this.current = head;
			}
			public LinkedListIterator(int index) {
				Node<E>nodeAtIndex = head;
				int count = 0;
				while(count < index){
					nodeAtIndex = nodeAtIndex.next;
					count++;
				}
				this.current = nodeAtIndex;
			}
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
			public boolean hasPrevious() {
				return current.previous!= null;
			}
			public E previous() {
				E e = current.element;
				current = current.previous;
				return e;
			}

			@Override
			public void remove() {
				// Left as an exercise
			}
			@Override
			public void add(E e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			@Override
			public void set(E e) {
				// TODO Auto-generated method stub
				
			}
		}

		private static class Node<E> {
			E element;
			Node<E> next;
			Node<E> previous;
			public Node(E e) {
				element = e;
			}
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
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
}	
