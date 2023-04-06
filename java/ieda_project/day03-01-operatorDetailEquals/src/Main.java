public class Main {
    public static void main(String[] args) {
        // Object类方法
        // equals方法 Equals.java
        // ==和equals的对比
        /*
        * 1.== 既可以判断基本类型，又可以判断引用类型
        * 2.== 如果判断基本类型，判断的是值是否相等
        * 3.== 如果判断引用类型，则判断地址是否相等，即判断是不是同一个对象
        * 4.equals 是Object类中的方法，只能判断引用类型
        * 5.默认判断地址是否相等，子类中往往重写该方法，用于判断内容是否相等，比如Integer,String
        * */
        System.out.println("Hello world!");
        "hello".equals("world!");
        // 课堂练习 EqualsTest01.java 重写equals方法.png

        // HashCode方法
        /*
        * 1.提高具有哈西结构容器的效率
        * 2.两个引用，如果指向的地址是同一个对象，则哈西值肯定是一样的
        * 3.两个引用，如果指向的是不同的对象，则哈西值是不一样的
        * 4.哈西值主要依据地址号来的，不能完全将哈西值等价于地址
        *
        * */

        // toString方法
        // 基本介绍
        /*
        * 默认返回:全类名(包名+类名)+@+哈西值的十六进制，子类往往会重写toString方法，用于返回对象的属性信息
        * 当直接输出一个对象时，toString方法会被默认调用
        * */
        // 重写toString方法，打印对象或拼接对象时，都会自动调用该对象的toString形式
        // 案例 ToString.java

        // finalize方法
        /*
        * 1.当对象被回收时，系统自动调用该对象的finalize方法，子类可以重写该方法，做一些释放资源的操作
        * 2.什么时候回收：当这个对象没有任何引用时，则jvm就会认为是一个垃圾对象，
        * 就会使用垃圾回收机制来销毁该队向，在对象销毁前，先会调用finalize方法,在里面可以写一些自己的逻辑代码(资源释放)
        * 3.垃圾回收机制的调用，是由系统来决定，也可以通过System.gc()主动触发垃圾回收机制
        * */
        // 示例 Finalize.java
    }




}