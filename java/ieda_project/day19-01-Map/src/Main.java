/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 实现Map接口 Properties 继承 Hashtable， LinkedHashMap 继承 HashMap ，TreeMap
        // Map接口和常用方法
        // Map接口实现类的特点［很实用]
        // 这里讲的是JDK8的MapMap接口实现类的特点［很实用]接口特点Map_.java
        /*
        * 1.Map与Collection并列存在。用于保存具有映射关系的数据：Key-Value
        * 2.Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
        * 3.Map中的key不允许重复原因和HashSet一样，前面分析过源码
        * 4.Map中的value可以重复
        * 5.Map的key可以为null，value也可以为null，注意key为null，只能有一个,value为null，可以多个
        * 6.常用String类作为Map的key
        * 7.key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value
        * 8.Map存放数据的key-value示意图，一对k-V是放在一个Node中的，
        * 因为有Node实现了Entry接口，有些书上也说一对k-V就是一个Entry(如图）[代码演示]
        * */
        /*
        * 1.k-V 最后是 HashMap$Node node = newNode(hash, key， vaLue, null)
        * 2.k-V为了方便程序员的遍历，还会 创建 EntrySet 集合，该集合存放的元素的类型 Entry，
        * 而一个Entry对象就有k,V EntrySet<Entry<K,V>> 即：transient Set<Map.Entry<K,V>> entrySet；
        * 3.entrySet 中，定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node
        * 4.当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历
        * */

        // Map接口常用方法 MapMethod.java
        /*
        * 1.put:添加
        * 2.remove:根据键删除映射关系
        * 3.get：根据键获取值
        * 4.size:获取元素个数
        * 5.isEmpty：判断个数是否为0
        * 6.clear:清除
        * 7.containsKey：查找键是否存在
        * 8.containsValue：查找值是否存在
        * */

        // Map接口循环遍历
        /*
        * MapFor.java
        * 1.containsKey：查找键是否存在
        * 2.keySet:获取所有的键
        * 3.entrySet：:获取所有关系k-V
        * 4.values：获取所有的值
        * */

        // HashMap小结
        /*
        * 1.Map接口的常用实现类：HashMap、Hashtable和Properties。
        * 2.HashMap是Map接口使用频率最高的实现类
        * 3.HashMap是以key-val对的方式来存储数据［案例Entry］
        * 4.key不能重复，但是是值可以重复，充许使用null键和null值
        * 5.如果添加相同的key，则会覆盖原来的key-val，等同于修改.(key不会替换，val会替换）
        * 6.与HashSet一样，不保证映射的顺序，因为底层是以hash表的方式来存储的
        * 7.HashMap没有实现同步，因此是线程不安全的
        * */

        // HashMap扩容机制［和HashSet相同]
        /*
        * 1.HashMap底层维护了Node类型的数组table，默认为null
        * 2.当创建对象时，将加载因子（loadfactor)初始化为0.75
        * 3.当添加key-val时，通过key的哈希值得到在table的素引。然后判断该索引处是否有元素如果没有元素直接添加。
        * 如果该索引处有元素，继续判断该元素的key是否和准备加入的key相等，如果相等，则直接替换val；
        * 如果不相等需要判断是树结构还是链表结构，做出相应处理。如果添加时发现容量不够，则需要扩容
        * 4.第1次添加，则需要扩容table容量为16，临界值（threshold）为12
        * 5.以后再扩容，则需要扩容table容量为原来的2倍，临界值为原来的2倍，即24.依次类推
        * 6.在Java8中，如果一条链表的元素个数超过TREEIFYTHRESHOLD（默认是8），
        * 并且table的大小>=MINTREEIFYCAPACITY(默认64）就会进行树化（红黑树）
        * */

        // Map接口实现类-Hashtable
        // HashTable的基本介绍
        /*
        * 1.存放的元素是键值对：即K-V
        * 2.hashtable的键和值都不能为null
        * 3.hashTable使用方法基本上和HashMap一样
        * 4.hashTable是线程安全的，hashMap是线程不安全的
        * 5.简单看下底层结构 HashTable01.java
        * (1) 底层有数组 HashTable$Entry[] 初始化大小为11
        * (2) 临界值 threshold 8 = 11 * 0.75
        * (3) 扩容 按照自己的扩容机制扩容
        * (4) 执行 this.addEntry(hash, key, value, index)
        * (5) if (this.count >= this.threshold) 满足时名，就进行扩容，执行 this.rehash();
        * (6) 按照 int newCapacity = (oldCapacity << 1) + 1 进行扩容
        * */

        // Hashtable 和 HashMap对比
        // HashMap 版本 1.2  线程安全（同步) 不安全 效率 高 允许null键null值  允许
        // Hashtable 版本 1.0  线程安全（同步) 安全 效率 较低 允许null键null值 不允许

        // Map接口实现类-Properties
        // 基本介绍
        // Properties类继承自Hashtable类并且实现了Map接口，也是使用一种键值对的形式来保存数据
        // 他的使用特点和Hashtable类似
        // Properties还可以用于从xxx.properties文件中，加载数据到Properties类对象，并进行读取和修改
        // 说明：工作后xxx.properties文件通常作为配置文件，这个知识点在IO流举例，有兴趣可先看文章

        // 总结-开发中如何选择集合实现类（记住)
        // 在开发中，选择什么集合实现类，主要取决于业务操作特点，然后根据集合实现类特性进行
        //选择，分析如下：
        /*
        * 1.先判断存储的类型（一组对象或一组键值对)
        * 2.一组对象：Collection接口
        * 允许重复：List
        *   增删多：LinkedList[底层维护了一个双向链表]
        *   改查多：ArrayList[底层维护Object类型的可变数组]
        * 不允许重复：Set
        *   无序：HashSet【底层是HashMap，维护了一个哈希表即（数组+链表+红黑树）1
        *   排序：TreeSet
        *   插入和取出顺序一致：LinkedHashSet，维护数组+双向链表
        * 3.一组键值对：Map
        * 键无序：HashMap【底层是：哈希表jdk7：数组+链表，jdk8:数组+链表+红黑树]
        * 键排序：TreeMap
        * 键插入和取出顺序一致：LinkedHashMap
        * 读取文件Properties
        * */
        System.out.println("Hello world!");
    }
}