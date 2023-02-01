import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class BufferedWriter_ {
    @Test
    public void write() throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia3.txt";
        // 创建BufferedReader对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入数据
        bufferedWriter.write("hello world!");
        // 插入一个换行符，会根据系统自行决定
        bufferedWriter.newLine();
        bufferedWriter.write("hello world!");
        bufferedWriter.write("\nhello world!");
        bufferedWriter.close();
        System.out.println("写入成功...");
    }
}
