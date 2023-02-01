import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ljw
 * @version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 200);
        books[1] = new Book("西游记", 100);
        books[2] = new Book("三国演义", 250);
        books[3] = new Book("金瓶梅", 300);
//        px(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int n1 = (int) o1;
//                int n2 = (int) o2;
//                return n2 - n1;
//            }
//        });
//        for (Book book : books) {
//            System.out.println(book);
//        }
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book2.name.length()-book1.name.length();
            }
        });
        for (Book book : books) {
            System.out.println(book);
        }
    }


    public static void px(Book[] books, Comparator<Integer> c) {
        Book temp;
        for (int i = 0; i < books.length; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if (c.compare((int) books[i].price, (int) books[j].price) > 0) {
                    temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }
}

class Book {
    String name;
    double price;

    Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}