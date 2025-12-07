public class Demo6_foregroundThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("thread-1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("thread-2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println("thread-3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t3.start();

        // 主线程
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
