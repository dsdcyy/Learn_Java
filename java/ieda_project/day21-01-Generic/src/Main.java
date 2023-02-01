import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args)
    // 泛型的理解和好处
    // 看一个需求
    // 1.请编写程序，在ArrayList中，添加3个Dog对象
    // 2.Dog对象含有name和age，并输出name和age（要求使用getXxx0)
    //先使用传统的方法来解决->引出泛型
    {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("大黄", 2));
        arrayList.add(new Dog("大白", 3));
        arrayList.add(new Dog("大黑", 5));
        for (Object o : arrayList) {
            // 当不小心添加到其它对象时会出现转换异常
            Dog dog = (Dog) o;
            System.out.println(((Dog) o).getName() + ":" + ((Dog) o).getAge());
        }

        System.out.println("Hello world!");
        // 使用传统方法的问题分析
        /*
         * 1.不能对加入到集合ArrayList中的数据类型进行约束（不安全
         * 2.遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响
         * */

        // 泛型快速体验-用泛型来解决前面的问题
        //  ArrayList<Dog> arrayList = new ArrayList(); 表示添加到ArrayList中的对象是Dog
        ArrayList<Dog> arrayList2 = new ArrayList<>();
        arrayList2.add(new Dog("大黑", 5));
        arrayList2.add(new Dog("大黄", 2));
        arrayList2.add(new Dog("大白", 3));
//        arrayList2.add(new Integer(10)); // 无法加入
        // 遍历时更方便，不需要强转
        for (Dog o : arrayList2) {
            System.out.println(((Dog) o).getName() + ":" + ((Dog) o).getAge());
        }
        // 泛型的好处
        /*
        * 1.编译时，检查添加元素的类型，提高了安全性
        * 2.减少了类型转换的次数，提高效率【说明]
        √不使用泛型
        Dog->Object->Dog//放入到ArrayList会先转成Object，在取出时，还需要转换成Dog
        √使用泛型
        Dog->Dog->Dog//放入时，和取出时，不需要类型转换，提高效率
        * 3.不再提示编译警告
        * */

        // 泛型介绍
        /*
        * 1.泛型又称参数化类型，是Jdk5.0出现的新特性，解决数据类型的安全性问题
        * 2.在类声明或实例化时只要指定好需要的具体的类型即可。
        * 3.Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮
        * 4.泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
        ［有点难，举例Generic03.java]
        * */

        // 泛型的作用
        /*
         * 可以在声明类时通过一个标识来表示该类的某个属性
         * 或者是某个方法的返回值类型，或者是参数类型
         * */
        Person<String,Integer> person = new Person<String,Integer>("小李",200);
        System.out.println(person.f() + ":" + person.t());

        // 注意 E具体的数据类型在定义Person对象时候指定，即在编译期间就确定了E的类型

        // 泛型的声明
        // interface 接口<T>和class类<K,V,M>{}
        // 比如：List，ArrayList
        /*
        * 说明：
        * 1其中，T,V,K不代表值，而是表示类型
        *2.任意字母都可以。常用T表示，是Type的缩写
        // 泛型的实例化：
        * */
        //要在类名后面指定类型参数的值（类型）。如：
        /*
        * 1.List<String> strList = new ArrayList<String>():
        [举例说明]
        * 2.Iterator<Customer> iterator = customers.iterator();
        */

        // ●泛型使用的注意事项和细节GenericDetail.java
        /*
        * 1. interface List<T>{},public class HashSet<E>0.等等
        说明：T.E只能是引用类型
        看看下面语句是否正确？：
        List<Integer> list = new ArrayList<Integer>();//T
        List<int> list2 = new ArrayList<int>(); //F
        * 2.在指定泛型具体类型后，可以传入该类型或者其子类类型
        * 3.泛型使用形式
            List<Integer> list1 = new ArrayList<Integer>():
            List<Integer> list2 = new ArrayList<>(): [说明：]
        *4.如果我们这样写List list3 = newArrayList()；默认给它的泛型是［<E>E就是Object]
* */
        // 自定义泛型类（难度） CustomGeneric.java
        // 基本语法
        /*
        * class 类名<T,R...>{
            成员
          }
        * */
        // 注意细节
        /*
        * 1.普通成员可以使用泛型（属性、方法）
        * 2.使用泛型的数组，不能初始化;因为不能确定T的类型，无法在内存中开辟空间
        * 3.静态方法和属性中不能使用类的泛型，因为静态方法是在类加载的时候就触发的，此时仍然确定泛型所属类型
        * 4.泛型类的类型，是在创建对象时确定的(因为创建对象时，需要指定确定类型）
        * 5.如果在创建对象时，没有指定类型，默认为Object
        * */

        // 自定义泛型接口
        // 基本语法
        // interface Phone<T,R> {成员}
        // 注意细节
        /*
        * 1.接口中，静态成员也不能使用泛型（这个和泛型类规定一样）
        * interface Phone<E> {void f1(E e);}
        * class Screen implements Phone<String> {
                @Override
                public void f1(String s) {
                System.out.println(s);
          }
}
        * 2.泛型接口的类型，在继承接口或者实现接口时确定
        * 3.没有指定类型，默认为Object
        * */
        // 自定义泛型方法
        // 基本语法
        // 修饰符<T.R..>返回类型方法名（参数列表）{}
        // 注意细节
        /*
        * 1.泛型方法，可以定义在普通类中，也可以定义在泛型类中
        * 2.当泛型方法被调用时，类型会确定
        * 3.public void eat(E e)，修饰符后没有<T.R..>eat方法不是泛型方法，而是使用了泛型
        *
        * */

        // 泛型的继承和通配符说明 GenericExtends.java
        /*
        * 1.泛型不具备继承性
            List<Object> list = new ArrayList<String>()://对吗？
        * 2.<？>：支持任意泛型类型
        * 3.<? extends A>：支持A类以及A类的子类，规定了泛型的上限
        * 4.<? super A>：支持A类以及A类的父类，不限于直接父类，规定了泛型的下限
        * */

        // 为什么需要JUnit
        /*
        * 1.一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中
        * 2.如果有多个功能代码测试，就需要来回注销，切换很麻烦
        * 3.如果可以直接运行一个方法，就方便很多，并且可以给出相关信息，就好了->JUnit
        * */

        // JUnit基本介绍 JUnit01.java
        /*
        * 1.JUnit是一个Java语言的单元测试框架
        * 2.多数Java的开发环境都已经集成了JUnit作为单元测试的工具
        * */
        }
}

class Person<E,T> {
    // 通过一个标识E表示类中的某个属性
    E s;
    T age;
    // 通过一个标识E表示类中的某个方法的参数类型
    public Person(E s,T age) {
        this.s = s;
        this.age = age;
    }
    // 通过一个标识E表示类中的某个方法的返回类型
    public E f() {
        return s;
    }
    public T t(){
        return age;
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        setAge(age);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}