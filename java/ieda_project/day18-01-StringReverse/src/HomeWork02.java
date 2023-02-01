import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        //输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
        //要求：
        //（1）用户名长度为2或3或4
        //（2）密码的长度为6，要求全是数字
        //（3）邮箱中包含@和.
        //并且@在.的前面isDigital
        try {
            register();
            System.out.println("Register successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Register failed");
        }
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String name = scanner.next();
        if (!(name != null && name.length() > 1 && name.length() < 5)) {
            throw new RuntimeException("Invalid name");
        }
        System.out.println("请输入密码: ");
        String passwd = scanner.next();
        if (!(passwd != null && passwd.length() == 6 && isDigital(passwd))) {
            throw new RuntimeException("Invalid passwd");
        }
        System.out.println("请输入邮箱: ");
        String email = scanner.next();
        if (!(email != null && email.contains("@") && email.contains(".") && email.indexOf("@") > 0 && email.indexOf("@") < email.indexOf("."))) {
            throw new RuntimeException("Invalid email");
        }
    }

    public static boolean isDigital(String str) {
//        try {
//            int i = Integer.parseInt(str);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//        return true;
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (!(c > 9)) {
                return false;
            }
        }
        return true;
    }
}
