import java.io.*;

/**
 * @author ljw
 * @version 1.0
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/5.txt";
        // 字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // 通过outputStreamWriter转为字符流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
        // 通过bufferedWriter处理流写入gbk编码文件
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("你好,世界!");
        bufferedWriter.close();
    }
}
