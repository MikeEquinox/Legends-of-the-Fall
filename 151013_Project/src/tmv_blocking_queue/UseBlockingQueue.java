package tmv_blocking_queue;

/**
 * @author teleginmv
 * package shows LIMITED Blocking Queue 
 */

import java.util.Date;
import java.util.Random;

import tmv_utils.Utils;

public class UseBlockingQueue {

	static Random random = new Random();

	static class Producer implements Runnable {

		private BlockingQueue<String> queue;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;

		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(2000 + random.nextInt(3000));
				queue.put(new Date().toString());
				System.out.println("produced, total: " + queue.size());
			}
		}

	}

	static class Consumer implements Runnable {

		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(3000 + random.nextInt(3000));
				String item = queue.take();
				System.err.println(item + " consumed, total: " + queue.size());
			}
		}

	}

	public static void main(String[] args) {
		
		final int CAPACITY = 3;
		
		BlockingQueue<String> queue = new BlockingQueue<>(CAPACITY);
		
		new Thread(new Consumer(queue)).start();
		new Thread(new Producer(queue)).start();
		
	}
	
}
