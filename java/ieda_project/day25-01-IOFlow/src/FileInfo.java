import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author ljw
 * @version 1.0
 */
public class FileInfo {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        File file = new File("/home/Ljw/Downloads/linux.txt");
        // 获取文件名 getName()
        System.out.println("文件名: " + file.getName());
        // 文件绝对路径 getAbsolutePath()
        System.out.println("文件绝对路径: " + file.getAbsolutePath());
        // 文件父级目录  file.getParentFile()
        System.out.println("文件父级目录：" + file.getParentFile());
        // 文件大小 字节 length
        System.out.println("文件大小(字节数): " + file.length());
        // 文件是否存在
        System.out.println("文件是否存在: " + file.exists());
        // 是不是一个文件
        System.out.println("是不是一个文件： " + file.isFile());
        // 是不是一个目录
        System.out.println("是不是一个目录： " + file.isDirectory());
    }
}
