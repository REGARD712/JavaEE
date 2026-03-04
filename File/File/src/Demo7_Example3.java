import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

// 扫描指定目录，并找到 名称或者内容中 包含指定字符的所有普通文件(不包含目录)
public class Demo7_Example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入要查找的目录
        System.out.println("请输入要搜索的目录路径：");
        String rootPath = in.next();
        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()) {
            System.out.println("目录不存在或者不是目录！");
            return;
        }
        System.out.println("请输入查找的关键字：");
        String keyword = in.next();
        // 递归目录
        scanDir2(rootFile, keyword);
    }

    private static void scanDir2(File rootFile, String keyword) {
        File[] files = rootFile.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            System.out.println("\n文件&目录：" + file.getAbsolutePath());
            if (file.isFile()) {
                // 是文件
                dealFile(file, keyword);
            } else {
                // 是目录，继续递归
                scanDir2(file, keyword);
            }
        }
    }

    private static void dealFile(File file, String keyword) {
        // 分：名称和内容 检查
        // 检查名称
        if (file.getName().contains(keyword)) {
            // 包含关键字
            System.out.println("文件：" + file.getAbsolutePath() + "名称包含关键字" + keyword);
            return;
        }
        // 检查内容：由于 keyword是字符串，故以字符流的方式读取文件
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new FileReader(file)) {
            while (true) {
                char[] data = new char[1024];
                int n = reader.read(data);
                if (n == -1) {
                    break;
                }
                stringBuilder.append(data, 0, n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 判断 stringBuilder中是否包含 keyword
        if (stringBuilder.indexOf(keyword) >= 0) {
            // 包含
            System.out.println("文件：" + file.getAbsolutePath() + "内容包含关键字" + keyword);
        }
        return;
    }
}
