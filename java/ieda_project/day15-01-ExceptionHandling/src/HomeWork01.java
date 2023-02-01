/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对...");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            int res = cal(n1,n2);
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确...");
        } catch (ArithmeticException e){
            System.out.println("计算除零...");
        }


    }
    public static int cal (int n1, int n2){
        try {
            int res = n1 / n2;
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
}
