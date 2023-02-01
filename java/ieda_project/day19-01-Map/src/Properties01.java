import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("jack",100);
        properties.put("marry",200);
        properties.put("smith",300);
        System.out.println(properties);
        // 通过key返回值 get
        System.out.println(properties.get("jack"));
        // 删除 remove
        System.out.println(properties.remove("marry"));
        // 修改
        properties.put("jack",400);
        System.out.println(properties);
    }
}
