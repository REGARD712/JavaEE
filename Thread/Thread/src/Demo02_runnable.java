// 实现runnable接口，解耦合
class MyRunnable implements Runnable {
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
}

public class Demo02_runnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();      // 创建线程

        // 主线程
        while (true) {
            System.out.printf("This is main");
            Thread.sleep(1000);
        }
    }
}
