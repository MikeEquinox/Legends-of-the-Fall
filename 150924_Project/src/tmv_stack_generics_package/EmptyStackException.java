package tmv_stack_generics_package;

public class EmptyStackException extends Exception {

	public EmptyStackException() {
		System.out.println("Stack is empty.");
		printStackTrace();
	}
}
