import java.io.File;
import java.util.Scanner;

// 扫描指定目录，并找到名称中包含指定字符的所有普通文件(不包含目录)，并且后续询问用户是否要删除该文件
public class Demo5_Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要搜索的目录：");
        String rootDir = in.next();
        File rootFile = new File(rootDir);
        if (!rootFile.isDirectory()) {
            System.out.println("输入的不是目录！");
            return;
        }
        System.out.println("请输入要删除的关键字：");
        String keyword = in.next();
        // 递归搜索目录
        scanDir(rootFile, keyword);
    }

    private static void scanDir(File rootFile, String keyword) {
        // 将当前目录中的所有内容存入数组
        File[] files = rootFile.listFiles();
        if (files == null) {
            // 当前目录为空
            return;
        }
        // 遍历数组
        for (File file : files) {
            System.out.println("\n文件&目录：" + file.getAbsolutePath());
            if (file.isFile()) {
                // 是文件，判断是否要删除
                deleteFile(file, keyword);
            } else {
                // 是目录，继续递归
                scanDir(file, keyword);
            }

        }
    }

    private static void deleteFile(File file, String keyword) {
        if (file.getName().contains(keyword)) {
            // 包含关键字，询问是否删除
            System.out.println("\n" + "发现文件" + file.getAbsolutePath() + "包含关键字" + keyword + "，是否删除？是（y）否（n）：");
            Scanner in = new Scanner(System.in);
            String check = in.next();
            if (check.equalsIgnoreCase("y")) {
                file.delete();
                System.out.println("文件已删除！");
            }
        }
    }
}
