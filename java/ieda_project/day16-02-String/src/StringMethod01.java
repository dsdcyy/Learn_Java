/**
 * @author ljw
 * @version 1.0
 */
public class StringMethod01 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "hello";
        String s3 = " hello ";
        // 区分大小写，判断内容是否相等
        System.out.println(s1.equals(s2));
        // 忽略大小写的判断内容是否相等
        System.out.println(s1.equalsIgnoreCase(s2));
        // 获取字符的个数，字符串的长度
        System.out.println(s1.length());
        // 获取字符在字符串中第1次出现的索引，索引从0开始，如果找不到，返回-1
        System.out.println(s1.indexOf('l'));
        // 获取字符在字符串中最后1次出现的索引，索引从0开始，如找不到，返回-1
        System.out.println(s1.lastIndexOf('l'));
        // 截取指定范围的子串
        System.out.println(s1.substring(1,3));
        // 去前后空格
        System.out.println(s3.trim() + "s");
        // charAt:获取某素引处的字符，注意不能使用Str[index]这种方式
        System.out.println(s1.charAt(3));
    }
}
