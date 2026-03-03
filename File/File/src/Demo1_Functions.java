import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Demo1_Functions {
    public static void main1(String[] args) throws IOException {
        // 创建 File对象，传入绝对路径
        // File file = new File("C:/JAVA/JavaEE/test.txt");
        // 创建 File对象，传入相对路径：默认是在项目文件的根目录下
        File file = new File("./test.txt");

        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }

    public static void main2(String[] args) throws IOException {
        //File file = new File("C:/JAVA/JavaEE/test.txt");
        File file = new File("./test.txt");

        file.createNewFile();

        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }

    public static void main3(String[] args) {
        File file = new File("./test.txt");

        // 删除文件，返回值为布尔类型
        boolean result = file.delete();

        System.out.println(result);
    }

    public static void main4(String[] args) throws InterruptedException {
        File file = new File("C:/JAVA/JavaEE/test.txt");

        // 在进程结束时删除文件
        file.deleteOnExit();
        // 为了观察
        Thread.sleep(10000);
    }

    public static void main5(String[] args) {
        // 针对目录使用 list存储
        File file = new File("C:/");
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
    }

    public static void main6(String[] args) {
        // 针对文件使用 listFiles存储
        File file = new File("C:/");
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
    }

    public static void main7(String[] args) {
        // 使用 mkdir创建一级目录（无法创建多级目录）
        File file = new File("./test");
        boolean result = file.mkdir();
        System.out.println(result);
    }

    public static void main8(String[] args) {
        File file = new File("./test/1/2/3");
        boolean result = file.mkdirs();
        System.out.println(result);
    }

    public static void main9(String[] args) {
        File file = new File("./test");
        File newFile = new File("./src/test");
        // 将file的文件名改成newFile，可以看作将file移动到了newFile
        boolean result = file.renameTo(newFile);
        System.out.println(result);
    }

    public static void main10(String[] args) {
        File file = new File("./test.txt");
        boolean result = file.canRead();
        System.out.println(result);
    }

    public static void main11(String[] args) {
        File file = new File("./test.txt");
        boolean result = file.canWrite();
        System.out.println(result);
    }
}
