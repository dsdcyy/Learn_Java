import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class StringMethod02 {
    public static void main(String[] args) {
        String str = "Hello World";
        String str3 = "Hello World";
        String str2 = "And Java";

        // 字符串转大写
        System.out.println(str.toUpperCase());
        // 字符串转小写
        System.out.println(str.toLowerCase());
        // 字符串连接
        System.out.println(str.concat(str2));
        // 替换字符串中的字符
        System.out.println(str.replace('l','a'));
        // 分割字符串，对于某些分割字符，我们需要转义比如/\等
        System.out.println(Arrays.toString(str.split("l")));
        //  比较两个字符串的大小 比较不同字符串的差值，如果均一致则比较长度差值
        System.out.println(str.compareTo(str2));
        System.out.println(str.compareTo(str3));
        // 转换成字符数组
        System.out.println(str.toCharArray());
        // 格式字符串，%s字符串 %c字符 %d整型 %.2f浮点型,使用四舍五入
        String  name = "john";
        int age = 10;
        double score = 98.3 / 3;
        char gender = '男';
        String formatStr = "我的姓名是%s,年龄是%d,成绩是%.2f,性别是%c";
        String info = String.format(formatStr,name,age,score,gender);
        System.out.println(info);
    }
}
