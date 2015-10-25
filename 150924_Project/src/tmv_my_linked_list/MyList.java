package tmv_my_linked_list;

public class MyList<T> {
	
	Node<T> first; //pointer to the first element
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
		
		Node temp = first;
		
		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}	
		return s + "]";
	}

}
