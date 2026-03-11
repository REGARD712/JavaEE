import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    // 构造方法
    public UdpEchoServer(int port) throws SocketException {
        // 指定端口号
        socket = new DatagramSocket(port);
    }

    // 启动服务器，然后处理请求
    public void start() throws IOException {
        System.out.println("服务器启动");

        while (true) {
            // 处理请求，分为三步骤

            // 1. 读取请求并解析
            //    使用一个 DatagramPacket表示 UDP的数据报，传入字节数组用于保存 UDP的载荷部分
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //    把读取到的二进制数据转成字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2. 根据请求计算响应（最重要最关键的逻辑）
            //    此处写的是回显服务器，只需要把接收的直接返回即可
            String response = process(request);

            // 3. 将响应返回给客户端
            //    根据字符串response构造 DatagramPacket数据报，返回给客户端
            //    此处第二个参数必须是response.getBytes().length()，不能是response.length()
            //    由于UDP不会包含客户端信息，因此需要指定目的ip和目的端口
            //    在接收到的requestPacket中有源ip和源端口，作为responsePacket的目的ip和目的端口
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            // 4. 打印日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(), requestPacket.getPort(),
                    request, response);
        }
    }
    // 后续若写别的服务器，只修改这里即可
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
