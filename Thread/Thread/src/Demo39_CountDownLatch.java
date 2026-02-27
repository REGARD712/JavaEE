import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo39_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // 把整个任务拆分为多个子任务，多个子任务同时执行
        // 可以讲子任务放入线程池中执行，也可以让子任务独立执行

        // 构造 CountDownLatch对象，传入的 10表示任务的个数
        CountDownLatch latch = new CountDownLatch(10);

        // 用线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            int id = i;
            executor.submit(() -> {
                System.out.println("子任务执行：" + id);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("子任务结束：" + id);
                // 当子任务执行完毕，调用 countDown方法，计数减1
                latch.countDown();
            });
        }
        // 使用 await方法，阻塞当前线程，等待所有子任务执行完毕
        latch.await();
        System.out.println("所有任务执行完毕");
        executor.shutdown();
    }
}
