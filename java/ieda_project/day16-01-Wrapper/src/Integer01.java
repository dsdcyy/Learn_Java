/**
 * @author ljw
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        // jdk前手动装箱
        // 手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        // 手动拆箱
        int n2 = integer.intValue();

        //jdk5后，自动装箱和拆箱
        // 自动装箱
        Integer integer2 = n1;

        // 自动拆箱
        int n3 = integer1;

    }
}
