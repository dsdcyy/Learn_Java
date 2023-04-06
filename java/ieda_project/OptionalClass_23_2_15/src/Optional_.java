import java.util.Optional;

/**
 * @author ljw
 * @version 1.0
 */
public class Optional_ {
    public static void main(String[] args) {
        /*
         * 创建Optional对象
         * 1. Optional.of(T t) 创建一个Optional实例，t必须非空
         * 2.Optional.empty() 创建一个空的Optional实例
         * 3.Optional.ofNullable(T t) t可以为null
         * */

        /* 创建Optional对象
         * 1.Optional.of(T t) 创建一个Optional实例，t必须非空
         * 2.Optional.empty() 创建一个空的Optional实例
         * 3.Optional.ofNullable(T t) t可以为null
         * */
        Girl xh = new Girl("小红");
        // 传入的是非空实例
        Optional<Girl> xh1 = Optional.of(xh);
        System.out.println(xh1);
        // 如果xh1为非空，返回的就是传入的对象，如果为空，返回orElse传入的对象
        Girl 小雪 = xh1.orElse(new Girl("小雪"));
        System.out.println(小雪);
        // null会报错
        xh1 = null;
//        Optional<Object> o = Optional.of(xh1);
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        Optional<Optional<Girl>> xh11 = Optional.ofNullable(xh1);
        System.out.println(xh11);
    }
}

class Girl {
    String name;

    Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}


