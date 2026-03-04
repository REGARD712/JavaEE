import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo4_BufferedStream {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("./test.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("hello bufferedWriter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
