import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 * 字符串使用正则表达式案例
 */
public class StringReg {
    public static void main(String[] args) {
        // 替换功能
//        public String replaceAll(String regex,String replacement)
        // 将jdk1.3,1.4替换为JDK
        String content = "jdk1.3,jdk1.4,jdk1.3,jdk1.4,jdk1.5,jdk1.6";
        content = content.replaceAll("jdk(?:1.3|1.4)","JDK");
        System.out.println(content);
        // 判断功能
//        public boolean matches(String regex)
        content = "13812345678";
        System.out.println(content.matches("^(13(?:8|9))\\d{8}"));
        // 分隔功能
//        public String[] split(String regex)
        content = "hello###abc-jack12smith~北京";
        String[] split = content.split("#+|-+|~+|\\d+");
        System.out.println(Arrays.toString(split));


    }
}
