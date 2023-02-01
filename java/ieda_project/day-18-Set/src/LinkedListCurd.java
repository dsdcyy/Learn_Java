import java.util.LinkedList;

/**
 * @author ljw
 * @version 1.0
 */
public class LinkedListCurd {
    public static void main(String[] args) {
        // // LinkedList的增删改查案例
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 增
        /*
        * void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
        * */
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList);
        // 删除节点  remove 默认删除第一个
        /*
        * private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
        * */
        linkedList.remove();
        System.out.println(linkedList);

        // 修改某个节点
        linkedList.set(0,999);
        System.out.println(linkedList);
        // 得到某个节点
        System.out.println(linkedList.get(0));
    }
}
