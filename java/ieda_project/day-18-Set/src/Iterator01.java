import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author ljw
 * @version 1.0
 */
public class Iterator01 {
    public static void main(String[] args) {
        Collection<Object> col = new ArrayList<>();
        col.add(new Book("红楼梦",450,"曹雪芹"));
        col.add(new Book("三国演义",550,"罗贯中"));
        col.add(new Book("西游记",650,"吴承恩"));
        // 进行遍历
        // 得到迭代器
        Iterator<Object> integer = col.iterator();
        // 使用While循环 快捷键生成 itit Ctrl + j 显示所有快捷模板
        while (integer.hasNext()) {
            Object next = integer.next();
            System.out.println(next);
        }
//        for (Object next : col) {
//            System.out.println(next);
//        }
        // 此时再取元素会抛异常 NoSuchElementException
//        integer.next();
        // 如果需要再取，需要重置一次
        integer = col.iterator();
        System.out.println(integer.next());

    }
}
class Book{
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}