import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

// 模拟实现一个固定线程个数的线程池
class MyThreadPool {
    // 工作队列：由阻塞队列实现，用于存放任务
    private BlockingQueue<Runnable> queue = null;

    // 构造方法：初始化线程池，创建固定个数的线程
    public MyThreadPool(int n) {
        // 使用基于数组实现的阻塞队列作为工作队列，容量是1000
        queue = new ArrayBlockingQueue<>(1000);

        // 创建线程，让线程从工作队列中取出任务并执行
        for (int i = 0; i < n; i ++) {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        // 取出任务
                        Runnable task = queue.take();
                        // 执行任务
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }

    // submit 方法：将任务放入工作队列中
    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }
}

public class Demo31_MyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 测试线程池
        MyThreadPool threadPool = new MyThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int id = i;
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " id = " + id);
            });
        }
    }
}
