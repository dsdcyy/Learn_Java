import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) {
    }
    @Test
    public void read() throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia.txt";
        // 创建BufferedReader对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // 读取数据
        String line;
        // readLine() 按行读取，返回为空时读取完毕
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        // 关闭流，只需要关闭BufferedReader流，底层会自动去关闭FileReader流
        /*
        * public void close() throws IOException {
                synchronized(this.lock) {
                    if (this.in != null) {
                        try {
                            this.in.close();
                        } finally {
                            this.in = null;
                            this.cb = null;
                        }

                    }
                }
            }
        * */
        bufferedReader.close();
    }
}
