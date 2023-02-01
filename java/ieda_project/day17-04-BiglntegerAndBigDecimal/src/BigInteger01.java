import java.math.BigDecimal;

/**
 * @author ljw
 * @version 1.0
 */
public class BigInteger01 {
    public static void main(String[] args) {
        long l = 2255758446657L;
        System.out.println("l = " + l);
        BigDecimal bigDecimal = new BigDecimal("22222449565744446575776");
        // 对BigDecimal类进行加减乘除时，需要使用对应的方法
        // 加 add
        System.out.println(bigDecimal.add(new BigDecimal(10)));
        // 减 subtract
        System.out.println(bigDecimal.subtract(new BigDecimal(10)));
        // 乘 multiply
        System.out.println(bigDecimal.multiply(new BigDecimal(10)));
        // 除 divide
        System.out.println(bigDecimal.divide(new BigDecimal(10)));
    }
}
