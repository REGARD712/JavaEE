import java.io.*;

public class Demo2_ByteStream {
    public static void main1(String[] args) throws IOException {
//        // 创建了对象就相当于打开了文件，需要在读写完文件后手动调用 close方法
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("./test.txt");
//        } finally {
//            // 可能由于某种原因，不会执行到 close方法，用 finally语句
//            inputStream.close();
//        }
        // 上述写法太丑，因此采用 try with resources
        // 这种写法出了 try代码块后会自动执行 close方法（对于实现了 Closable的类）
//        try (InputStream inputStream = new FileInputStream("./test.txt")) {
//
//        }
        // 也可以有多个对象
//        try (InputStream inputStream = new FileInputStream("./test.txt");
//             InputStream inputStream2 = new FileInputStream("./test2.txt")) {
//
//        }
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            // 循环读取文件
            while (true) {
//                // 一次读取一个字节，返回值是字节值，为-1时表示到达文件末尾或异常结束
//                int data = inputStream.read();
//                // 校验
//                if (data == -1) {
//                    // 文件读完
//                    break;
//                }
//                System.out.println(data);   // 打印英文
//                System.out.printf("0x%x\n", data);  // 打印汉字(utf-8)

                // 一次读取多个字节
                byte[] data = new byte[1024];
                // 读操作会尽可能把字节数组填满
                // 返回值表示实际读取的字节数
                int n = inputStream.read(data);
                System.out.println("n = " + n);
                if (n == -1) {
                    // 文件读完
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("0x%x\n", data[i]);
                }
                System.out.println("=========================");
            }
        }
    }

    public static void main(String[] args) {
//        try (OutputStream outputStream = new FileOutputStream("./test.txt")) {
//            // 写入文件，一次写入一个字节
////            outputStream.write(97);
////            outputStream.write(98);
////            outputStream.write(99);
//            // 一次写入多个字节
//            byte[] data = {102, 99, 110};
//            outputStream.write(data);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        // 追加写入，不会覆盖之前的内容
        try (OutputStream outputStream = new FileOutputStream("./test.txt", true)) {
            // 写入文件，一次写入一个字节
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);
            // 一次写入多个字节
            byte[] data = {102, 99, 110};
            outputStream.write(data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
