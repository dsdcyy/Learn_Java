import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Regexp4_ {
    public static void main(String[] args) {
        String content = "hello ljw教育 jack ljw老师 ljw同学hello ljwhaha";
        // 非捕获匹配 (?:PATTERN) 匹配pattern但不捕获该匹配的子表达式
//        String pattern = "ljw(?:教育|老师|同学)";
        // 非捕获匹配 (?=PATTERN) 匹配pattern 并输出前字符,如未匹配到，前字符不会输出 ljwhaha 的ljw不会输出
//        String pattern = "ljw(?=教育|老师|同学)";
        // 非捕获匹配 (?!PATTERN) 与(?=PATTERN)相反
        String pattern = "ljw(?!教育|老师|同学)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
