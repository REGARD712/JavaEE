import java.util.Scanner;

public class Demo17_volatile {
    private static int flag1 = 0;

    // 内存可见性问题
    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag1 == 0) {
                // 当 flag1 为 0 时一直循环
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            // 对 flag1 进行修改
            Scanner in = new Scanner(System.in);
            System.out.println("请输入 flag1 的值：");
            flag1 = in.nextInt();
        });

        t1.start();
        t2.start();
        // 运行后发现即使输入1，t1 线程并不会如期结束
    }
    // t1 线程负责读取 flag1 的值，t2 线程负责修改 flag1 的值
    // 运行结果：t1 并没有读取到 t2 修改后的 flag1 的值
    // 原因：编译器优化。
    // 由于 while 循环中的“条件比较”指令开销较小并在短时间内执行速度非常快，
    // 但是输入 flag1 的速度远比该速度慢，JVM 便认为反复执行多次读取操作 flag1 仍是 0，就不必多次读取，
    // 就将原本“从内存中读取的操作”优化成了“直接读取寄存器的操作”，
    // 这样一来，不管用户再怎么修改 flag1 的值，JVM 都只会从寄存器读取最初存入的值 0，从而出现死循环

    public static void main2(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag1 == 0) {
                // 当 flag1 为 0 时一直循环
                try {
                    Thread.sleep(1);
                    // 放慢读取速度
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            // 对 flag1 进行修改
            Scanner in = new Scanner(System.in);
            System.out.println("请输入 flag1 的值：");
            flag1 = in.nextInt();
        });

        t1.start();
        t2.start();
    }
    // 运行后发现问题解决了
    // 原因：使用了 sleep（1），表示每一次读取的时候休眠 1毫秒，这对于读取操作的速度来说已经很慢了
    // 因此不会出现之前的优化操作，也就可以如期运行了
    // 但是，频繁使用 sleep 会导致程序的效率降低

    // 使用 volatile 关键字来修饰被读取的变量，此时无论读取速度怎样，JVM 都不会对该变量进行优化
    private volatile static int flag = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag == 0) {
                // 当 flag 为 0 时一直循环
            }
            System.out.println("t1-结束");
        });

        Thread t2 = new Thread(() -> {
            // 对 flag 进行修改
            Scanner in = new Scanner(System.in);
            System.out.println("请输入 flag 的值：");
            flag = in.nextInt();
        });

        t1.start();
        t2.start();
    }
}
