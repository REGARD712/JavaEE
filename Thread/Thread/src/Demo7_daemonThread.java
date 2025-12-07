public class Demo7_daemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("thread t");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // 使用setDaemon方法可以将我们创建的线程修改为后台线程
        // 但是需要在start方法之前使用
        t.setDaemon(true);
        t.start();

        // 主线程
        for (int i = 0; i < 3; i++) {
            System.out.println("main");
            Thread.sleep(1000);
        }
        // 线程t已被修改为后台线程，当主线程结束，线程t也随之结束
        System.out.println("main-结束");
    }
}
