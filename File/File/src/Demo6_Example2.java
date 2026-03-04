import java.io.*;
import java.util.Scanner;

// 进行普通文件的复制
public class Demo6_Example2 {
    public static void main(String[] args) {
        // 输入源文件和目标文件的路径
        Scanner in = new Scanner(System.in);
        System.out.println("请输入源文件路径：");
        String srcPath = in.next();
        System.out.println("请输入目标文件路径：");
        String destPath = in.next();
        // 将路径转为文件
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            // 源文件不存在
            System.out.println("源文件不存在或者不是文件！");
            return;
        }
        File destFile = new File(destPath);
        if (!destFile.getParentFile().isDirectory()) {
            // 目标文件所在目录不存在
            System.out.println("目标文件所在目录不存在！");
            return;
        }

        // 进行复制操作：一个读一个写
        try (InputStream inputStream = new FileInputStream(srcFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {
            while (true) {
                // 从源文件中读取
                byte[] data = new byte[1024];
                int n = inputStream.read(data);
                if (n == -1) {
                    // 读取完成
                    break;
                }
                // 按照读取到的字节数 n来写入
                outputStream.write(data, 0, n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
