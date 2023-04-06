
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class JieBa {
    public static void main(String[] args) {
        // 1. 我...我要...学学学学...编程java! ->我要学编程java
        System.out.println("我...我要...学学学学...编程java!");
        String content = "我...我要...学学学学...编程java!";
        // 去除点
        String pattern = "\\.";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        content = matcher.replaceAll("");
        System.out.println(content);
        // 匹配连续重复文字
//        pattern = "(.)\\1+";
//        compile = Pattern.compile(pattern);
//        matcher = compile.matcher(content);
//        // 外部引用反向引用进行替换 $1 代表被匹配到的字符
//        content = matcher.replaceAll("$1");
//        System.out.println(content);
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);

    }
}
