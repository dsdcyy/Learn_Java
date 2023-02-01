/**
 * @author ljw
 * @version 1.0
 */
public class InputAndOutput {
    public static void main(String[] args) {
        // System类的public final static InputStream in = null;
        // System.in 编译类型 InputStream
        // System.in 运行类型 BufferedInputStream

        // public static final PrintStream out;
        // System.out  编译类型 PrintStream
        // System.out  运行类型 PrintStream
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
    }
}
