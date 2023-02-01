import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author ljw
 * @version 1.0
 */
public class ListTest02 {
    public static void main(String[] args) {
        // 使用List的实现类添加三本图书，并遍历，打印如下效果
        //名称：xx
        //价格：xx
        //作者：xx
        List<Book02> list = new Vector<>();
        list.add(new Book02("红楼梦", 100, "曹雪芹"));
        list.add(new Book02("西游记", 300, "吴承恩"));
        list.add(new Book02("水浒传", 500, "施耐庵"));
        list.add(new Book02("三国志", 200, "罗贯中"));
        //1）按价格排序，从低到高（使用冒泡法）
        //2)要求使用ArrayList、LinkedList 和Vector三种集合实现
        bookMp(list);
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void bookMp(List<Book02> list) {
        Book02 temp;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((list.get(i)).getPrice() > (list.get(j)).getPrice()) {
                    temp = list.get(i);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }
}

class Book02 {
    private String name;
    private double price;
    private String author;

    public Book02(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("名称: %s\t\t价格: %.2f\t\t作者: %s", name, price, author);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}