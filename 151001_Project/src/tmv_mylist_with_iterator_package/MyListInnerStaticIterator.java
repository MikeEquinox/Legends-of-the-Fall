package tmv_mylist_with_iterator_package;

import java.util.Iterator;

public class MyListInnerStaticIterator<T> {
	
	
	
	public Node<T> first; //pointer to the first element
	Node<T> prev;  //pointer to the previous element
	
	public void add(T data) {
		
		Node<T> node = new Node<T>();
		node.data = data;		//insert data to the current element
		//node.next = first; 	//Zaal code
		//first = node;			//Zaal code
		
		node.next = null;		//pointer to the next element always = null
		
 		if(prev == null) 		//if first element 
			first = node;		//set pointer first 
		else prev.next = node;	//else set pointer of the previous element to the current element
		prev = node;			//set current element = previous element
		
	}
	
	@Override
	public String toString() {
		
		String s = "[";
		
		Node<T> temp = first;
		
		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}	
		return s + "]";
	}

	
static class MyIterator <T> implements Iterable<T>{
		
	//outer class
	MyListInnerStaticIterator<T> list;
	
	//constructor with outer class instance
	public MyIterator(MyListInnerStaticIterator<T> list) {
		this.list = list;
	}

		@Override
		public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			
			Node<T> current = list.first;
			

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}

			@Override
			public void remove() {}

		};
	}
}
	
}
