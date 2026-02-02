public class Demo23_waitAndNotify6 {
    // 作业：三个线程分别只能打印 A，B和 C，要求按照 ABC 的顺序打印 10 次
    public static void main1(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker1) {
                        locker1.wait();
                    }
                    System.out.print("A");
                    // 通知 t2 线程
                    synchronized (locker2) {
                        locker2.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker2) {
                        locker2.wait();
                    }
                    System.out.print("B");
                    // 通知 t3 线程
                    synchronized (locker3) {
                        locker3.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker3) {
                        locker3.wait();
                    }
                    System.out.println("C");
                    // 通知 t1 线程
                    synchronized (locker1) {
                        locker1.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        // 此时的程序还无法达到预期效果，需要“推一把”
    }

    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Object locker3 = new Object();

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker1) {
                        locker1.wait();
                    }
                    System.out.print("A");
                    // 通知 t2 线程
                    synchronized (locker2) {
                        locker2.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker2) {
                        locker2.wait();
                    }
                    System.out.print("B");
                    // 通知 t3 线程
                    synchronized (locker3) {
                        locker3.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i ++) {
                    synchronized (locker3) {
                        locker3.wait();
                    }
                    System.out.println("C");
                    // 通知 t1 线程
                    synchronized (locker1) {
                        locker1.notify();
                    }
                }
            } catch(InterruptedException e) {
                throw new RuntimeException();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        // 在主线程中，先通知 t1，让程序从 t1 开始运行
        // 为了确保三个线程都进入 wait ，主线程 sleep 1秒
        Thread.sleep(1000);
        synchronized (locker1) {
            locker1.notify();
        }
    }
}
