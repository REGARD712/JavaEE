import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UDPDictServer extends UdpEchoServer {
    private HashMap<String, String> dict = new HashMap<>();
    public UDPDictServer(int port) throws SocketException {
        super(port);

        // 初始化词典
        dict.put("小猫", "cat");
        dict.put("小狗", "dog");
        dict.put("小鱼", "fish");
        dict.put("小鸭", "duck");
        dict.put("小猴", "monkey");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "未找到该词典");
    }

    public static void main(String[] args) throws IOException {
        UDPDictServer server = new UDPDictServer(9090);
        server.start();
    }
}
