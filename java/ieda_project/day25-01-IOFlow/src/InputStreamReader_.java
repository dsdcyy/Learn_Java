import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author ljw
 * @version 1.0
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/5.txt";
        // 字节流对象
        FileInputStream fileInputStream = new FileInputStream(file);
        // InputStreamReader 将字节流转换为字符流 参数1 InputStream对象 参数2 字符编码
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
        // 用Buffered读取字符流 inputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        // 关闭外层流即可
        bufferedReader.close();
    }
}
