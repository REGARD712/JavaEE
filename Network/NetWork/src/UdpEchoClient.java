import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;

    // 由于UDP不保存对端的信息，因此创建变量保存一下目的ip和目的端口
    private String serverIp;
    private int serverPort;

    // 构造方法要指定目的ip和目的端口
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();  // 这里实例化对象要用无参的构造方法，让系统自动分配端口号
    }

    public void start() throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的内容：");
            // 若用户没有输入信息就退出
            if (!in.hasNext()) {
                break;
            }
            // 1. 从控制台中读取用户输入的信息
            String request = in.next();
            // 2. 构造 DatagramPacket对象，并发送给服务器
            //    构造过程中除了载荷，还有服务器的ip和端口号
            //    这里的服务器ip的设置需要通过InetAddress转换一下
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            // 3. 发送数据报
            socket.send(requestPacket);
            // 4. 接收服务器的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            // 5. 解析响应信息并打印
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
