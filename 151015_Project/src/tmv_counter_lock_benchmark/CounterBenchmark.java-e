package tmv_counter_lock_benchmark;

/**
 * @author teleginmv
 * package to compare benchmark of Counter synchronized
 * and CounterWithLock
 * CounterWithLock 20% faster
 */

public class CounterBenchmark {

	private static final int COUNTER_LIMIT = 1_000_000_000;

	public static void main(String[] args) {
		

	long start = System.nanoTime();
	Counter counter = new Counter();
	for(int i = 0; i < COUNTER_LIMIT; i++) {
		counter.inc();
	}
	long end = System.nanoTime();
	long traceTime = end-start;
	System.out.println("Benchmark Counter: " + traceTime);

	start = System.nanoTime();
	CounterWithLock counterWithLock = new CounterWithLock();
	for(int i = 0; i < COUNTER_LIMIT; i++) {
		counterWithLock.inc();
	}
	end = System.nanoTime();
	traceTime = end-start;
	System.out.println("Benchmark CounterWithLock: " + traceTime);
	

	}

}
