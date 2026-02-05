// 通过懒汉模式构造单例模式
class SingletonLazy {
    private static volatile SingletonLazy instance = null;
    private static Object locker = new Object();

    // get方法
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    // 构造方法
    private SingletonLazy() {

    }
}

public class Demo25_SingleTonLazy {
    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1 == s2);

        // SingletonLazy s3 = new SingletonLazy();
    }
}
