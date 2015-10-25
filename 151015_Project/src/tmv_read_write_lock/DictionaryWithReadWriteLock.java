package tmv_read_write_lock;

/**
 * @author teleginmv
 * package shows ReadWriteLock based on Lock interface
 * Read Access   	If no threads are writing, and no threads have requested write access.
 * Write Access   	If no threads are reading or writing.
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

import tmv_utils.Utils;

class DictionaryWithReadWriteLock {

	private final Map<String, Data> m = new TreeMap<String, Data>();
	private ReentrantLock lockR = new ReentrantLock();
	private ReentrantLock lockW = new ReentrantLock();

	public Data get(String key) throws InterruptedException {

		lockW.lock();
		// System.out.println(Thread.currentThread().getName() +
		// " Write lock ON");
		// System.out.println(Thread.currentThread().getName() +
		// " is getting value");

		try {
			return m.get(key);
		} finally {
			Utils.pause(1000);
			// System.out.println(Thread.currentThread().getName() +
			// " Write lock OFF");
			lockW.unlock();
		}
	}

	public String[] allKeys() throws InterruptedException {
		lockW.lock();
		try {
			return (String[]) m.keySet().toArray();
		} finally {
			lockW.unlock();
		}
	}

	public Data put(String key, Data value) throws InterruptedException {
		lockW.lock();
		lockR.lock();
		// System.out.println(Thread.currentThread().getName() +
		// " Write and read lock ON");
		System.out.println(Thread.currentThread().getName() + " is putting "
				+ value);
		try {
			return m.put(key, value);
		} finally {
			Utils.pause(3000);
			// System.out.println(Thread.currentThread().getName() +
			// " Write and read lock OFF");
			lockW.unlock();
			lockR.unlock();
		}
	}

	public void clear() throws InterruptedException {
		lockW.lock();
		lockR.lock();
		try {
			m.clear();
		} finally {
			lockW.unlock();
			lockR.unlock();
		}
	}

	// ----------------------------MAIN---------------------------------------
	public static void main(String[] args) {

		final DictionaryWithReadWriteLock rwd = new DictionaryWithReadWriteLock();

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("First thread started.");
				
				while (true) {

					try {
						rwd.put("one",
								new Data("digit", "one way - one vision"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						rwd.put("two", new Data("digit", "two tea to two"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						rwd.put("three", new Data("digit",
								"three men in a boat"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Utils.pause(1000);
					try {
						rwd.put("four", new Data("digit", "four of us"));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("First thread got "
								+ rwd.get("one").toString());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("First thread got "
								+ rwd.get("two").toString());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("First thread got "
								+ rwd.get("three").toString());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("First thread got "
								+ rwd.get("four").toString());
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						rwd.put("five", new Data("digit",
								"five starving philosophers"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Utils.pause(10000);

				}
			}
		});
		th1.start();
		th1.setName("First thread");

		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {

				Utils.pause(4000);
				System.out.println("Second thread started.");
				
				while (true) {

					try {
						System.out.println("Second thread got "
								+ rwd.get("one").toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						rwd.put("ten", new Data("digit", "ten little niggers"));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Utils.pause(3000);
					try {
						System.out.println("Second thread got "
								+ rwd.get("one").toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("Second thread got "
								+ rwd.get("two").toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// Utils.pause(1000);
					try {
						System.out.println("Second thread got "
								+ rwd.get("three").toString());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Utils.pause(10000);
				}
			}
		});
		th2.start();
		th2.setName("Second thread");
	}

}
