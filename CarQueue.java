import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	// queue
	private Queue<Integer> queue;
	// for random number
	private Random rand;

	public CarQueue() {
		// constructor
		queue = new ArrayDeque<>();
		rand = new Random();

		// add random integers into queue (6 total from 0-3)
		for (int i = 0; i < 6; i++) {
			queue.add(rand.nextInt(4));
		}
	}

	public void addToQueue() {
		class QueueRunnable implements Runnable {
			@Override
			public void run() {
				try {
					// keep looping
					while (true) {
						/**
						 * Adds 0,1,2 or 3 to queue 0 = up 1 = down 2 = right 3 = left
						 */
						queue.add(rand.nextInt(4));

						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		// creates a thread and starts the thread.
		Runnable r = new QueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	// deletes
	public Integer deleteQueue() {
		// if empty
		if (queue.isEmpty()) {
			return rand.nextInt(4);
		}
		return queue.remove();

	}
}