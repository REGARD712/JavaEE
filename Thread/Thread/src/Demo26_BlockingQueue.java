import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo26_BlockingQueue {
    public static void main1(String[] args) throws InterruptedException {
        // 基于链表实现的阻塞队列
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();

        // 常用方法
        queue.put("abc");
        String elem = queue.take();
    }

    public static void main2(String[] args) throws InterruptedException {
        // 基于链表实现的阻塞队列
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();

        String elem = queue.take();
        System.out.println(elem);
    }

    public static void main(String[] args) throws InterruptedException {
        // 基于链表实现的阻塞队列
        BlockingDeque<String> queue = new LinkedBlockingDeque<>(1000);

        for (int i = 0; i < 1000; i ++ )
            queue.put("abc");
        System.out.println("队列已满");

        queue.put("abc");
        System.out.println("尝试再次put元素");
    }
}
