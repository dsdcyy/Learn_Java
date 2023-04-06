import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 集合的理解和好处
        // 前面我们保存多个数据使用的是数组，那么数组有不足的地方，我们分析一下。
        // 数组
        /*
        * 1.长度开始时必须指定，而且一旦指定，不能更改
        * 2.保存的必须为同一类型的元素
        * 3.使用数组进行增加元素的示意代码－比较麻烦
        * 写出Person数组扩容示意代码
        * PersonLl pers = new Person[1];
        * per[0]=new Person();
        * */
        // 集合
        /*
        * 1.可以动态保存任意多个对象，使用比较方便！
        * 2.提供了一系列方便的操作对象的方法：add、remove、set、get等
        * 3.使用集合添加，删除新元素的示意代码-简洁了
        * */

        // 集合主要是两组(单列集合,双列集合)
        // Collection接口有两个重要的子接口 List Set 它们的实现子类都是单例集合
        // Map接口实现的子类是双列集合，存放的是key:value
        ArrayList<Object> objects = new ArrayList<>();
        // 单列
        objects.add("jack");
        System.out.println(objects);
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 双列
        hashMap.put("NO1","jack");
        System.out.println(hashMap);
        // Collection接口和常用方法
        // Collection接口实现类的特点
        //public interface Collection<E> extends Iterable<E> {};
        /*
        * 1.collection实现子类可以存放多个元素，每个元素可以是Object
        * 2.有些Collection的实现类，可以存放重复的元素，有些不可以
        * 3.有些Collection的实现类，有些是有序的(List)，有些不是有序(Set)
        * 4.Collection接口没有直接的实现子类，是通过它的子接口Set和List来实现的
        * */
        /*
        * 1.add:添加单个元素
        * 2.remove:删除指定元素
        * 3.contains：查找元素是否存在
        * 4.size:获取元素个数
        * 5.isEmpty:判断是否为空
        * 6.clear:清空
        * 7.addAll:添加多个元素
        * 8.containsAll：查找多个元素是否都存在
        * 9.removeAll：删除多个元素
        * 10.说明：以ArrayList实现类来演示 CollectionMethod01.java
        * */

        // Collection接口遍历元素方式1-使用Iterator(送代器)
        // 基本介绍
        /*
        * 1.Iterator对象称为送代器，主要用于遍历Collection集合中的元素
        * 2.所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象，
        即可以返回一个送代器。
        * 3.Iterator的结构.[图：]
        * 4.Iterator仅用于遍历集合，Iterator本身并不存放对象。
         */

        // 送代器的执行原理
        //Iterator iterator= coll.iterator()://得到一个集合的送代器
        //hasNext()：判断是否还有下一个元素
        //while(iterator.hasNext()){
        ////next()：@指针下移②将下移以后集合位置
        //上的元素返回
        //System.out.println(iterator.next())}

        //Collection接口遍历对象方式2-for循环增强
        //增强for循环，可以代替iterator送代器，特点：增强for就是简化版的iterator，
        //本质一样。只能用于遍历集合或数组
        /*
        * 基本语法
        *for(元素类型元素名：集合名或数组名）{
        * 访问元素}
            */

        // List接口和常用方法
        // List接口基本介绍
        // List接口是Collection接口的子接口
        /*
        * 1.List集合类中元素有序(即添加顺序和取出顺序一致）、且可重复[案例]
        * 2.List集合中的每个元素都有其对应的顺序素引，即支持索引。［案例］
        * 3.List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素！
        * 4.JDKAPI中List接口的实现类有 ArrayList LinkedList Vector
        * */

        // List集合里添加了一些根据索引来操作集合元素的方法 ListMethod.java
        /*
        * 1.void add(int index,Object ele)：在index位置插入ele元素
        * 2.boolean addAll(int index)开始将eles中的所有元素添加进来
        * 3.Object get(int index)：获取指定index位置的元素
        * 4.int indexOf(object obj）：返回obj在集合中首次出现的位置
        * 5.int lastIndexOf(object obj）：返回obj在当前集合中末次出现的位置
        * 6.Object remove(int index)：移除指定index位置的元素，并返回此元素
        * 7.Object set(int index)设置指定index位置的元素为ele相当于是替换
        * 8.List subList(int fromIndex,int toIndex)返回从fromIndex到toIndex(不包括)位置的子集合
        * */

        // ArrayList底层结构和源码分析
        // ArrayList的注意事项 ArrayDetail.java
        /*
        * 1.permits ail elements,including null，ArrayList 可以加入nulL，并且多个
        * 2.ArrayList是由数组来实现数据存储的
        * 3.ArrayList基本等同于Vector，除了ArrayList是线程不安全（执行效率高）看源码
        * 在多线程情况下，不建议使用ArrayList
        * */

        // ArrayList底层结构和源码分析 ArrayListSource.java
        /*
        * 1.ArrayList中维护了一个Object类型的数组elementData.[debug看源码］
        * transient Object[] elementData;
        * transient 该字段修饰的属性不会被序列化
        * 2.当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0(jdk7是10），
        * 第1次添加，则扩容elementData为10，如需要再次扩容，则扩容elementData为1.5倍。
        * 3.如果使用的是指定大小的构造器，则初始elementData容量为指定大小，
        * 如果需要扩容则直接扩容elementData为1.5倍
        * */

        // Vector底层结构和源码剖析
        // Vector的基本介绍 Vector>java
        /*
        * 1.Vector类的定义说明
        * public class Vector<Es> extends AbstractListEs implements List<E>, RandomAccess, Cloneable,Serializable
        * 2.Vector底层也是一个对象数组 protected Object[] elementData
        * 3.Vector是线程同步的，即线程安全，Vector类的操作方法带有synchronized
            public synchronized E get(int index) {
            if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index)：
            return elementData(index) }
            * 4.在开发中，需要线程同步安全时，考虑使用Vector
        * */

        // Vector底层结构和ArrayList的比较
        // ArrayList  底层结构 可变数组 版本 jdk1.2 线程安全(同步)效率  不安全，效率高 扩容倍数 有参构造器 1.5背 无参构造器 第一次10,后面1.5倍
        // Vector 底层结构 可变数组 版本 jdk1.0 线程安全(同步)效率  安全，效率不高  扩容倍数 如果是无参，默认是10,后按两倍 有参直接按2倍

        // LinkedList底层结构
        // LinkedList的全面说明
        /*
        * 1.LinkedList实现了双向链表和双端队列特点
        * 2.可以添加任意元素(元素可以重复），包括null
        * 3.线程不安全，没有实现同步
        * */

        // LinkedList的底层操作机制
        /*
        * 1.LinkedList底层维护了一个双向链表
        * 2.LinkedList中维护了两个属性first和last分别指向首节点和尾节点
        * 3.每个节点（Node对象），里面又维护了prev、next、item三个属性，
        * 其中通过prev指向前一个，通过next指向后一个节点。最终实现双向链表
        * 4.所以LinkedList的元素的添加和删除，不是通过数组完成的，相对来说效率较高。
        * 5.模拟一个简单的双向链表【走代码】LinkedList01.java
        * */

        // // LinkedList的增删改查案例 LinkedListCurd.java

        // ArrayList和LinkedList的比较
        // ArrayList 底层结构 可变数组 增删的效率 较低 数组扩容 改查的效率 较高
        // LinkedList 底层结构 双向链表  增删的效率 较高,通过链表追加 改查的效率 较低
        System.out.println("Hello world!");
        // 如何选择ArrayList和LinkedList
        /*
        * 1.如果我们改查的操作多，选择ArrayList
        * 2.如果我们增删的操作多，选择LinkedList
        * 3.一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择ArrayList
        * 4.在一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是ArrayList，另外一个模块是LinkedList
        * */

        // Set接口基本介绍
        /*
        * 1.无序（添加和取出的顺序不一致），没有索引[后面演示]
        * 2.不允许重复元素，所以最多包含一个null
        * 3.3JDK API中Set接口的实现类有 HashSet TreeSet LinkedHashSet等-
        * */

        // Set接口的常用方法
        //和List接口一样，Set接口也是Collection的子接口，因此，常用方法和Collection接口一样
        // Set接口的遍历方式
        // 同Collection的遍历方式一样，因为Set接口是Collection接口的子接口。
        /*
        * 1.可以使用送代器
        * 2.增强for
        * 3.不能使用索引的方式来获取
        * */

        // HashSet的全面说明 HashSet01.java
        /*
        * 1.HashSet实现了Set接口
        * 2.HashSet实际上是HashMap，看下源码.(图）
        * public HashSet(){
        *   map = new HashMap<>();
        * }
        * 3.可以存放nul值，但是只能有一个null
        * 4.HashSet不保证元素是有序的，取决于hash后，再确定索引的结果
        * 5.不能有重复元素/对象.在前面Set接口使用已经讲过
        * */

        // Set接口实现类-HashSet
        // HashSet底层机制说明
        // 分析HashSet底层是HashMap，HashMap底层是（数组+链表+红黑树）
        // HashSetStructure.java_为了让大家真正理解，
        //老韩模拟简单的数组+链表结构

        // 分析HashSet的添加元素底层是如何实现(hash()+equals())
        /*
         * 1.HashSet底层是HashMap
         * 2.添加一个元素时，先得到hash值转成->索引值
         * 3.找到存储数据表table，看这个索引位置是否已经存放的有元素
         * 4.如果没有，直接加入
         * 5.如果有，调用equals比较，如果相同，就放弃添加，如果不相同，则添加到最后
         * 6.在Java8中，如果一条链表的元素个数超过TREEIFY_THRESHOLD（默认是8），
         * 并且table的大小>=MIN_TREEIFY_CAPACITY（默认64）就会进行树化（红黑树)
         * */

        // 分析HashSet的扩容和转成红黑数机制
        /*
         * 1.HashSet底层是HashMap，第一次添加时，table数组扩容到16，
         * 临界值（threshold)是16*加载因子(oadFactor)是0.75=12
         * 2.如果table数组使用到了临界值12.就会扩容到16＊2=32，新的临界值就是32*0.75=24，依次类推
         * 3.3。在Java8中，如果一条链表的元素个数到达TREEIFYTHRESHOLD（默认是8）
         * 并且table的大小>=MINTREEIFYCAPACITY默认64)就会进行树化(红黑树)，否则仍然采用数组扩容机制
         * */

        // Set接口实现类-LinkedHashSet
        // LinkedHashSet的全面说明
        /*
        * 1.LinkedHashSet是HashSet的子类
        * 2.LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组+双向链表
        * 3.LinkedHashSet根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序(图)，这使得元素看起来是以插入顺序保存的。
        * 4.LinkedHashSet不允许添重复元素
        * */
        // 说明
        /*
        * 1.在LinkedHastSet中维护了一个hash表和双向链表（LinkedHashSet有head和tail）
        * 2.每一个节点有before和after属性，这样可以形成双向链表
        * 3.在添加一个元素时，先求hash值，在求索引，确定该元素table的位置，
        * 然后将添加的元素加入到双向链表(如果已经存在，不添加[原则和hashset一样])
        * 4.这样的话，我们遍历LinkedHashSet也能确保插入顺序和遍历顺序一致
        * */

        // 添加元素
        /* 1.第一次添加时，直接将数组table扩容到16,存放的节点类型是LinkedHashMap$Entry
         * 2.数组是HashMap$Node[]存放的元素是LinkedHashMap$Entry
        * */
    }
}