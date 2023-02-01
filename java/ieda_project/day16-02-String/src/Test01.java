/**
 * @author ljw
 * @version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == b.intern());
        System.out.println(b == b.intern());
    }
}
