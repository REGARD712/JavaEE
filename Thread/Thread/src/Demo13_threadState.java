public class Demo13_threadState {
    // 查看 Thread 类所有的线程状态
    public static void main1(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
    }

    // NEW 状态
    public static void main2(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // 什么都不做
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(t.getState());
    }

    // RUNNABLE 状态
    public static void main3(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // 什么都不做
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

        System.out.println(t.getState());
    }

    // TIMED_WAITING 状态
    public static void main4(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // 什么都不做
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

        Thread.sleep(1000);
        System.out.println(t.getState());
    }
}
