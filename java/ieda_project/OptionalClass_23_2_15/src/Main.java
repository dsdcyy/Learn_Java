import java.util.Optional;

/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*
         * 到自前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。
         * 以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，
         * Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代
         * 码。受到Google Guava的启发，Optional类已经成为Java8类库的一部分。
         *
         * Optional<T>类(java.util.Optional）是一个容器类，它可以保存类型T的值，代表
         * 这个值存在。或者仅仅保存nul，表示这个值不存在。原来用 nu表示一个值不
         * 存在，现在 Optional可以更好的表达这个概念。并且可以避免空指针异常。
         *
         * Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在
         * 则isPresent()方法会返回true，调用get()s方法会返回该对象。
         */

        /*
         * 创建Optional对象
         * 1. Optional.of(T t) 创建一个Optional实例，t必须非空
         * 2.Optional.empty() 创建一个空的Optional实例
         * 3.Optional.ofNullable(T t) t可以为null
         * */
    }
}