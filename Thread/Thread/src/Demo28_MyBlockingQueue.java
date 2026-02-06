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

    public void put(String elem) {
        synchronized (this) {
            // 判满
            if (size >= data.length) {
                return;
            }
            data[tail++] = elem;
            if (tail >= data.length) {
                tail = 0;
            }
            size ++;
        }
    }

    public String take() {
        synchronized (this) {
            // 判空
            if (size == 0) {
                return null;
            }
            String ret = data[head++];
            if (head >= data.length) {
                head = 0;
            }
            size --;
            return ret;
        }
    }
}

public class Demo28_MyBlockingQueue {
    public static void main(String[] args) {

    }
}
