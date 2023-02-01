import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author ljw
 * @version 1.0
 */
public class BufferedStreamCopy {
    @Test
    public void copy() throws IOException {
        String source = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/girlAlisa.jpg";
        String dest = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/girlAlisa3.jpg";
        // 创建BufferedInputStream对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
        // 创建BufferedOutputStream对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("文件复制成功...");
    }
}
