package tmv_mylist_with_iterator_package;

import java.util.Iterator;

public class MyListLocalIterator<T> {

		public class Node<T> {
			T data;
			Node<T> next;
		}
		
		Node<T> first; //pointer to the first element
		Node<T> prev;  //pointer to the previous element
		
		//LOCAL CLASS
		public Iterator<String> localIterator() {
			
			Iterator<String> it;
			class MyIterator implements Iterable<T> {
				
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
					public void remove() {}

				};
			}
			}
			
			//create instance of local class
			MyIterator localclass = new MyIterator();
			//return iterator
			it = localclass.iterator();
			return it;
		}
		
		
		
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
			
			Node temp = first;
			
			while (temp != null) {
				s += temp.data;
				s += ", ";
				temp = temp.next;
			}	
			return s + "]";
		}

		
	}
