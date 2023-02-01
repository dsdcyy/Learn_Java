/**
 * @author ljw
 * @version 1.0
 */
public class StringBufferAndString {
    public static void main(String[] args) {
        // String -> StringBuffer
        String str = "hello tom";
        //1.构造器
        StringBuffer stringBuffer = new StringBuffer(str);
        //2.append方法
        StringBuffer stringBuffer2 = new StringBuffer().append(str);

        // StringBuffer -> String
        // 1.toString方法
        StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
        String str2 = stringBuffer3.toString();
        System.out.println("str2 = " + str2);
        // 2.使用构造器
        String str3 = new String(stringBuffer3);
        System.out.println("str3 = " + str3);
    }
}
