public class Demo15_synchronized {
    // 写法一：
    private static int count = 0;
    public static void main1(String[] args) throws InterruptedException {
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    count++;
                }
            }
            System.out.println("t2-结束");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }

    // 写法二：
    // 将 count++ 所包含的三个操作封装成一个 add 方法
    // 使用 synchronized 修饰 add 方法
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.add();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.get());
    }
}

class Counter {
    private int count = 0;

    synchronized public void add () {
        // synchronized 修饰普通方法相当于给 this 加锁
        count++;
    }
    // 相当于：
    // public void add () {
    //     synchronized (this) {
    //         count++;
    //     }
    // }

    public int get () {
        return count;
    }
}
