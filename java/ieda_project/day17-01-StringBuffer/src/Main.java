/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // StringBuffer类
        // 基本介绍 StringBuffer01.java
        /*
        * 1.java.lang.StringBuffer代表可变的字符序列，可以对字符串内容进行增删
        * 2.很多方法与String相同，但StringBuffer是可变长度的。
        * 3.StringBuffer是一个容器。
        * */
        // StringBuffer的直接父类是AbstractStringBuilder
        // StringBuffer实现了Serializable接口，即StringBuffer对象可以串行化
        // StringBuffer是final类，不能被继承
        // 父类有个 byte[] value属性

        // String VS StringBuffer
        /*
        * 1.String保存的是字符串常量，里面的值不能更改，每次String类的更新实际上就是更改地址，效率较低 //private final char[] value
        * 2.StringBuffer保存的是字符串变量，里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，
        * 不用每次更新地址，效率较高 // char[] value ->指向堆
        * */

        // StringBuffer的构造器
        /*
        * StringBuffer()
        * 构造其中不带字符的字符串缓冲区，其初始容量为16个字符。
        * StringBuffer(CharSequence seq)
          public java.lang.StringBuilder(CharSequence seq）
        * 构造一个字符串缓冲区，它包含与指定的CharSequence 相同的字符。
        * StringBuffer(int capacity) // capacity [容量]
        * 构造一个不带字符，但具有指定初始容量的字符串缓冲区。即对 char大小进行指定
        * StringBuffer(String str)
          构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容,初始大小为字符串长度+16
          *
        * */

        // StringBuffer和String相互转换 StringBufferAndString.java

        // StringBuffer类常见方法 StringBufferMethod.java
        /*
        * 1.增 append
        * 2.删 delete (start,end)
        * 3.改 replace(start,end,string)//将start----end间的内容替换掉，不含end
        * 4.查 indexOf//查找子串在字符串第1次出现的索引.如果找不到返回-1
        * 5.插 insert
        * 6.获取长度length
        * */

        // StringBuilder类
        // 基本介绍 StringBuilder01.java
        /*
        * 1.一个可变的字符序列。此类提供一个与StringBuffer兼容的API，但不保证同步（StringBuilder不是线程安全）。
        * 该类被设计用作StringBuffer的一个简易替换，用在字符串缓冲区被单个线程使用的时候。如果可能，
        * 建议优先采用该类因为在大多数实现中，它比StringBuffer要快［后面测］。
        * 2.在StringBuilder上的主要操作是append和insert方法，可重载这些方法以接受任意类型的数据
        * */

        //StringBuilder常用方法
        //StringBuilder和StringBuffer均代表可变的字符序列，方法是一样的，所
        //以使用和StringBuffer一样，看老师演示.[参考StringBuffer］

        // String StringBuffer 和StringBuilder的比较
        /*
        * 1.StringBuilder和StringBuffer非常类似，均代表可变的字符序列，而且方法也一样
        * 2.String：不可变字符序列，效率低，但是复用率高
        * 3.StringBuffer：可变字符序列、效率较高(增删）、线程安全
        * 4.StringBuilder：可变字符序列、效率最高、线程不安全
        * 5.String使用注意说明：
            string s = "a"；//创建了一个字符串
            s += "b";//实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串s+"b”（也就是"sb")。
            * 如果多次执行这些改变串内容的操作，会导致大量副
            本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大
            影响程序的性能=>结论：如果我们对String做大量修改，不要使用String
        * */

        // String,StringBuffer和StringBuilder的选择
        // 使用的原则
        /*
        * 1.如果字符串存在大量的修改操作，一般使用StringBuffer或StringBuilder
        * 2.如果字符串存在大量的修改操作，并在单线程的情况，使用StringBuilder
        * 3.如果字符串存在大量的修改操作，并在多线程的情况，使用StringBuffer
        * 4.如果我们字符串很少修改，被多个对象引用，使用String.比如配置信息等StringBuilder的方法使用和StringBuffer一样，不再说
        * */
        System.out.println("Hello world!");
    }
}