import java.io.File;
import java.io.IOException;

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

    public static void main(String[] args) throws IOException {
        //File file = new File("C:/JAVA/JavaEE/test.txt");
        File file = new File("./test.txt");

        file.createNewFile();

        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
