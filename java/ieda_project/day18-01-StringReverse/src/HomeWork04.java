/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        // 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
        String str = "12345678dsf.,$3dsHKHGGGSDSssdjsytiuhjkhngbdf";
        try {
            printChar(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void printChar(String str) {
        char[] ch = str.toCharArray();
        int c = 0, upper = 0, lower = 0, o = 0;
        if (str == null) {
            throw new RuntimeException("Invalid character");
        }
        for (char value : ch) {
            if (value >= 'a' && value <= 'z') {
                System.out.println("小写字母: " + value);
                lower++;
            } else if (value >= 'A' & value <= 'Z') {
                System.out.println("大写字母: " + value);
                upper++;
            } else if (value >= '0' && value <= '9') {
                System.out.println("数字: " + value);
                c++;
            } else {
                System.out.println("其它字符: " + value);
                o++;
            }
        }
        System.out.println("小写字母: " + lower + '个');
        System.out.println("大写字母: " + upper + '个');
        System.out.println("数字: " + c + '个');
        System.out.println("其它字符: " + o + '个');
    }
}
