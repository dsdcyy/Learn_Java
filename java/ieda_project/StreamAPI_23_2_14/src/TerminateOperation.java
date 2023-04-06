import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ljw
 * @version 1.0
 */
public class TerminateOperation {
    public static void main(String[] args) {
        // 1.匹配与查找
        // allMatch
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
        }
        // allMatch(IntPredicate predicate) 判断流的元素是否都大于10
        boolean b = Arrays.stream(arr).allMatch(e -> e > 10);
        System.out.println(b);
        // anyMatch(IntPredicate predicate) 判断流的某个元素是否大于10
        boolean b1 = Arrays.stream(arr).anyMatch(e -> e < 10);
        System.out.println(b1);
        // noneMatch(IntPredicate predicate) 判断是否有一个元素等于23
        boolean b2 = Arrays.stream(arr).noneMatch(e -> e == 23);
        System.out.println(b2);
        // findFirst 查找第一个元素
        OptionalInt first = Arrays.stream(arr).findFirst();
        System.out.println(first);
        // findAny 查找流中任一一个元素 使用并行流
        OptionalInt any = Arrays.stream(arr).findAny();
        System.out.println(any);
        // count() 返回流中总元素的个数
        long count = Arrays.stream(arr).filter(e -> e > 20).count();
        System.out.println(count);
        // max() 返回元素最大值,
        OptionalInt max = Arrays.stream(arr).max();
        System.out.println(max);
        // min() 返回元素最小值
        OptionalInt min = Arrays.stream(arr).min();
        System.out.println(min);
        // forEach(IntConsumer action) 内部迭代
        Arrays.stream(arr).limit(20).forEach(System.out::println);


    }

    @Test

    public void reduction_() {
        // 2.归约 reduce(初始值)
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        // identity 初始值  BinaryOperator<T> accumulator 函数
        Integer res = list.stream().reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("结果1; " + res + "  执行时间: " + (end - start));
    }
    @Test
    public void collect_(){
        /*
        * 3-收集
        方法 描述
        collect(Collector c) 将流转换为其他形式。接收一个Collector接口的实现，
        * 用于给Stream中元素做汇总的方法
        *
        * Collector接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)
        * */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // Collectors.toList() 转换为集合List
        List<Integer> collect = list.stream().filter(e -> e > 5).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();
        // Collectors.toSet() 转换为Set
        Set<Integer> collect1 = list.stream().filter(e -> e > 3).collect(Collectors.toSet());
        collect1.forEach(System.out::println);

    }
    @Test
    public void testList(){
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        System.out.println(integers);
        integers.add(4);
    }
}
