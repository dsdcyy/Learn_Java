import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Matcher_ {
    public static void main(String[] args) {
        String content = "hello ljw教育 jack ljw老师 ljw同学hello ljwhaha";
        // 非捕获匹配 (?:PATTERN) 匹配pattern但不捕获该匹配的子表达式
//        String pattern = "ljw(?:教育|老师|同学)";
        // 非捕获匹配 (?=PATTERN) 匹配pattern如未匹配到，前字符不会输出 ljwhaha 的ljw不会输出
//        String pattern = "ljw(?!教育|老师|同学)";
        // 非捕获匹配 (?!PATTERN) 与(?=PATTERN)相反
        String pattern = "ljw(?=教育|老师|同学)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("开始位置" + matcher.start());
            System.out.println("结束位置" + matcher.end());
            System.out.println(matcher.group(0));
        }
        // matcher.matches() 整体匹配，返回bool值
        System.out.println(matcher.matches());
        // 替换匹配字符 replaceAll(替换字符)
        pattern = "ljw";
        // pattern 匹配规则
        compile = Pattern.compile(pattern);
        matcher = compile.matcher(content);
        // 返回的字符串才是被替换的字符串，原字符串不会被改变
        String li = matcher.replaceAll("李");
        System.out.println(li);
    }
}
