public class Demo18_waitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        System.out.println("before wait");
        synchronized (object) {
            object.wait();
        }
        System.out.println("after wait");
    }
}
