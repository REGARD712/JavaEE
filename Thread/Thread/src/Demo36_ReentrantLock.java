import java.util.concurrent.locks.ReentrantLock;

// 使用 ReentrantLock解决线程安全问题
public class Demo36_ReentrantLock {
    private static int count = 0;
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    locker.lock();
                    try {
                        count++;
                    } finally {
                        // 确保锁被释放
                        locker.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    locker.lock();
                    try {
                        count++;
                    } finally {
                        // 确保锁被释放
                        locker.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count = " + count);
    }
}
