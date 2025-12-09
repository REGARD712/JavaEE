public class Demo12_joinFunc {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                System.out.println("Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread-结束");
        });
        t.start();

        t.join();
        // 在主线程中通过 t 线程调用 join 方法
        // 意思是 t 线程要参与 cpu 的调度执行（要插队），此时要让原本正在执行的 main 线程等待
        // 当没有传入参数时，主线程要一直等待 t 线程
        // 可以提供“超时时间”，当超过该指定时间时主线程就会继续往下执行，不会一直等待
        System.out.println("main-结束");
    }
}
