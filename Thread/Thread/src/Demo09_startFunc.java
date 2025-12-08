public class Demo09_startFunc {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("thread");
        });
        t.start();
        // 每一个Thread对象只能够调用一次start方法
        // 想创建新的线程必须重新创建一个Thread对象
        // 每一个Thread对象不能重复利用
        //t.start();
    }
}
