class Counter2 {
    private int count = 0;

    public void add () {
        synchronized (this) {
            count++;
        }
    }

    public int get () {
        return count;
    }
}

public class Demo16_deadLock {
    // 死锁情况一：一个线程一把锁
    public static void main1(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // 第一次进行加锁操作
                synchronized (counter) {
                    // 第二次加锁操作，此时锁对象已被占用，触发阻塞等待
                    synchronized (counter) {
                        counter.add();
                    }
                    // 要想解除阻塞等待，需要继续往下执行
                    // 但是要想继续往下执行，得将第一次加的锁解开
                }
                // 形成“死锁”，此时线程处于阻塞状态 BLOCKED
            }
            // Java 中 synchronized 的可重入性 ——> 同一个线程可以重复对同一个锁对象进行加锁操作
        });

        t1.start();
        t1.join();

        System.out.println(counter.get());
    }

    // 死锁情况二：两个线程两把锁，每个线程获取到一把锁之后尝试获取对方的锁
    public static void main2(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                // t1 线程获取到锁对象 locker1
                try {
                    Thread.sleep(1000);
                    // 确保 t2 线程拿到 locker2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 尝试获取锁对象 locker2
                synchronized (locker2) {
                    System.out.println("t1 线程获取到两把锁");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                // t2 线程获取到锁对象 locker2
                try {
                    Thread.sleep(1000);
                    // 确保 t1 线程拿到 locker1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 尝试获取锁对象 locker1
                synchronized (locker1) {
                    System.out.println("t2 线程获取到两把锁");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        // 要想不构成死锁，可以将获取锁的顺序调换一下，即 t1 和 t2 都以 locker1 和 locker2 的顺序加锁
    }
    // 防止死锁的写法：打破循环等待条件——调整加锁顺序
    public static void main3(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                // t1 线程获取到锁对象 locker1
                try {
                    Thread.sleep(1000);
                    // 此时 t2 因 locker1 被 t1 获取而处于阻塞状态 BLOCKED
                    // t1 休眠结束后，获取 locker2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // 尝试获取锁对象 locker2
                synchronized (locker2) {
                    System.out.println("t1 线程获取到两把锁");
                    // t1 获取到两把锁之后结束执行，此时 locker1 和 locker2 均被释放
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                // t2 线程获取到锁对象 locker1
                // 因 t1 先获取到 locker1 ，t2 此时处于阻塞状态 BLOCKED
                // 当 t1 结束执行后，t2 恢复执行并获取 locker1
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 休眠结束后继续获取 locker2
                    throw new RuntimeException(e);
                }
                // 尝试获取锁对象 locker2
                synchronized (locker2) {
                    System.out.println("t2 线程获取到两把锁");
                    // t2 获取到两把锁后结束执行
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    // 避免死锁的写法：打破持有并等待条件——将嵌套加锁改成串行加锁
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                // t1 线程获取到锁对象 locker1
                try {
                    Thread.sleep(1000);
                    // 此时 t2 因 locker1 被 t1 获取而处于阻塞状态 BLOCKED
                    // t1 休眠结束后，获取 locker2
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 尝试获取锁对象 locker2
            synchronized (locker2) {
                System.out.println("t1 线程获取到两把锁");
                // t1 获取到两把锁之后结束执行，此时 locker1 和 locker2 均被释放
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                // t2 线程获取到锁对象 locker1
                // 因 t1 先获取到 locker1 ，t2 此时处于阻塞状态 BLOCKED
                // 当 t1 结束执行后，t2 恢复执行并获取 locker1
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 休眠结束后继续获取 locker2
                    throw new RuntimeException(e);
                }
            }
            // 尝试获取锁对象 locker2
            synchronized (locker2) {
                System.out.println("t2 线程获取到两把锁");
                // t2 获取到两把锁后结束执行
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
