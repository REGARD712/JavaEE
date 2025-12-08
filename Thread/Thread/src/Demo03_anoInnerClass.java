public class Demo03_anoInnerClass {
    public static void main(String[] args) throws InterruptedException {
        // 创建对象的时候使用了Thread的匿名（一次性）子类，并重写run方法
        Thread t = new Thread() {
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
        t.start();      // 创建线程

        // 主线程
        while (true) {
            System.out.println("This is main");
            Thread.sleep(1000);
        }
    }
}
