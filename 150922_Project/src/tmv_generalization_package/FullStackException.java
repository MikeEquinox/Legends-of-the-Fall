package tmv_generalization_package;

public class FullStackException extends Exception {

	public <T> FullStackException(T element) {
		System.out.println("Stack is full.Outbound element: " + element);
		printStackTrace();
	}
}
