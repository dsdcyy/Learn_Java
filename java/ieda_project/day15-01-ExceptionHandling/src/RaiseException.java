/**
 * @author ljw
 * @version 1.0
 */
public class RaiseException {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        // 除零错误，抛出异常,程序崩溃，代码不再执行
        // java.lang.ArithmeticException / by zero
        // 解决方法 异常捕获
        // alt + t
        int res = 0;
        try {
            res = num1 / num2;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("我一定会执行...");
        }

        System.out.println(res);

        System.out.println("程序继续执行");
    }
}
