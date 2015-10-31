package tmv_philosopher_lunch;

public class DeathException extends Exception {

	public DeathException(Thread t) {
		
		t.interrupt(); 
		
	}	
}
