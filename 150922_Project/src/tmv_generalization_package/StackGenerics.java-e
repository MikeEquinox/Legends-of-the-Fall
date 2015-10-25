package tmv_generalization_package;

import java.util.Stack;

/**
 * @author teleginmv 
 * this example shows inheritance GENERALIZATION
 * adding some methods like pop(int bias) to get an element from stack with current bias       
 */

public class StackGenerics<T> {

	private final int size;	//stack size
	T[] data;		//stack
	public int stp; // stack pointer

	public StackGenerics() {
		this(5);
	}

	public StackGenerics(int len) {
		size = len > 0 ? len : 5;
		stp = -1;
		data = (T[]) new Object[size]; // stack creation
	}

	public void push(T element) throws FullStackException {
		if (stp == size-1) // if stack is full
			throw new FullStackException(element);
		stp++; 
		data[stp] = element;		
		return;
	}

	public T pop() throws EmptyStackException {
		if (stp == -1) // if stack is empty
			throw new EmptyStackException();
		return data[stp--] = null;	//return element and set this by null
	}

	public T pop(int bias) throws EmptyStackException {
		
		System.out.println("Returning an exact element with current bias");
		return data[stp];	//return element
	}
	
	
	
	public String toString() {

		String s = "";
		for (T element : data) {
			s += " ";
			s += element;
		}
		return s;
	}

	public static void main(String[] args) throws FullStackException,
			EmptyStackException {

		StackGenerics<String> sg = new StackGenerics<>(7);
		
		sg.push("One");
		sg.push("Two");
		sg.push("Three");
		sg.push("Four");
		sg.pop(1);

		System.out.println("Stack:" + sg.toString());

	}

}
