package tmv_bounded_mylist;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

	public class Node<T> {
		T data;
		Node<T> next;
	}

	Node<T> first; // pointer to the first element
	Node<T> prev; // pointer to the previous element
	int counter = 0; // list current length
	int LIST_SIZE = 0; // list total length

	// Constructor
	public MyList(int size) {
		LIST_SIZE = size;
	}

	//method adds an element
	public void add(T data) throws FullListException {

		if (counter < LIST_SIZE) {
			Node<T> node = new Node<T>();
			node.data = data; 		// insert data to the current element
			node.next = null; 		// pointer to the next element always = null

			if (prev == null) 		// if first element
				first = node; 		// set pointer first
			else
				prev.next = node; 	// else set pointer of the previous element to
									// the current element
			prev = node; 			// set current element = previous element
			counter++;
		} else
			throw new FullListException("FullList exception! List max size = "
					+ LIST_SIZE + ". Element: " + data + " - not added.");
	}
	
	//method returns last added element
	public T read() throws EmptyListException {
		if(counter == 0) throw new EmptyListException("EmptyList exception!");
		return prev.data;
	}
	
	
	@Override
	public String toString() {

		String s = "[";
		Node temp = first;
		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}
		return s + "]";
	}

	@Override
	public Iterator iterator() {

		return new Iterator<T>() {
			Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = (T) current.data;
				current = current.next;
				return data;
			}

			@Override
			public void remove() {
			}
		};
		
	}
}
