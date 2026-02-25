import java.util.concurrent.Semaphore;

public class Demo37_Semaphore {
    public static void main(String[] args) throws InterruptedException {
        // 指定可用资源的个数是 3
        Semaphore semaphore = new Semaphore(3);

        semaphore.acquire();
        System.out.println("进行一次 P 操作");
        semaphore.acquire();
        System.out.println("进行一次 P 操作");
        semaphore.acquire();
        System.out.println("进行一次 P 操作");
        // 最后一次 P 操作, 会阻塞, 因为没有可用资源了
        semaphore.acquire();
        System.out.println("进行一次 P 操作");
    }
}
