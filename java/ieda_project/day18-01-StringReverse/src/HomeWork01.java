import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        //（1）将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
        //（2) 编写方法 public static String reverse(String str int start,int end)搞定
        String str = "abcdefghijkl";
        System.out.println("交换前:" + str);
        try {
            System.out.println("交换后: " + reverse(str, 2, 8));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {

        if (!(str != null && end < str.length() && start > 0 && start < end)) {
            throw new RuntimeException("错误,传入参数不符合交换条件,不进行交换");
        }
        char[] ch = str.toCharArray();
        char temp;
//        for (int i = start ,j = end; i < j; i++ ,j++) {
//            temp = ch[i];
//            ch[i] = ch[j];
//            ch[j] = temp;
//        }
        for (int i = 0; i < (end - start + 1) >> 1; i++) {
            temp = ch[start + i];
            ch[start + i] = ch[end - i];
            ch[end - i] = temp;
        }
        return new String(ch);
    }
}
