/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*
        * 为什么要使用Stream API
        * 实际开发中，项目中多数数据源都来自于Mysql，Oracle等。但现在数
        * 据源可以更多了，有MongDB，Radis等，而这些NoSQL的数据就需要Java层面去处理。
        * Stream 和 Collection 集合的区别：Collection 是一种静态的内存数据结构，而Stream有关计算的。
        * 前者是主要面向内存，存储在内存中，后者主要是面向 CPU，通过 CPU实现计算。

        什么是Stream
        Stream到底是什么呢？
        是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
        “集合讲的是数据，Stream讲的是计算！
        注意：
        ①stream 自己不会存储元素。|
        ②Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream。
        ③Stream操作是延退执行的。这意味着他们会等到需要结果的时候才执行。

        Stream 的操作三个步骤
        1.创建 Stream
        一个数据源（如：集合、数组），获取一个流
        2-中间操作
        一个中间操作链，对数据源的数据进行处理
        3-终止操作(终端操作）
        一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
        *
        * 创建方式 Stream_.java
        * 1.通过集合 stream()方法
        * 2.通过数组 stream()方法
        * 3.通过Stream的of()方法
        * 4.创建无限流 Stream.iterate Stream.generate
        *
        * 方法
        * 1.筛选 filter(e-e>3)
        * 2.切片 limit(2);
        * 3.跳过元素 skip(4)
        * 4.元素过滤 distinct 通过流所生成的元素的hashcode()和equals()去除重复元素
        * 5.map(function f) 接收一个函数作为参数，将元素转换成其它形式获提取数据
        * 6.排序 sorted()
        */
        /*
        * Stream 的终止操作
        * 终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例
        * 如：List、Integer，甚至是 void 。流进行了终止操作后，不能再次使用。
        * 1-匹配与查找
        * 方法 描述
        * allMatch(Predicate p) 检查是否匹配所有元素
        * anyMatch(Predicate p) 检查是否至少匹配一个元素
        * 检查是否没有匹配所有元素 noneMatch(Predicate p)
        * 返回第一个元素 findFirst()
        * 返回当前流中的任意元素 findAny()
        * count() 返回流中总元素的个数
        * max() 返回元素最大值
        * min() 返回元素最小值
        * forEach(IntConsumer action) 内部迭代
        * */

        System.out.println("Hello world!");
    }
}