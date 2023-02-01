import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 要求：使用BufferedReader读取一个文本文件，为每行加上行号再连同内容一并输出到屏幕上
 */
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String data = "";
        int lineNumber = 0;
        while ((data = bufferedReader.readLine()) != null) {
            System.out.println(++lineNumber + " " + data);
        }
    }
}
