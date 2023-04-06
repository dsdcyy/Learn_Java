import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class BackReference {
    public static void main(String[] args) {
        // 1. 匹配两个连续的相同数字
        System.out.println("匹配两个连续的相同数字");
        String content = "112233";
        String pattern = "(\\d)\\1";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        printFind(matcher);
        System.out.println("要匹配五个连续相同的数字");
        // 2.要匹配五个连续相同的数字
        content = "1111122444455555";
        pattern = "(\\d)\\1{4}";
        compile = Pattern.compile(pattern);
        matcher = compile.matcher(content);
        printFind(matcher);
        // 3.要匹配各位与千位相同，十位与百位相同的数5225
        System.out.println("要匹配各位与千位相同，十位与百位相同的数");
        content = "1221134321219999";
        pattern = "(\\d)(\\d)\\2\\1";
        compile = Pattern.compile(pattern);
        matcher = compile.matcher(content);
        printFind(matcher);
        // 3.前面是个五位数,一个-然后是个九位数，连续3位数相同
        System.out.println("前面是个五位数,一个-然后是个九位数，连续3位数相同");
        content = "12345-111222333";
        pattern = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        compile = Pattern.compile(pattern);
        matcher = compile.matcher(content);
        printFind(matcher);
    }
    public static void printFind(Matcher matcher){
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
