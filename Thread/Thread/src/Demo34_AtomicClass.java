import java.util.concurrent.atomic.AtomicInteger;

public class Demo34_AtomicClass {
    //private static int count = 0;
    // 用原子类代替原生的 int，天然线程安全
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                //count++;
                count.getAndIncrement();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                //count++;
                count.getAndIncrement();
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

        System.out.println("count = " + count.get());
    }
}
