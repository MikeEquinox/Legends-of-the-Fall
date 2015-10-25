package tmv_blocking_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	
	private Queue<T> queue = new LinkedList<>();
	private int capacity;
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public T take() {
		T item;
		synchronized (queue) {
			while (queue.isEmpty()) {
				try {
					System.err.println("Queue is empty. Waiting.");		
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			item = queue.poll();
			System.out.println("Taking element " + item);
			return item;
		}
	}

	public void put(T item) {
		synchronized (queue) {
			if (queue.size() < getCapacity()) {
				System.out.println("Putting element " + item);
			queue.offer(item);
			queue.notify();
			} else
				{
					System.err.println("Queue is full. Waiting.");					
					queue.notify();
				}
		}
	}

	public int size() {
		return queue.size();
	}

	public int getCapacity() {
		return capacity;
	}
}
