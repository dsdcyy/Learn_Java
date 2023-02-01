/**
 * @author ljw
 * @version 1.0
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        try {
            String str = "1";
            // 1.如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块
            // 2.如果异常没有发生，则顺序执行try的代码块，不会进入到catch
            int a = Integer.parseInt(str);
            System.out.println("数字: " + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息： " + e.getMessage());
        } finally {
            System.out.println("我一定会执行...");
        }
        System.out.println("程序继续执行...");
    }
}

