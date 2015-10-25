package tmv_mystack_package;

import java.util.Stack;

/**
 * @author teleginmv 
 * package implements parameterized stack java 
 * compiler is controlling the type of stack elements
 * methods push(), pop(), top(), size(), isEmpty()
 * outstanding features: numberOfElements(), trimToSize()
 * stack is indefinite, enlarging itself automatically
 * if stack is empty pop(), top() returns null value
 *         
 * @param <T>
 */

public class StackGenerics<T> {

	private static int size = 5;	//stack size
	T[] data;		//stack
	T[] datacopy;	//to enlarge stack
	public int stp; // stack pointer

	public StackGenerics() {
		this(size);
	}

	public StackGenerics(int len) {
		size = len > 0 ? len : size;
		stp = -1;
		data = (T[]) new Object[size]; // stack creation
	}

	public void push(T element) {
		if (stp == size-1) {	// if stack is full
			size *= 2;
			datacopy = (T[]) new Object[size];
			System.arraycopy(data, 0, datacopy, 0, size/2);
			data = datacopy;
		}
		stp++; 
		data[stp] = element;		
		System.out.println("push() is working: " + element);
		return;
	}

	public T pop() {
		if (stp == -1) // if stack is empty
			return null;
		else { 
			System.out.println("pop() is working: " + data[stp]);
			return data[stp--] = null;	//return element and set this by null
			}
	}

	public T top() {
		if (isEmpty()) // if stack is empty
			return null;
		else {
			System.out.println("top() is working: " + data[stp]);
			return data[stp];
		}
	}
	
	public boolean isEmpty() {
		if (stp == -1) return true;
		return false;
	}
	
	public int numberOfElements() {
		
		if(isEmpty()) 
			System.out.println("size(): stack is empty.");
		return stp+1;
	}
	
	public int size() {
		
		return size;
	}
	
	public void trimToSize() {
		System.out.println("trimToSize() is working.");
		if (stp > 4) {
			size = stp+1;
			datacopy = (T[]) new Object[size];
			System.arraycopy(data, 0, datacopy, 0, size);
			data = datacopy;
		}
		else {
			size = 5;
			datacopy = (T[]) new Object[size];
			System.arraycopy(data, 0, datacopy, 0, size);
			data = datacopy;
		}
	}
	
	public String toString() {

		String s = "";
		for (T element : data) {
			s += " ";
			s += element;
		}
		return s;
	}

	public static void main(String[] args) {

		StackGenerics<Integer> sg2 = new StackGenerics<>();
		
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		
		if(sg2.pop() == null) System.out.println("pop(): stack is empty.");
		if(sg2.top() == null) System.out.println("top(): stack is empty.");
		
		sg2.push(100);
		sg2.push(130);
		System.out.println("Stack:" + sg2.toString());
//		sg2.push("One"); //ERROR String argument
		sg2.pop();
		System.out.println("Stack:" + sg2.toString());
		sg2.top();
		System.out.println("Stack:" + sg2.toString());
		sg2.push(170);
		sg2.push(190);
		sg2.push(180);
		sg2.push(105);
		sg2.push(140);
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		
		sg2.push(90);
		sg2.push(80);
		sg2.push(50);
		sg2.push(10);
		sg2.push(20);
		sg2.push(30);
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		sg2.top();
		sg2.top();	
		
		sg2.trimToSize();
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		
		for(int i = 0; i < 14; i++)
			sg2.pop();
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		
		sg2.trimToSize();
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
		
		sg2.push(90);
		sg2.push(80);
		sg2.push(50);
		sg2.push(10);
		sg2.push(20);
		sg2.push(30);
		System.out.println("Stack:" + sg2.toString());
		System.out.println("Stack size: " + sg2.size());
		System.out.println("Number of elements: " + sg2.numberOfElements());
	}

}
