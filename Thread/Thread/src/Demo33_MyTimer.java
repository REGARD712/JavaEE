import java.util.PriorityQueue;
import java.util.concurrent.Executors;

// 实现一个定时器
// 该类表示定时器中的任务
class MyTimerTask implements Comparable<MyTimerTask>{
    // 任务
    private Runnable task;
    // 记录任务执行的时刻
    private long time;

    // 构造方法
    public MyTimerTask(Runnable task, long time) {
        this.task = task;
        this.time = time;
    }

    // 定义比较规则，重写 compareTo方法
    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
        //return (int)(o.time - this.time);
    }

    public long getTime() {
        return this.time;
    }

    public void run() {
        task.run();
    }
}
// 基于抽象类方式定义任务类：较麻烦
/*
abstract class MyTimerTask2 implements Runnable {
    @Override
    public abstract void run();
}
 */

// 该类表示定时器
class MyTimer {
    // 用优先级队列来管理任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    // schedule方法将任务（task）和对应的执行时间（time）添加到优先级队列中进行管理
    public void schedule(Runnable task, long delay) {
        // 由于有多个任务在同一时刻添加进队列，原子性需要保障
        synchronized (this) {
            MyTimerTask myTimerTask = new MyTimerTask(task, System.currentTimeMillis() + delay);
            queue.offer(myTimerTask);
            // 添加了任务后唤醒执行任务的线程
            this.notify();
        }
    }

    // 构造方法
    public MyTimer() {
        // 创建一个线程，负责执行优先级队列中的任务
        Thread t = new Thread(() -> {
            try {
                while(true) {
                    // 为保障原子性，加锁
                    synchronized (this) {
                        // 取出队首元素
                        while (queue.isEmpty()) {
                            //continue;
                            // 若这里是 continue，当队列为空时会持续飞快地执行循环，造成 CPU资源的浪费
                            this.wait();
                        }
                        MyTimerTask task = queue.peek();

                        if (System.currentTimeMillis() < task.getTime()) {
                            // 若当前程序时间比任务规定的执行时间小，说明还未达到执行该任务的时机
                            // 让线程等待，等待时间为当前程序和规定时间的差值
                            this.wait(task.getTime() - System.currentTimeMillis());
                        } else {
                            // 否则执行任务
                            task.run();
                            queue.poll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}

public class Demo33_MyTimer {
    public static void main(String[] args) {
        // 测试定时器
        MyTimer myTimer = new MyTimer();

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        }, 3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        }, 2000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        }, 1000);

        System.out.println("hello main");

        Executors.newScheduledThreadPool(4);
    }
}
