import java.util.LinkedHashSet;

/**
 * @author ljw
 * @version 1.0
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        // 分析底层机制
        LinkedHashSet<Object> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        set.add(new String("b"));
        set.add(new Custom("jack",1000));
        System.out.println(set);

    }
}

class Custom {
    private String name;
    private int id;

    public Custom(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}