import java.io.*;

public class Demo3_CharStream {
    public static void main1(String[] args) {
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

    public static void main2(String[] args) {
        try (Writer writer = new FileWriter("./test.txt", true)) {
            writer.write(" Java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
