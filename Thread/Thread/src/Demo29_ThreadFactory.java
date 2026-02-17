// 工厂模式：统一构造并初始化线程，具有多个不同的构造方法
// 例子：点位置的表示形式 1. x、y坐标表示法；2. 极坐标表示法
class Point {
    // 表示二维平面上的一个点
    private double x;  // 表示 x坐标的值
    private double y;  // 表示 y坐标的值
    private double r;  // 表示单位圆半径 r的值
    private double a;  // 表示单位圆半径 r与 x轴夹角的值

    // 不能设计多个构造方法
//    public Point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public Point(double r, double a) {
//        this.r = r;
//        this.a = a;
//    }
}

class PointFactory {
    // 提供了工厂方法的类 称为工厂类
    public static Point makePointByXY(double x, double y) {
        Point point = new Point();
        // 给 x和 y属性进行赋值
        return point;
    }

    public static Point makePointByRA(double r, double a) {
        Point point = new Point();
        // 给 r和 a属性进行赋值
        return point;
    }
}

public class Demo29_ThreadFactory {
    public static void main(String[] args) {
        Point point = PointFactory.makePointByXY(1.5, 2.0);
    }
}
