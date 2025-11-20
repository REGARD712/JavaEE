// 继承Thread类的子类，并重写run方法
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("This is MyThread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Demo1_subclass {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();      // 创建线程
        
        // 主线程
        while (true) {
            System.out.println("This is main");
            Thread.sleep(1000);
        }
    }
}
