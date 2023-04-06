import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ljw
 * @version 1.0
 */
public class Stream_ {
    public static void main(String[] args) {
        // 创建Stream方式一，通过集合
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // default Stream<E> stream() 返回一个顺序流
        Stream<Integer> stream = list.stream();

        // Stream<E> stream() parallelStream 返回一个并行流
        Stream<Integer> parallelStream = list.parallelStream();

        // 方式二 通过数组
        int[] arr = {1, 2, 3, 4, 5, 6};
        // 调用Arrays类的stream方法
        IntStream stream1 = Arrays.stream(arr);

        // 方式三 通过Stream的of
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        // 方式四 创建无限流 limit 迭代次数  forEach 终止操作
        Stream.iterate(0, t -> t + 2).limit(100).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        System.out.println("================================");
        // 自定义迭代条件
        Stream.iterate(0,t->t<10,t->t+1).forEach(System.out::println);
    }
}
