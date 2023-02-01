import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() throws IOException {
        String filename = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/3.txt";
        // 创建FileOutputStream对象
        FileOutputStream fileOutputStream = null;
        try {
//            char[] chars = "hello world".toCharArray();
            // 写入内容会覆盖原内容
//            fileOutputStream = new FileOutputStream(filename);
            // 写入内容会被追加到文件末尾
            fileOutputStream = new FileOutputStream(filename, true);
            // 单个字符写入数组
//            for (char aChar : chars) {
//                fileOutputStream.write(aChar);
//            }
            // 直接写入字符数组
//            fileOutputStream.write("hello world".getBytes());
            // 写入字符数组的一部分
            fileOutputStream.write("\nhello world".getBytes(), 0, 6);
            System.out.println("数据写入成功...");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            assert fileOutputStream != null;
            fileOutputStream.close();
        }
    }
}
