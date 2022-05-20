import java.util.Random;
import java.util.concurrent.Semaphore;

public class Task implements Runnable {
    private Semaphore sem = new Semaphore(1);
    private static int threadCounter = 0;
    private static int counter = 0;

    // TODO: VERIFY FUNCTIONALITY
    public Task() {
        Task.threadCounter++;
    }

    private void tryAcquire() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.tryAcquire();

        if (Task.threadCounter % 2 == 0)
            Queue.queue.set(Task.counter, new Random().nextInt(32));
        else
            System.out.println("Array[" + Task.counter + "] = " + Queue.queue.get(Task.counter));

        synchronized (this) {
            Task.counter++;
        }

        this.sem.release();
    }
}
