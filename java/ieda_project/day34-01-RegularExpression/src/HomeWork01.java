/**
 * @author ljw
 * @version 1.0
 * 验证邮箱是否合法
 */
public class HomeWork01 {
    public static void main(String[] args) {
        // 规定电子邮件规则为
        /*
        * 1.只能有一个@
        * 2.@前面是用户名，可以是a-ZA-Z0-9-字符
        * 3.@后面是域名，并且域名只能是英文字母，比如sohu.com或者tsinghua.org.cn
4。
写出对应的正则表达式，验证输入的字符串是否为满足规则
        * */
        String content = "haha@sohu.com.cn";
        String pattern = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        System.out.println(content.matches(pattern));
        // matches
        /*
        *  public boolean matches(String regex) {
                return Pattern.matches(regex, this);
            }
        * */
    }
}
