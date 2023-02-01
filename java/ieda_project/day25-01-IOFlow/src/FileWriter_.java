import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia2.txt";

        FileWriter fileWriter = null;
        try {
            // 获取对象
            fileWriter = new FileWriter(file,true);// 追加方式写入数据
            // 写入字符串
            fileWriter.write("\n风雨之后，必见彩虹");
            // 写入字符串的部分
            fileWriter.write("\n风雨之后，必见彩虹",0,5);
            // 写入单个字符
            fileWriter.write('b');
            // 写入char数组
            fileWriter.write(new char[]{'\n', 'c','d'});
            // 写入char数组的指定部分
            fileWriter.write(new char[]{'\n', 'c','d'},0,2);
            System.out.println("文件写入成功...");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            assert fileWriter != null;
            fileWriter.close();
        }
    }
}
