package tmv_philosopher_lunch;

/**
 * @author teleginmv
 * five starving philosophers task
 */

//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import tmv_utils.Utils;

class FivePhilosophers implements Runnable {
	
	//all philosophers are thinking and eating
	private static final int eatingTime = 10_000;
	//Sudden death
	//private static final int eatingTime = 11_000;
	
	//maximum time of starving
	private static final long starvingTimeDelta = 20_100_000_000L;
	long temp;
	String name; //thread name
	Thread t;
	boolean suspendFlag;
	long starvingTime;

	private static final Logger eq1 = LogManager.getLogger("eqConsole");

	FivePhilosophers(String threadname, long starvingTime) {
		
		name = threadname;
		//starvingTime - between end of eating and start of the next eating
		this.starvingTime = System.nanoTime();
		t = new Thread(this, name);
		eq1.info("Philosopher is thinking: " + t);
		suspendFlag = true;
		t.start();
	}

	public void run() {
		//
		while(true) {
		try {
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
			}
		} catch (InterruptedException e) {
			eq1.error(name + " interrupted.");
		}
		}
	}

	void mysuspend() {
		suspendFlag = true;
		//philosopher stops eating and starts thinking and prepares to starve
		this.starvingTime = System.nanoTime();	
	}

	synchronized void myresume() throws DeathException {

		temp = System.nanoTime();
		eq1.info(this.name + " is waiting for " + (temp - this.starvingTime)/1_000_000_000 + " seconds");

		//how long time is philosopher thinking? 
		if((temp - this.starvingTime) > starvingTimeDelta) {
			eq1.info(this.name + " is DEAD because of starving.");
			throw new DeathException(this.t);
		}
		suspendFlag = false;
		notify();

	}

	public static void main(String args[]) {

		FivePhilosophers ob1 = new FivePhilosophers("Confucius", 0);
		FivePhilosophers ob2 = new FivePhilosophers("Mozi", 0);
		FivePhilosophers ob3 = new FivePhilosophers("Guiguzi", 0);
		FivePhilosophers ob4 = new FivePhilosophers("Qu Qiubai", 0);
		FivePhilosophers ob5 = new FivePhilosophers("Chao Cuo", 0);

		
		eq1.info(Thread.currentThread().getName() + " is waitor");
		while (true) {
			
			try {
				ob1.myresume();
				ob3.myresume();
			} catch (DeathException e1) {
				return;
			}
			eq1.info("Waitor gives chopsticks to: " + ob1.name + " and " + ob3.name);
			eq1.info(ob1.name + " is eating");
			eq1.info(ob3.name + " is eating");
			Utils.pause(eatingTime);
			ob1.mysuspend();
			ob3.mysuspend();
			
			eq1.info(ob1.name + " stops eaing and starts thinking");
			eq1.info(ob3.name + " stops eaing and starts thinking");

			try {
				ob2.myresume();
				ob4.myresume();
			} catch (DeathException e1) {
				return;
			}
			eq1.info("Waitor gives chopsticks to: " + ob2.name + " and " + ob4.name);
			eq1.info(ob2.name + " is eating");
			eq1.info(ob4.name + " is eating");
			Utils.pause(eatingTime);
			ob2.mysuspend();
			ob4.mysuspend();
			eq1.info(ob2.name + " stops eaing and starts thinking");
			eq1.info(ob4.name + " stops eaing and starts thinking");

			
			try {
				ob5.myresume();
			} catch (DeathException e1) {
				return;
			}
			eq1.info("Waitor gives chopsticks to: " + ob5.name);
			eq1.info(ob5.name + " is eating");
			Utils.pause(eatingTime);
			ob5.mysuspend();
			eq1.info(ob5.name + " stops eaing and starts thinking");

			
		}
		
	}
}