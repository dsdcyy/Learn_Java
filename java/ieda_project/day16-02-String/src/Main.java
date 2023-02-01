/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // String类的理解和创建对象 String01.java
        /*
        * 1.String对象用于保存字符串，也就是一组字符序列
        * 2.字符串常量对象是用双引号括起的字符序列。例如：“你好"、"12.97"、"boy"等
        * 3.字符串的字符使用Unicode字符编码，一个字符（不区分字母还是汉字)
        * 4.String类较常用构造方法（其它看手册）：
            String s1 = new String();
            String s2 = new String(String original)
            String s3 = new String(char[] a):
            String s4 = new String char[] a,int startIndex,int count)
        * */

        // 关系类
        //Serializable，Comparable，CharSequence 接口实现
        //Object 父类
        // String 实现了Serializable ，说明string 可以串行化，网络传输
        //String实现了Comparable接口，说明string对象可以比较

        // String是final类
        // private final byte[] value;用于存放字符串内容，value地址不可修改

        // 创建String对象的两种方式
        /*
        * 1.直接赋值String s = "hspedu"；
        * 2.调用构造器Strings = newString("hspedu")；
        * */
        /*
        * 1.方式一：先从常量池查看是否有"hsp”数据空间，如果有，直接指向；
        * 如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址
        * 2。方式二：先在堆中创建空间，里面维护了value属性，指向常量池的hsp空间。
            如果常量池没有"hsp"，重新创建，如果有，直接通过value指向。最终指向的是堆中的空间地址
        * */

        // 字符串的特性 StringExercise06.java
        // 说明
        /*
        * 1.String是一个final类，代表不可变的字符序列
        * 2.字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的
        * */

        // String类的常见方法
        //说明
        //String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低，
        //因此java设计者还提供了StringBuilder和StringBuffer来增强String的功能
        //并提高效率。[后面我们还会详细介绍StringBuilder和StringBuffer]

        // 常见方法一览
        /* StringMethod01.java
        equals  // 区分大小写，判断内容是否相等
        equalsIgnoreCase // 忽略大小写的判断内容是否相等
        length // 获取字符的个数，字符串的长度
        indexOf // 获取字符在字符串中第1次出现的索引，索引从0开始，如果找不到，返回-1
        lastIndexOf // 获取字符在字符串中最后1次出现的索引，索引从0开始，如找不到，返回-1
        substring // 截取指定范围的子串
        trim // 去前后空格
        charAt:获取某素引处的字符，注意不能使用Str[index]这种方式
        // StringMethod02.java
        toUpperCase  // 字符串转大写
        toLowerCase  // 字符串转小写
        concat  // 字符串连接
        replace // 替换字符串中的字符
        split // 分割字符串，对于某些分割字符，我们需要转义比如/\等
        compareTo // 比较两个字符串的大小
        toCharArray // 转换成字符数组
        format // 格式字符串，%s字符串 %c字符 %d整型 %.2f浮点型

*/

        System.out.println("Hello world!");
    }
}