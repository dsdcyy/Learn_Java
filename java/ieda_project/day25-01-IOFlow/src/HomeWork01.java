import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * （1）在判断e盘下是否有文件夹myTemp，如果没有就创建myTemp
 * （2）在e:\\mytemp目录下，创建文件hello.txt
 * （3）如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
 * (4) 在文件里写入hello world 内容
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/myTemp";
        File file1 = new File(file);
        if (file1.exists()) {
            System.out.println("File exists");
        } else {
            if(file1.mkdir()) {
                System.out.println("文件夹创建成功...");
            } else {
                System.out.println("文件创建失败...");
            }
        }
        File file2 = new File(file, "hello.txt");
        if (file2.exists()) {
            System.out.println("File exists");
            return;
        }
        if (file2.createNewFile()) {
            System.out.println("文件创建成功...");
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write("hello world");
            fileWriter.close();
            System.out.println("文件写入数据成功...");
        }
    }
}
