import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 完成文件拷贝
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        // 1.创建文件的输入流，将文件读入到程序
        // 2.创建文件的输出流，将程序写入到文件
        String fileName = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/girlAlisa.jpg";
        String fileName2 = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/girlAlisa2.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        int data = 0;
        byte[] dataBytes = new byte[1024]; // 字节数组
        try {
            fileInputStream = new FileInputStream(fileName);
            fileOutputStream = new FileOutputStream(fileName2);
            while ((data = fileInputStream.read(dataBytes)) != -1) {
                // 一定要使用每次写入对应长度字节的方法
                fileOutputStream.write(dataBytes,0,data);
            }
            System.out.println("文件复制成功...");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            assert fileInputStream != null;
            fileInputStream.close();
            assert fileOutputStream != null;
            fileOutputStream.close();
        }
    }
}
