// 饿汉模式
class SingleTonHungry {
    private static SingleTonHungry instance = new SingleTonHungry();

    public static SingleTonHungry getInstance() {
        return instance;
    }

    // 设置为 private，在该类外创建实例时调用，但是会编译失败
    private SingleTonHungry() {

    }
}

public class Demo24_SingleTonHungry {
    public static void main(String[] args) {
        SingleTonHungry s1 = SingleTonHungry.getInstance();
        SingleTonHungry s2 = SingleTonHungry.getInstance();
        // 两个引用变量指向的是同一个对象
        System.out.println(s1 == s2);

        // SingleTonHungry s3 = new SingleTonHungry();
    }
}
