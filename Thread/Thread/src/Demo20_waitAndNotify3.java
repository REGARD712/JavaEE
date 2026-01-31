import java.util.Scanner;

// notify 不起作用的情况 1：wait 和 notify 针对的对象不是同一个
public class Demo20_waitAndNotify3 {
    public static void main(String[] args) {
        Object locker = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                // t1 线程获取锁并 wait
                System.out.println("before wait");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            // t2 线程输入数据
            Scanner in = new Scanner(System.in);
            System.out.println("输入任意内容以唤醒t1线程：");
            in.next();

            synchronized (locker2) {
                locker2.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
