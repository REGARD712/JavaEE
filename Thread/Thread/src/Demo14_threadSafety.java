public class Demo14_threadSafety {
    private static int count = 0;

    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t2-结束");
        });

        t1.start();
        t2.start();

        // 理论上输出的结果应是100000，实际输出的结果是0
        // 原因是主线程 main 运行太快了，当 t1 和 t2 线程还在计算时，主线程已经打印结果、运行完毕了
        System.out.println(count);
    }

    // 让主线程等待 t1 和 t2 线程，等到它们两个都执行完成再打印，故使用 join 方法
    public static void main2(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t2-结束");
        });

        t1.start();
        t2.start();

        // 在主线程中，通过 t1 和 t2 对象调用 join 方法
        // 表示让主线程 main 等待 t1 线程和 t2 线程
        t1.join();
        t2.join();

        // 当两个线程都执行完毕后主线程再继续执行打印操作
        System.out.println(count);
        // 实际输出的结果小于100000，仍不符合预期
        // 原因是自增操作（count++）具有非原子性，即该代码对应三个步骤：读数据、计算数据、存储数据
        // 由于并发执行的线程调度是随机的，当 t1 线程还在执行计算数据时，可能就被调度到 t2 线程并执行读取数据操作...
    }

    // 可以试着让 t1 线程先执行完后，再让 t2 线程执行，改成串行执行
    public static void main3(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
            System.out.println("t2-结束");
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println(count);
    }

    // 若是并发执行，可以通过“加锁”操作解决线程安全问题
    public static void main4(String[] args) throws InterruptedException {
        // 任何一个对象都可以用作“锁”
        Object locker = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 将 count++ 这一代码（包含三个操作）加锁打包成一个操作，这样就不会在操作一半时就调度到别的线程去了
                // 加锁时注意要对同一个锁对象进行操作，否则就是无效加锁
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
}
