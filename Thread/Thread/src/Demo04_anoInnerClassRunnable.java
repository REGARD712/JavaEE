public class Demo04_anoInnerClassRunnable {
    public static void main(String[] args) throws InterruptedException {
        // 在Runnable这里创建匿名内部类，将任务和线程执行分离
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("This is Thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();      // 创建线程

        // 主线程
        while (true) {
            System.out.println("This is main");
            Thread.sleep(1000);
        }
    }
}
