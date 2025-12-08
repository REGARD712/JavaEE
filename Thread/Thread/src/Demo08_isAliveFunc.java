public class Demo08_isAliveFunc {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(t.isAlive());
        // 当还未调用start方法时，线程t还没有被创建出来（但是t对象存在），输出的结果为false

        t.start();
        // 当调用start方法之后才真正创建线程

        while (true) {
            System.out.println(t.isAlive());
            Thread.sleep(1000);
        }
    }
}
