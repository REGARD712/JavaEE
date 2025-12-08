public class Demo11_isInterruptedFunc {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //while (t.isInterrupted())  -> 此处 lambda 中使用 t 的时机是在 Thread 创建 t 对象之前
            // 使用 currentThread 方法获取到当前线程的引用 t ，其作用相当于 this 关键字
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                    // 当主线程调用 interrupt 方法强制终止 t 线程，此时 t 线程正在 sleep，sleep 被中断就抛出异常
                    // 然后执行“throw new RuntimeException(e)”抛出包装异常，由于没有外层异常处理器（run方法没有try...catch处理异常语句），线程 t 异常终止
                    // （空语句）
                    // 当什么都不写，t 线程不会被终止：当调用 interrupt 方法时 sleep 被提前唤醒并抛出异常，JVM 此时将终止标志改回 false
                    break;  // 若添加 break 语句，当 sleep 在执行过程中被打断并抛出异常后，异常被 catch 语句捕获，跳出循环，不再检查终止标志（此时终止标志已被重置为 false）
                    // 程序将正常终止
                }
            }
            System.out.println("thread-结束");
        });
        t.start();

        Thread.sleep(3000);
        System.out.println("main线程尝试终止t线程");
        t.interrupt();
    }
}
