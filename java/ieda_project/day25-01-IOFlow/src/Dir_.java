import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class Dir_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        File file = new File("/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/3.txt");
        String filename = file.getName();
        if (file.exists()) {
            // 删除文件
            if (file.delete()) {
                System.out.println("删除文件: " + filename);
            } else {
                System.out.println("删除失败...");
            }


        } else {
            System.out.println(filename + "不存在...");
        }
    }

    @Test
    public void m2() throws IOException {
        File file = new File("/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/3");
        String filename = file.getName();
        if (file.exists()) {
            System.out.println(filename + "存在...");
            return;
        }
        System.out.println(filename + "不存在...");
        // mkdir 创建一级目录
        if (file.mkdir()) {
            System.out.println(filename + "创建成功...");
            return;
        }
        System.out.println(filename + "创建失败...");


    }
}
