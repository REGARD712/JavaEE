import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo35_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 此处 Callable 只是定义了一个 "带有返回值" 的任务!
        // 并没有真的在执行. 执行还是需要搭配 Thread 对象.
        Callable<Integer> callable = new Callable<Integer>() {
            int count = 0;
            @Override
            public Integer call() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    count += i;
                }
                return count;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callable);

        Thread t = new Thread(task);
        t.start();

        // get 操作就是获取到 FutureTask 的返回值. 这个返回值就来自于 Callable 的 call 方法.
        // get 可能会阻塞. 如果当前 线程 执行完毕, get 拿到返回结果.
        // 如果当前线程还没执行完毕, get 会一直阻塞.
        System.out.println(task.get());
    }
}
