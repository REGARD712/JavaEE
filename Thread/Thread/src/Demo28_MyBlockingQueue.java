class MyBlockingQueue {
    // 基于数组的阻塞队列（取消泛型）
    private String[] data = null;

    // 队头
    private int head = 0;

    // 队尾
    private int tail = 0;

    // 元素个数
    private int size = 0;

    public MyBlockingQueue(int capacity) {
        this.data = new String[capacity];
    }

    public void put(String elem) throws InterruptedException {
        synchronized (this) {
            // 判满
            while (size >= data.length) {
                this.wait();
            }
            data[tail++] = elem;
            if (tail >= data.length) {
                tail = 0;
            }
            size ++;
            this.notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            // 判空
            while (size == 0) {
                this.wait();
            }
            String ret = data[head++];
            if (head >= data.length) {
                head = 0;
            }
            size --;
            this.notify();
            return ret;
        }
    }
}

public class Demo28_MyBlockingQueue {
    // 生产者消费者模型
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);

        Thread producer = new Thread(() -> {
            int n = 0;
            while (true) {
                try {
                    queue.put(n + "");
                    System.out.println("生产元素" + n);
                    n ++;
                    // Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    String n = queue.take();
                    System.out.println("消费元素" + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
