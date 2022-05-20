import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        new Queue();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Task());
        }

        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown();

        // debugging
        for (int i = 0; i < 10; i++) {
            System.out.println("sysout : " + Queue.queue.get(i));
        }

    }
}