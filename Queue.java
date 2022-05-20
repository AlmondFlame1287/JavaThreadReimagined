import java.util.ArrayList;
import java.util.Random;

public class Queue {
    public static ArrayList<Integer> queue = new ArrayList<>(10);

    public Queue() {
        for (int i = 0; i < 10; i++) {
            if (i < 3)
                queue.add(new Random().nextInt(32));
            else
                queue.add(0);
        }
    }
}
