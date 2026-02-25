import java.util.concurrent.Semaphore;

public class Demo38_Semaphore2 {
    // 使用 Semaphore解决线程安全问题
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    try {
                        semaphore.acquire();
                        count++;
                        semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    try {
                        semaphore.acquire();
                        count++;
                        semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
