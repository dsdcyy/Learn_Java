import org.w3c.dom.Node;

import java.util.HashSet;

/**
 * @author ljw
 * @version 1.0
 */
public class HashSetStructure {
    public static void main(String[] args) {
//        Node2[] nodes = new Node2[16]; // table
//        System.out.println("nodes: " + nodes);
//        Node2 john = new Node2("john",null);
//        nodes[2] = john; // 链表
//        Node2 jack = new Node2("jack",null);
//        john.next = jack;
//        Node2 rose = new Node2("rose",null);
//        jack.next = rose;
//        Node2 lucy = new Node2("lucy",null);
//        nodes[3] = lucy;

        /*
        * 1.先获取元素的哈希值（hashcode方法)
        * 2.对哈希值进行运算，得出一个索引值即为要存放在哈希表中的位置号
        * 3.如果该位置上没有其他元素，则直接存放如果该位置上已经有其他元素，
        * 则需要进行equals判断，如果相等，则不再添加。
        * 如果不相等则以链表的方式添加。
         */
        // 链表大于8个 table数据大于64转红黑数

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
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("hashSet = " + hashSet);

        /*
        1. 执行add方法
           public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
        2. 执行put方法
             public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
        3. 执行hash方法
          static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
        4. 执行putVal方法
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i; // 定义了辅助变量
        // if 语句表示如果当前table是null或者大小等于0
        // 就进行第一次扩容
        if ((tab = table) == null || (n = tab.length) == 0) // table hashMap的一个数组，类型是Node[]
            n = (tab = resize()).length;
            // 根据key，得到hash去计算该key应该存放到table表的哪个索引位置
            // 并把这个位置的对象赋给p
            // 判断p是否为null，如果为null，表示没有存放元素，就创建一个node
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // p.hash == hash 当前位置所对应的第一个元素和准备添加的key的hash值是否相同
            // 并且满足下面的两个条件之一
            // 1. 准备加入的key和p指向node节点的key是同一个对象
            // 2. 这个key不为空并且key的内容和和节点对应的key一致
            // 将 p 赋给e
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
                // 判断 p是不是红黑树
                // 如果是红黑树，就调用putTreeVal
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
        * */

    // 分析HashSet的扩容和转成红黑数机制
    /*
    * 1.HashSet底层是HashMap，第一次添加时，table数组扩容到16，
    * 临界值（threshold)是16*加载因子(oadFactor)是0.75=12
    * 2.如果table数组使用到了临界值12.就会扩容到16＊2=32，新的临界值就是32*0.75=24，依次类推
    * 3.3。在Java8中，如果一条链表的元素个数到达TREEIFYTHRESHOLD（默认是8）
    * 并且table的大小>=MINTREEIFYCAPACITY默认64)就会进行树化(红黑树)，否则仍然采用数组扩容机制
    * */


    }
}

class Node2 {
    Object item;
    Node2 next;

    public Node2(Object item, Node2 next) {
        this.item = item;
        this.next = next;
    }
}