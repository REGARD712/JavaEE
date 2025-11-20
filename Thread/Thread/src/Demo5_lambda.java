public class Demo5_lambda {
    public static void main(String[] args) throws InterruptedException {
        // 使用lambda表达式
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("This is Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();      // 创建线程

        // 主线程
        while (true) {
            System.out.println("This is main");
            Thread.sleep(1000);
        }
    }
}
