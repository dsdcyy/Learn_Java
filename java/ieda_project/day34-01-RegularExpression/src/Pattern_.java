import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Pattern_ {
    public static void main(String[] args) {
        // matches
        /*
        *  public static boolean matches(String regex, CharSequence input) {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(input);
                return m.matches();
            }
        * */
        String pattern = "^\\d+";
        String content = "123";
        // matches(String pattern, CharSequence content)
        boolean matches = Pattern.matches(pattern, content);
        System.out.println(matches);
    }
}
