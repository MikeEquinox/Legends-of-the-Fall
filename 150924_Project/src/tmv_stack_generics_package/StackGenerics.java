package tmv_stack_generics_package;

import java.util.Stack;

/**
 * 
 * @author teleginmv 
 * package implements parameterized stack java 
 * compiler is controlling the type of stack elements
 *         
 * @param <T>
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
		StackGenerics<Integer> sg2 = new StackGenerics<>(2);
		
		sg2.push(100);
		sg2.push(130);
//		sg2.push(23);
//		sg2.push("One"); //ERROR String argument
		sg2.pop();
		
		sg.push("One");
//		sg.push(100); //ERROR int argument
		sg.push("Two");
		sg.push("Three");
		sg.push("Four");
		sg.pop();
		sg.pop();
		sg.push("Five");
		sg.push("Six");
		sg.push("Seven");
		sg.push("Eight");
		sg.pop();
		sg.pop();
		sg.pop();
//		sg.pop();
//		sg.pop();
//		sg.pop();
//		sg.pop();

		System.out.println("Stack:" + sg.toString());
		System.out.println("Stack:" + sg2.toString());

	}

}
