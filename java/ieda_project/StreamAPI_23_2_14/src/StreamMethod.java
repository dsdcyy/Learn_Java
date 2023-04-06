import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ljw
 * @version 1.0
 */
public class StreamMethod {
    public static void main(String[] args) {
        Random random = new Random();
        // 1.筛选与切片
        int[] list = {1, 2, 45, 5, 3, 5, 3, 2, 4, 4, 54, 3, 2};
        IntStream stream = Arrays.stream(list);
        // e -> e > 20 筛选大于20的数
        stream.filter(e -> e > 20).forEach(System.out::print);
        System.out.println();
        // 截断流 limit(size) 使其元素不超过设置的值
        //  流被使用后需要重新生成 否则抛java.lang.IllegalStateException异常
        stream = Arrays.stream(list);
        stream.limit(3).forEach(System.out::print);
        System.out.println();
        stream = Arrays.stream(list);
        // skip(n) 跳过n个元素,返回n个后的元素
        stream.skip(2).forEach(System.out::print);
        System.out.println();
        // distinct 通过流所生成的元素的hashcode()和equals()去除重复元素
        stream = Arrays.stream(list);
        stream.distinct().forEach(System.out::print);
        System.out.println();
    }
}
