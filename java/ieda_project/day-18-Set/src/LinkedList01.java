/**
 * @author ljw
 * @version 1.0
 */
public class LinkedList01 {
    public static void main(String[] args) {
        // 模拟一个简单的双向链表
        Node tom = new Node("tom");
        Node jack = new Node("jack");
        Node jerry = new Node("jerry");

        // 连接三个节点，形成双向链表
        tom.next = jack;
        jack.next = jerry;
        jack.pre = tom;
        jerry.pre = jack;
        Node first = tom; // 头节点
        Node last = jerry;// 尾节点

        // 遍历
        System.out.println("从头到尾遍历");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }
        System.out.println("从尾到头遍历");

        while (last != null) {
            System.out.println(last);
            last = last.pre;
        }

        // 添加数据 jack和jerry之间添加数据
        Node tommy = new Node("tommy");
        jack.next = tommy;
        tommy.next = jerry;
        jerry.pre = tommy;
        tommy.pre = jack;
        first = tom;
        System.out.println("从头到尾遍历");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }



    }
}
// 定义一个Node类，Note对象 表示双向链表的一个节点
class Node {
    public Object item; //存放数据
    public Node next; // 指向前一个节点

    public Node pre; // 指向后一个节点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name =" + item;
    }
}