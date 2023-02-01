/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 反射机制 Reflection
        // 引出问题 根据配置文件re.properties指定信息，创建对象并调用方法
        // Java Reflection
        /*
         * 1.反射机制允许程序在执行期借助于ReflectionAPI取得任何类的内部信息(比如成员变量，构造器，成员方法等等)，
         * 并能操作对象的属性及方法。反射在设计模式和框架底层都会用到
         * 2.加载完类之后，在堆中就产生了一个Class类型的对象（一个类只有一个Class对象），
         * 这个对象包含了类的完整结构信息。通过这个对象得到类的结构。这个对象就像一面镜子，
         * 透过这个镜子看到类的结构，所以，形象的称之为：反射
         * */

        // Java反射机制可以完成
        /*
         * 1.在运行时判断任意一个对象所属的类
         * 2.在运行时构造任意一个类的对象
         * 3.在运行时得到任意一个类所具有的成员变量和方法
         * 4.在运行时调用任意一个对象的成员变量和方法
         * 5.生成动态代理
         * */

        // 反射相关的主要类
        /*
        * 1.java.lang.Class：代表一个类，Class对象表示某个类加载后在堆中的对象
        * 2.java.lang.reflect.Method：代表类的方法
        * 3.java.lang.reflect.Field：代表类的成员变量
        * 4.java.lang.reflect.Constructor：代表类的构造方法
        * */

        // 反射优点和缺点
        /*
        * 1.优点：可以动态的创建和使用对象(也是框架底层核心)，使用灵活，没有反射机制，框架技术就失去底层支撑。
        * 2.缺点：使用反射基本是解释执行，对执行速度有影响。
        * 3.应用实例：Reflection02.java
        * */

        // 反射调用优化-关闭访问检查
        /*
        * 1.Method和Field、Constructor对象都有setAccessible)方法
        * 2.setAccessible作用是启动和禁用访问安全检查的开关
        * 3.参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率。参数值为false则表示反射的对象执行访问检查
        * */

        // 反射优点和缺点
        /*
        * 1.优点：可以动态的创建和使用对象(也是框架底层核心)使用灵活，没有反射机制，框架技术就失去底层支撑。
        * 2.缺点：使用反射基本是解释执行，对执行速度有影响
        * */

        // Class类

        // 基本介绍
        /*
        * 1.Class也是类，因此也继承object类[类图
        * 2.Class类对象不是new出来的，而是系统创建的【演示]
        * 3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次【演示]
        * 4.每个类的实例都会记得自己是由哪个Class实例所生成
        * 5.通过Class可以完整地得到一个类的完整结构，通过一系列API
        * 6.Class对象是存放在堆的
        * 7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码变量名，方法名，访问权限等等）
        * https://www.zhihu.com/question/38496907【示意图】
        * */
        System.out.println("Hello world!");

        // Class类常用方法 Class02>java

        // 获取Class类对象的六种方式
        /*
        * 1.前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName0获取，
        * 可能抛出ClassNotFoundException，实例：Class cls1 =Class.forName1 "java.lang.Cat"):
        * 应用场景：多用于配置文件，读取类全路径，加载类
        * 2.前提：若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高
        * 实例：Class cls2=Cat.class；
        * 应用场景：多用于参数传递，比如通过反射得到对应构造器对象
        * 3.前提：已知某个类的实例，调用该实例的getClass0方法获取Class对象，
        * 实例：Class clazz =对象.getClass()；
        * 应用场景：通过创建好的对象，获取Class对象
        * 4.ClassLoader cl= 对象.getClass().getClassLoader()：
        * Class clazz4=cl.loadClass(“类的全类名”）；
        * 5.基本数据（int,char，boolean，float double)按方式得到Class类对象
        * Class cls = 基本数据类型.class
        * 6.基本数据类型对应的包装类，可以通过.type得到Class类对象Class cls=包装类.TYPE
        * */

        // 哪些类型有Class对象
        /*
        * 1.外部类，成员内部类，静态内部类，局部内部类，匿名内部类
        * 2.interface:接口
        * 3.数组
        * 4.enum：枚举
        * 5.annotation：注解
        * 6.基本数据类型
        * 7.void
        * */

        // 类加载
        // 基本说明
        // 反射机制是java实现动态语言的关键，也就是通过反射实现类动态加载。
        /*
        * 1.静态加载：编译时加载相关的类，如果没有则报错，依赖性太强
        * 2.动态加载：运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性
        * 3.举例说明
        * */
        // 类加载时机
        /*
        * 1.当创建对象时（new）
        * 2.当子类被加载时
        * 3.调用类中的静态成员时
        * 4.通过反射
        * */
        // 类加载的3个过程
        /*
        * jvm控制
        * 1.加载 Loading
        * JVM在该阶段的主要目的是将字节码从不同的数据源（可能是class文件、也可能是jar包，甚至网络）转化为二进制字节流加载到内存中，
        * 并生成一个代表该类的,java.lang.Class 对象
        * 2.连接 Linking
        * (1) 验证 verification 对文件的安全性进行校验，比如文件的字符，字节码的原数据
        * 1.目的是为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全
        * 2.包括：文件格式验证（是否以魔数oxcafebabe开头）、元数据验证、字节码验证和符号引用验证
        * 3.可以考虑使用-Xverify:none参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间
        * (2) 准备 Preparation 对静态变量进行默认初始化，并分配空间
        * JVM会在该阶段对静态变量，分配内存并初始化（对应数据类型的默认初始值如0、OL、null、false等）。这些变量所使用的内存都将在方法区中进行分配
        * (3) 解析 Resolution
        * 将类的二进制数据合井到JRE中
        * 连接 解析 符号引用替换为直接引用
        * 程序员控制
        * 3.初始化 initialization
        * JVM负责对类进行初始化，这里主要是指静态成员
        * 1.到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit>()方法的过程。
        * 2.<clinit>()方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，
        * 并进行合并。[举例说明 ClassLoad03.java]
        * 3、虚拟机会保证一个类的clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，
        * 那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕［debug源码]
        * */

        // 通过反射获得类的结构信息
        // 第二组：java.lang.reflect.Field类 ReflectFieldClass.java
        /*
        * 1.getModifiers:以int形式返回修饰符[说明：默认修饰符是0，public是1，private是2，protected是4，static是8，final是16]
        * 2.getType:以Class形式返回类型
        * 3.getName：返回属性名
        * 4.getType:以Class形式返回类型
        * 5.getReturnType() 获取方法返回类型
        * */

        // 通过反射创建对象
        /*
        * 1.方式一：调用类中的public修饰的无参构造器
        * 2.方式二：谨调用类中的指定构造器
        * 3.Class类相关方法newInstance：调用类中的无参构造器，获取对应类的对象
          getConstructor(Class...clazz）根据参数列表，获取对应的构造器对象
          getDecalaredConstructor(Class...clazz）根据参数列表，获取对应的构造器对象
        * 4.Constructor类相关方法
          setAccessible:暴破
          newInstance(object...obj)：调用构造器
        * */

        // 案例演示
        //ReflectionCreateInstance.java
        //1.测试1：通过反射创建某类的对象，要求该类中必须有public的无参构造
        //2.测试2：通过调用某个特定构造器的方式，实现创建某类的对象

        // 获取属性
        /*
        * 1.根据属性名获取Field对象Field f=clazz对象.getDeclaredField（属性名）：
        * 2.暴破：f.setAccessible(true)；//f是Field
        * 3.访问f.set（o，值）// o表示对象syso(f.get（o））;// o表示对象
        * 4.如果是静态属性，则set和get中的参数o，可以写成null*/

        /*
        * 访问方法
        * 1.根据方法名和参数列表获取Method方法对象：Method m = clazz.getDeclaredMethod(方法名，xx.class)；
        * 2.获取对象：Object o=clazz.newInstance()；
        * 3．暴破：m.setAccessible(true)：
        * 4.访间：Object returnValue=m.invoke(o,实参列表)
        * 5.注意：如果是静态方法，则invoke的参数o，可以写成null！
        * */
    }
}