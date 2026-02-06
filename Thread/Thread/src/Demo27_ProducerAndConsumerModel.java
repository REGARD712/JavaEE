import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo27_ProducerAndConsumerModel {
    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(1000);

        Thread producer = new Thread(() -> {
            int n = 0;
            while (true) {
                try {
                    queue.put(n);
                    System.out.println("生产元素" + n);
                    n ++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Integer n = queue.take();
                    System.out.println("消费元素" + n);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();
    }
}
