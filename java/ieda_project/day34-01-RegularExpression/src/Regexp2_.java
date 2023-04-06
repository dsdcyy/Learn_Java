import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Regexp2_ {
    public static void main(String[] args) {
        // a-z不区分大小写
//        String pattern = "(?i)[a-z]+";
        // a(?i)bc b-c不区分大小写
//        String pattern = "(?i)[bc]+";
        // a((?i)f)c 仅f不区分大小写
        String pattern = "a?((?i)f)c?";
        String content = "AbcFg";
        // Pattern.CASE_INSENSITIVE 指定参数不区分大小写 Pattern.compile(pattern,Pattern.CASE_INSENSITIVE)
//        Pattern compile = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
