import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author ljw
 * @version 1.0
 */
public class StreamMethod2 {
    public static void main(String[] args) {
        // map(function f) 接收一个函数作为参数，将元素转换成其它形式获提取数据
        int[] list = {1, 2, 45, 5, 3, 5, 3, 2, 4, 4, 54, 3, 2};
        IntStream stream = Arrays.stream(list);
        stream.map(e -> e * 2).forEach(System.out::println);
        System.out.println("==========================");
        stream = Arrays.stream(list);
        stream.flatMap(e -> IntStream.of(e + 10)).forEach(System.out::println);
        System.out.println("==========================");
        // 排序
        stream = Arrays.stream(list);
        stream.sorted().forEach(System.out::println); // 自然排序
    }

    @Test
    public void testVar() {
        var a = 10;
        var b = 20;
        var c = a + b;
        System.out.println(c);
        Supplier<Double> sup = Math::random;
    }
}
