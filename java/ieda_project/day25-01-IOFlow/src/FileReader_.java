import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia.txt";
        int data = 0;
        try {
            // 获取FileReader对象
            fileReader = new FileReader(file);
            // 单个字符进行读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert fileReader != null;
            fileReader.close();
        }
    }
    @Test
    public void readerFile() throws IOException {
        FileReader fileReader = null;
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia.txt";
        char[] chars = new char[8];
        int data = 0;
        try {
            // 获取FileReader对象
            fileReader = new FileReader(file);
            // 根据字符数组进行循环读取
            while ((data = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0,data));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert fileReader != null;
            fileReader.close();
        }
    }
}
