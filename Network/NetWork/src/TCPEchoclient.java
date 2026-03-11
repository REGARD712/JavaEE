import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoclient {
    private Socket socket = null;
    // 构造方法
    public TCPEchoclient(String serverIp, int serverPort) throws IOException {
        // 这里构造对象传入对端的ip和端口号，TCP内部就会记录下来对端信息
        socket = new Socket(serverIp, serverPort);
    }
    public void start() {
        // 从控制台获取到请求，发送给服务器
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            // 借助字符流操作对象来读写数据
            Scanner scannerNet = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                // 1. 读取输入
                System.out.println("请输入要发送的内容：");
                String request = scanner.next();
                // 2. 发送给服务器
                writer.println(request);
                writer.flush();  // 刷新缓冲区确保写入网卡
                // 3. 接收服务器的响应
                String response = scannerNet.next();
                // 4. 打印响应
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TCPEchoclient tcpEchoclient = new TCPEchoclient("127.0.0.1", 9090);
        tcpEchoclient.start();
    }
}
