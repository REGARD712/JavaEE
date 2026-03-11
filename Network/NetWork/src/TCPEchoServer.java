import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {
    // 服务器专业socket
    private ServerSocket serverSocket = null;
    // 构造方法
    public TCPEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            // 先建立与客户端的链接，若客户端没有发来链接就会阻塞
            Socket clientSocket = serverSocket.accept();
            // 然后处理请求并返回响应
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n", clientSocket.getInetAddress(), clientSocket.getPort());
        // 使用字节流读取数据
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            // 借助Scanner读取字节流可以直接得到字符
            Scanner scanner = new Scanner(inputStream);
            // 借助PrintWriter写入字符到输出流
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                // 分成三个步骤
                // 1. 读取请求并解析（可以read也可以使用Scanner）
                if (!scanner.hasNext()) {
                    // 与客户端断开连接
                    System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                String request = scanner.next();
                // 2. 根据请求计算响应，这里直接返回request
                String response = process(request);
                // 3. 返回响应给客户端（可以直接使用outputStream的write方法写入字节也可以借助PrintWriter直接写入字符）
                //outputStream.write(response.getBytes());
                writer.println(response);
                writer.flush();
                // 4. 打印日志
                System.out.printf("[%s:%d] req: %s, resp: %s\n", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TCPEchoServer tcpEchoServer = new TCPEchoServer(9090);
        tcpEchoServer.start();
    }
}
