import java.util.Date;

/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //第一代日期类
        /*
        * 1.DATE精确到毫秒，代表特定的瞬间
        * 2.SimpleDateFormat：格式和解析日期的类
          SimpleDateFormat格式化和解析日期的具体类。
          它允许进行格式化（日期->文本）、解析（文本->日期）和规范化
          * 3.应用实例Date_.java
        * */

        // 获取当前系统时间
//        Date date = new Date();
        //输出指定格式时间 yyyy年 MM月 dd日 HH:mm:ss 时分秒 E 周几
        // SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        //  String format = simpleDateFormat.format(date);
        //        System.out.println(format);
        //       将字符串转为时间 parse
        //        Date date2 = simpleDateFormat.parse(format);
        //        System.out.println(date2);

        // 第二代日期类
        // 1.第二代日期类，主要就是Calendar类（日历）
        /*
        * public abstract class Calendar extends
        object
        implements
        Serializable
        Cloneable, Comparable<Calendar？>
        * */
        /* 2.Calendar类是一个抽象类，它为特定瞬间与一组诸如YEAR、MONTH.
        DAY_OF_MONTH、HOUR等日历字段之间的转换提供了一些方法，
        并为操作日历字段（例如获得下星期的日期）提供了一些方法
        * */

        // 通过getInstance获取对象 Calendar01.java
        // Calendar c = Calendar.getInstance();

        // 第三代日期类
        //》前面两代日期类的不足分析
        //JDK1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK1.1引入Calendar类之后被弃用了。而Calendar也存在问题是：
        //1）可变性：像日期和时间这样的类应该是不可变的。
        //2）偏移性：Date中的年份是从1900开始的，而月份都从0开始
        //3)格式化：格式化只对Date有用，Calendar则不行。
        //4）此外，它们也不是线程安全的；不能处理闰秒等（每隔2天，多出1s

        // 第三代日期类常见方法
        /*
        * 1.LocalDate(日期)、LocalTime(时间)、LocalDateTime(日期时间),jdk8加入
        * LocalDate只包含日期，可以获取日期字段
        * LocalTime只包含时间，可以获取时间字段
        * LocalDateTime包含日期+时间，可以获取日期和时间字段
        * 2.DateTimeFormatter格式日期类
        * 类似于SimpleDateFormat
        * DateTimeFormat dtf= DateTimeFormatter.OfPattern(格式);
        * String str= dtf.format(日期对象);
        * 3.Instant时间戳
        类似于Date
        提供了一系列和Date类转换的方式
        instant ---> Date:
        Date date = Date.from(instant);
        Date ---> Instant：
        Instant instant = date.toInstant();
        * 4.第三代日期类更多方法
        * LocalDateTime类
        * MonthDay类：检查重复事件
        * 是否是闺年
        * 增加日期的某个部分
        * 使用plus方法测试增加时间的某个部分
        * 使用minus方法测试查看一年前和一年后的日期
        * */
        System.out.println("Hello world!");
    }
}