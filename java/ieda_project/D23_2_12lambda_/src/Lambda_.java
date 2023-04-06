import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @author ljw
 * @version 1.0
 */
public class Lambda_ {
    @Test
    public void test() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running...");
            }
        };
        r1.run();
    }

    @Test
    public void test2() {
        Runnable r2 = () -> System.out.println("Running2...");
        r2.run();
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        int compare = comparator.compare(12, 14);
        System.out.println(compare);
    }
    @Test
    public void test4() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        int compare = comparator.compare(14, 15);
        System.out.println(compare);
    }
    @Test
    public void test5() {
        // 方法引用
        Comparator<Integer> comparator = Integer::compare;
        int compare = comparator.compare(16, 17);
        System.out.println(compare);
    }
}
