import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author ljw
 * @version 1.0
 */
public class BufferedCopy {
    @Test
    public void copy() throws IOException {
        String source = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia.txt";
        String dest = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia4.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
        System.out.println("文件写入成功...");
    }
}
