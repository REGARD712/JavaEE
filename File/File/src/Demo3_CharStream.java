import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo3_CharStream {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("./test.txt")) {
            while (true) {
                int c = reader.read();
                if (c == -1) {
                    break;
                }
                System.out.println((char)c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
