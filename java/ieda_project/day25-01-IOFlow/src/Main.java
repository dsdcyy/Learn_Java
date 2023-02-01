
/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // IO流

        // ·什么是文件
        //文件，对我们并不陌生，文件是保存数据的地方，比如大家经常使用的word文档，txt文件，excel文件..．都是文件。
        //它既可以保存一张图片，也可以保持视频，声音..

        // 文件流
        // 文件在程序中是以流的形式来操作的
        //输出流
        // 流：数据在数据源(文件)和程序(内存)之间经历的路径
        // 输入流：数据从数据源（文件）到程序(内存)的路径
        // 输出流：数据从程序（内存)到数据源（文件)的路径

        // 常用的文件操作
        // 创建文件对象相关构造器和方法
        // 相关方法
        /*
         * new File(String pathname) //根据路径构建一个File对象
         * new File(File parent，String child //根据父目录文件+子路径构建
         * new File(String parent，String child）//根据父目录+子路径构建
         * createNewFile创建新文件
         * */

        // 获取文件的相关信息
        // getName. getAbsolutePath. getParent. length. exists、 isFile，isDirectory

        // ●目录的操作和文件删除
        // mkdir创建一级目录、mkdirs创建多级目录、delete删除空目录或文件

        // IO流原理及流的分类
        // JavaIO流原理
        // 1.I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输。如读/写文件，网络通讯等。
        // 2.Java程序中，对于数据的输入/输出操作以”流（stream)”的方式进行
        // 3.java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过方法输入或输出数据
        // 4.输入input：读取外部数据磁盘、光盘等存储设备的数据）到程序（内存）中。
        // 5.输出output：将程序（内存数据输出到磁盘、光盘等存储设备中

        // 流的分类
        // 按操作数据单位不同分为：字节流（8bit)，字符流(按字符)
        // 按数据流的流向不同分为：输入流，输出流
        // 按流的角色的不同分为：节点流，处理流/包装流
        /*
         * （抽象基类）字节流  字符流
         * 输入流 InputStream Reader
         * 输出流 OutputStream Writer
         * 1.Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的。
         * 2.由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。
         * */

        // IO流体系图-常用的类
        // InputStream：字节输入流
        // InputStream 抽象类是所有类字节输入流的超类
        // InputStream 常用的子类
        /*
         * 1.FileInputStream：文件输入流 FileInputStream01.java
         * 2.BufferedInputStream：缓冲字节输入流
         * 3.ObjectInputStream：对象字节输入流
         * */

        // FileOutputStream:文件输出流    FileOutputStream01.java

        // 文件拷贝 FileCopy.java
        /*
         *  1.创建文件的输入流，将文件读入到程序
         *  2.创建文件的输出流，将程序写入到文件
         * */

        // FileReader 和FileWriter 介绍
        // FileReader和FileWriter是字符流，即按照字符来操作IO

        // FileReader相关方法：FileReader_.java
        /*
        * 1.new FileReader(File/String)
        * 2.read;每次读取单个字符，返回该字符，如果到文件末尾返回-1
        * 3.read（char[]）：批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1
        * */
        // 相关API：
        // new String(char[])：将char[]转换成String
        // new String(char[],off,len)将char[]的指定部分转换成String

        // FileWriter常用方法
        /*
        * 1.new FileWriter(File/String）：覆盖模式，相当于流的指针在首端
        * 2.new FileWriter(File/String,true)：遇加模式，相当于流的指针在尾端
        * 3.write（int)：写入单个字符
        * 4.write（char[])：写入指定数组
        * 5.write（char[],off,len写入指定数组的指定部分
        * 6.write（string）：写入整个字符串
        * 7.write（string.off.len)：写入字符串的指定部分
        * 相关API：String类：toCharArray：将String转换成char[]
        * 注意：FileWriter使用后，必须要关闭（close)或刷新（flush)，否则写入不到指定的文件！
        * */

        // 节点流和处理流
        /*
        * 1.节点流可以从一个特定的数据源读写数据，如FileReader、FileWriter[源码］
        * 2.处理流(也叫包装流）是“连接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，
        * 如BufferedReader、BufferedWriter【源码]
        * */

        // 节点流和处理流的区别和联系
        /*
        * 1.节点流是底层流/低级流，直接跟数据源相接
        * 2.处理流包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出。[源码理解]
        * 3.处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，
        * 不会直接与数据源相连［模拟修饰器设计模式] DecoratorDesignPattern.java
        * */

        // 处理流的功能主要体现在以下两个方面
        /*
        * 1.性能的提高：主要以增加缓冲的方式来提高输入输出的效率，
        * 2.操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便
        * */

        // 处理流-BufferedReader和BufferedWriter
        // BufferedReader和BufferedWriter属于字符流，是按照字符来读取数据的
        //关闭时，只需要关闭外层流即可[后面看源码]
        // BufferedReader_.java
        // BufferedReader_.java

        // 节点流和处理流
        // 处理流-BufferedInputStream和BufferedOutputStream

        // 介绍BufferedInputStream
        // BufferedInputStream是字节流,在创建BufferedInputStream时，会创建一个内部缓冲区数组

        // 介绍BufferedOutputStream
        // BufferedOutputStream是字节流，实现缓冲的输出流，可以将多个字节写入底层输出流中，而不必对每次字节写入调用底层系统

        // 案例 BufferedStreamCopy.java

        // 对象流-ObjectInputStream和objectOutputStream
        // 看一个需求
        /*
        * 1.将int num=100这个int数据保存到文件中，注意不是100数字，而是int100，并且，能够从文件中直接恢复int100
        * 2.将Dog dog=newDog("小黄”，3）这个dog对象保存到文件中，并且能够从文件恢复，
        * 3.上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化操作
        * */

        // 序列化和反序列化
        /*
        * 1.序列化就是在保存数据时，保存数据的值和数据类型
        * 2.反序列化就是在恢复数据时，恢复数据的值和数据类型
        * 3.需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，
        * 该类必须实现如下两个接口之一：
        * Serializable // 这是一个标记接口
        * Externalizable // 该接口需要实现2个方法
        * */

        /*
        * 1.功能：提供了对基本类型或对象类型的序列化和反序列化的方法
        * 2.ObjectOutputStream提供序列化功能 ObjectOutputStream_.java
        * 3.ObjectInputStream提供反序列化功能 ObjectInputStream_.java
        * */

        // 注意事项和细节说明
        /*
        * 1.读写顺序要一致
        * 2.要求实现序列化或反序列化对象，需要实现Serializable
        * 3.序列化的类中建议添加SerialVersionUID.为了提高版本的兼容性
        * 4.序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
        * 5.序列化对象时，要求里面属性的类型也需要实现序列化接口
        * 6.序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化
        * */

        // 标准输入输出流 InputAndOutput.java
        // 介绍
        // 类型 默认设备
        // System.in标准输入 InputStream 键盘
        // System.out标准输出 PrintStream 显示器

        // 转换流-InputStreamReader 和 OutputStreamWriter CodeQuestion.java
        // 先看一个文件乱码问题，引出学习转换流必要性

        // 介绍
        /*
        * 1.InputStreamReader:Reader的子类，可以将InputStream(字节流）包装成Reader（字符流）
        * 2.OutputStreamWriter:Writer的子类，实现将OutputStream(字节流)包装成Writer（字符流）
        * 3.当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转换成字符流
        * 4.可以在使用时指定编码格式(比如utf-8,gbk，gb2312,S08859-1等）
        * */

        // 应用案例
        /*
        *
        * 1.编程将字节流FileInputStream包装成(转换成）字符流InputStreamReader，对文件进行读取（按照utf-8/gbk格式)，进而在包装成BufferedReader
        * InputStreamReader_.java
        *
        * 2.编程将字节流FileOutputStream包装成（转换成）字符流OutputStreamWriter，对文件进行写入（按照gbk格式，可以指定其他，比如utf-8
        * outputStreamWriter_.java
        * */

        // 打印流-PrintStream和PrintWriter
        // PrintStream_.java
        // PrintWriter_.java

        // Properties类
        // 看一个需求 Properties01.java
        // 如下一个配置文件mysql.properties
        // ip=192.168.0.13
        // user=root
        // pwd=12345
        // 请问编程读取ip、user和pwd的值是多少
        // 分析
        /*
        * 1.传统的方法
        * 2.使用Properties类可以方便实现
        * */

        // 基本介绍
        /*
        * 1.专门用于读写配置文件的集合类配置文件的格式：键=值 键=值
        * 2.注意：键值对不需要有空格，值不需要用引号一起来。默认类型是String
        * 3.Properties的常见方法
        * load：加载配置文件的键值对到Properties对象
        * list:将数据显示到指定设备
        * getProperty(key）：根据健获取值
        * setProperty(key,value)：设置键值对到Properties对象
        * store:将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件，
        * 如果含有中文，会存储为unicode码

        */
        System.out.println("Hello world!");



    }
}