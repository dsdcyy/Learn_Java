import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 * 要求验证是不是整数或小数
 */
public class HomeWork02 {
    public static void main(String[] args) {
        String content = "0.34";
        String pattern = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        System.out.println(content.matches(pattern));
    }
}
