class Test {
    public int value = 0;
}

public class Demo10_isFinishedFunc {
    private static boolean isFinished = false;

    public static void main(String[] args) throws InterruptedException {
        // 若isFinished定义在此处，会编译报错
        // 因为lambda是有“变量捕获”的——即使用自身所在类之外的变量
        // 此处的isFinished是局部变量，由于lambda是回调函数，在线程创建之后才执行
        // 等到lambda执行，此时主线程早已执行完毕，isFinished已被销毁
        //boolean isFinished = false;
        // 将isFinished改成成员变量，就不会触发“变量捕获”语法

        Test test = new Test();

        Thread t = new Thread(() -> {
            while (!isFinished) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("thread-结束");
        });
        t.start();

        Thread.sleep(3000);
        isFinished = true;
    }
}
