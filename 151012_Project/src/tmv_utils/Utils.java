package tmv_utils;

public class Utils extends Thread{

	public static void pause(int delay) {
		try {
			sleep(delay);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Error sleep");
		}
	}
 }
