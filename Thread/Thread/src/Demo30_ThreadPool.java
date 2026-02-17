import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo30_ThreadPool {
    public static void main(String[] args) {
        // 创建一个可重用固定数量的线程池（核心线程数和最大线程数一样）
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 创建一个根据需要创建线程的线程池（若之前的线程可用，会重用这些线程）
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        // 往线程池中添加 100个任务
        for (int i = 0; i < 100; i ++) {
            int id = i;
            threadPool.submit(() -> {
                // 具体任务内容
                System.out.println("hello " + id +  ", " + Thread.currentThread().getName());
            });
        }

        // 当需要执行完指定任务后就结束程序时，用 shutdown
        threadPool.shutdown();
    }
}
