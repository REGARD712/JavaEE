import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPEchoServer {
    // 服务器专用socket
    private ServerSocket serverSocket = null;
    // 构造方法
    public TCPEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");

        // 这里不适用固定线程的线程池，因为客户端的数目是不固定的
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
//            // 先建立与客户端的链接，若客户端没有发来链接就会阻塞
//            Socket clientSocket = serverSocket.accept();
//            // 然后处理请求并返回响应
//            processConnection(clientSocket);
            // 但是该服务器无法同时给多个客户端提供服务

//            // 多线程解决主线程每次只能accept一个客户端的问题
//            Socket clientSocket = serverSocket.accept();
//            // 主线程每accept一个客户端，就创建一个线程，让该线程去负责处理当前客户端的请求
//            Thread t = new Thread(() -> {
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            t.start();
            // 当客户端数目过大时，资源消耗大

            // 线程池解决资源消耗大的问题
            Socket clientSocket = serverSocket.accept();
            // 将任务通过submit方法上传至线程池
            executorService.submit(() -> {
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
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
                writer.flush();  // 刷新缓冲区确保写入网卡
                // 4. 打印日志
                System.out.printf("[%s:%d] req: %s, resp: %s\n", clientSocket.getInetAddress(), clientSocket.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
           try {
               clientSocket.close();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
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
