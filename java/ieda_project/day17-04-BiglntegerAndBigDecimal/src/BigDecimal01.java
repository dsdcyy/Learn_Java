import java.math.BigDecimal;

/**
 * @author ljw
 * @version 1.0
 */
public class BigDecimal01 {
    public static void main(String[] args) {
        double d = 3.44646453353546757D;
        System.out.println(d);
        // BigDecimal
        BigDecimal bigDecimal = new BigDecimal("33535.589785564954358377564");
        System.out.println("bigDecimal = " + bigDecimal);
        // 算数方法和BigInteger一样，注意除法无法除尽的问题
        // 除法指定精度 BigDecimal.ROUND_CEILING 保留分子精度
        System.out.println(bigDecimal.divide(new BigDecimal("1.1"),BigDecimal.ROUND_CEILING));
    }
}
