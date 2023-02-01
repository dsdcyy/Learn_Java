import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ljw
 * @version 1.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        // 输出到屏幕
        PrintWriter printWriter = new PrintWriter(System.out);
        // 输出到文件
        PrintWriter printWriter2 = new PrintWriter(new FileWriter("/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/6.txt"));

        printWriter.println("haha");
        printWriter.close();
        printWriter2.println("Hello World!");
        printWriter2.close();
    }
}
