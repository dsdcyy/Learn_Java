import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 演示FileInputStream的使用(字节输入流 文件-->程序)
 */
public class FileInputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String fileName = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/2.txt";
        //  职位里是为了扩大文件流的访问范围
        FileInputStream fileInputStream = null;
        int data = 0;  // 一个字节
        byte[] buf = new byte[8];  // 读取多个字节
        try {
            fileInputStream = new FileInputStream(fileName);
            // 读取一个字节的数据
            while ((data = fileInputStream.read(buf)) != -1) {
                // 返回实际读取字节数
                System.out.println(new String(buf, 0, data));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 断言判断文件流不为空
            assert fileInputStream != null;
            // 关闭文件流，释放资源
            fileInputStream.close();
        }
    }
}
