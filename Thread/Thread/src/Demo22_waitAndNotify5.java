import java.util.Scanner;

public class Demo22_waitAndNotify5 {
    // 多个线程在同一个对象上 wait，进行 notify 时随机唤醒一个线程
    public static void main1(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("before wait-t1");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t1");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("before wait-t2");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t2");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(() -> {
            // t3 线程输入数据
            Scanner in = new Scanner(System.in);
            System.out.println("输入任意内容以唤醒线程：");
            in.next();

            synchronized (locker) {
                locker.notify();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    // 依次唤醒两个线程：一个 notify 只能唤醒一个线程
    public static void main2(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("before wait-t1");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t1");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("before wait-t2");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t2");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(() -> {
            // t3 线程输入数据
            Scanner in = new Scanner(System.in);

            // 唤醒第一个线程
            System.out.println("输入任意内容以唤醒一个线程：");
            in.next();
            synchronized (locker) {
                locker.notify();
            }

            // 唤醒第二个线程
            System.out.println("输入任意内容以唤醒一个线程：");
            in.next();
            synchronized (locker) {
                locker.notify();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    // 使用 notifyAll方法一次唤醒所有 wait 的线程
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("before wait-t1");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t1");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("before wait-t2");
                synchronized (locker) {
                    locker.wait();
                }
                System.out.println("after wait-t2");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(() -> {
            // t3 线程输入数据
            Scanner in = new Scanner(System.in);

            // 使用 notifyAll 唤醒线程
            System.out.println("输入任意内容以唤醒所有线程：");
            in.next();
            synchronized (locker) {
                locker.notifyAll();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
