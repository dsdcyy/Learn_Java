import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class SuppressWarnings {
    // 在{}填上需要抑制的类型
    @java.lang.SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 不希望开到黄色提示
        // @SuppressWarnings：抑制编译器警告
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        System.out.println(list.get(1));

    }
}
