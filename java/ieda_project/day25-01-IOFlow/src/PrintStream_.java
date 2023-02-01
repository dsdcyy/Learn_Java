import java.io.IOException;
import java.io.PrintStream;

/**
 * @author ljw
 * @version 1.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        // System.out 的编译类型就是PrintStream
        PrintStream out = System.out;
        // 默认情况下PrintStream输出的位置是标准输出及显示器
        out.println("哈哈..");
        // 使用write打印,本质是一样的
        out.write("ljw".getBytes());
        // 修改打印流输出的位置/设备
        System.setOut(new PrintStream("/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/nvidia3.txt"));
        System.out.println("baidu.com");
        //  public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out);
        //    }
        out.close();
    }
}
