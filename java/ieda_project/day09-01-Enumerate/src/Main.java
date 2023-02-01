/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 枚举 enumerate
        /*
        * 1.枚举对应英文（enumeration，简写enum)
        * 2.枚举是一组常量的集合
        * 3可以这里理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象
        * */

        // 枚举的两种实现方式
        /*
        * 1.自定义类实现枚举
        * 2.使用enum关键字实现枚举
        * */

        // 自定义枚举案例
        /*
        * 1.不需要提供setXxx方法，因为枚举对象值通常为只读
        * 2.对枚举对象/属性使用final+static共同修饰，实现底层优化，不会导致类加载
        * 3.枚举对象名通常使用全部大写，常量的命名规范
        * 4.枚举对象根据需要，也可以有多个属性//Enumeration02.java
        * */

        //自定义枚举特点
        /*
        * 1.构造器私有化
        * 2.本类内部创建一组对象[四个春夏秋冬
        * 3.对外暴露对象（通过为对象添加public final static修饰符）
        * 4.可以提供get方法，但是不要提供set
        * */

        // enum关键字实现枚举注意事项
        /*
        * 1.当我们使用enum关键字开发一个枚举类时，默认会继承Enum类[如何证明，老师使用javap工具演示]
        * 2.传统的public static final Season2 SPRING=new Season2（春天”“温暖")；
        * 简化成SPRING("春天""温暖")，这里必须知道，它调用的是哪个构造器
        * 3.如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略
        * 4.当有多个枚举对象时，使用，间隔，最后有一个分号结尾
        * 5.枚举对象必须放在枚举类的行首。
        * */

        // java_Enum成员方法  Enumeration03.java
        /*
        * toString：Enum类已经重写过了，返回的是当前对象名，子类可以重写该方法，用于返回对象的属性信息
        * name：返回当前对象名（常量名），子类中不能重写
        * ordinal：返回当前对象的位置号，默认从0开始
        * values；返回当前枚举类中所有的常量
        * valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常！
        * compareTo：比较两个枚举常量，比较的就是编号！
        * */

        // enum实现接口 EnumDetail.java
        /*
        * 1.使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而Java是单继承机制。
        * 2.枚举类和普通类一样，可以实现接口，如下形式。enum 类名 implements接口1，接口2{}
        * */
        System.out.println("Hello world!");
    }
}