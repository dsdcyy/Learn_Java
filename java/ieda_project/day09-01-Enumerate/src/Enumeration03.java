import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class Enumeration03 {
    public static void main(String[] args) {
        // name 输出枚举对象的名称
        Season2 autumn = Season2.AUTUMN;
        System.out.println(autumn.name());
        // ordinal()输出的是该枚举对象的次序，编号，从0开始编号
        System.out.println(autumn.ordinal());
        // 返回Season2[]，包含有所有枚举对象
        Season2[] values = Season2.values();
        for (Season2 value : values) {
            System.out.println(value);
        }
        //valueOf 将字符串转换为枚举对象，要求字符串必须vt为自己已存在的常量名，否则报异常
        Season2 autumn1 = Season2.valueOf("SUMMER");
        System.out.println("autumn1 = " + autumn1);
        System.out.println(Season2.SUMMER == autumn1);
        // compareTo 比较两个枚举常量，比较的是编号之差
        System.out.println(Season2.SUMMER.compareTo(Season2.WINTER));
    }
}

enum Season2 {


    // 演示enum枚举实例
    // 1.使用enum关键字代替class
    // 2.public final static Season2 SUMMER = new Season2("夏天","炎热") 直接使用
    // SPRING("春天","温暖"); 常量名(实参列表)
    // 3.如果有多个常量，使用，间隔即可
    // 4.如果使用eum来实现枚举，要求自定义常量，写在前面

    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    private final String name;
    private final String desc;


    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/*
final class Season2 extends java.lang.Enum<Season2> {
  public static final Season2 SPRING;
  public static final Season2 SUMMER;
  public static final Season2 AUTUMN;
  public static final Season2 WINTER;
  public static Season2[] values();
  public static Season2 valueOf(java.lang.String);
  public java.lang.String toString();
  static {};
}
*/