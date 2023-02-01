/**
 * @author ljw
 * @version 1.0
 */
public class StringBuilder01 {
    public static void main(String[] args) {
        // 和StringBuffer的类关系一致
        
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("world");
        System.out.println(sb.toString());
        System.out.println(sb.toString().length());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
