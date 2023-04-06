import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Regexp3 {
    public static void main(String[] args) {
        String pattern = "^[0-9]+[a-z]+$";
        String content = "123abc";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
