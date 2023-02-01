import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public void create01() throws IOException {
        String filePath = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/1.txt";
        // new File(String pathname) //根据路径构建一个File对象
        File file = new File(filePath);
        // 磁盘写入文件
        System.out.println(file.createNewFile());
        System.out.println("File created successfully...");

    }
    @Test
    public void create02() throws IOException {

        // 父路径
        String parentFile = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src";
        // 父文件对象
        File parent = new File(parentFile);
        // 子路径
        String fileName = "2.txt";
        // 根据父目录文件+子路径构建
        File file = new File(parentFile,fileName);
        System.out.println(file.createNewFile());
        System.out.println("File created successfully...");
    }
    @Test
    public void create03() throws IOException {
        // 父路径
        String parentFile = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src";
        // 子路径
        String filename = "3.txt";
        // 根据父目录+子路径构建
        File file = new File(parentFile, filename);
        System.out.println(file.createNewFile());
        System.out.println("File created successfully...");

    }
}
