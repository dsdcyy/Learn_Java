/**
 * @author ljw
 * @version 1.0
 */
public class MathMethod {
    public static void main(String[] args) {
        // abs 返回绝对值
        System.out.println(Math.abs(-1));
        System.out.println(Math.abs(1));
        System.out.println(Math.abs(1.0));
        // pow 求幂
        System.out.println(Math.pow(3, 4));
        // ceil 返回大于该参数的最小整数，转成double
        System.out.println(Math.ceil(3.9));
        System.out.println(Math.ceil(-3.9));
        // floor 返回小于该参数的最大整数转成double
        System.out.println(Math.floor(3.9));
        System.out.println(Math.floor(-3.9));
        // round 四舍五入取整
        System.out.println(Math.round(3.9));
        System.out.println(Math.round(3.1));
        // sqrt 开方
        System.out.println(Math.sqrt(4));
        // random 返回[0,1)之间的小数
        System.out.println(Math.random());
        // 返回[a,b)之间的整数，a,b为整数
        for (int i = 0; i < 10; i++) {
            System.out.println(randomInt(2, 8));
        }
        // min 返回最小值
        System.out.println(Math.min(3,8));
        // max 返回最小值
        System.out.println(Math.max(3,8));

    }

    public static int randomInt(int start, int end) {
        return start + (int) (Math.random() * (end - start));
    }

}
