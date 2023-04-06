import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 * 解析url地址
 */
public class HomeWork03 {
    public static void main(String[] args) {
        String url = "https://www.sohu.com:8080/abc/index.html";
        String pattern = "^(?<protocol>http[s]?)://(?<dm>(\\w+\\.)+[a-zA-Z]+):(?<port>\\d{1,5})/?(\\w+/)*(?<filename>\\w+\\.\\w+)*$";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(url);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println("协议: " + matcher.group("protocol"));
            System.out.println("域名: " + matcher.group("dm"));
            System.out.println("端口: " + matcher.group("port"));
            System.out.println("文件名: " + matcher.group("filename"));
        }
    }
}
