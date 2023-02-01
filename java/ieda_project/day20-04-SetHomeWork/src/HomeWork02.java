import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        Car bm = new Car("宝马", 100000);
        Car fli = new Car("法拉利", 1000000);
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(bm);
        arrayList.add(fli);
        arrayList.remove(bm);
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        ArrayList<Object> arrayList2 = new ArrayList<>();
        arrayList2.add(bm);
        arrayList2.add(fli);
        arrayList.clear();
        System.out.println(arrayList);
        arrayList.addAll(arrayList2);
        System.out.println(arrayList);
        System.out.println(arrayList.containsAll(arrayList2));
        arrayList.removeAll(arrayList2);
        System.out.println(arrayList);
        for (Object o : arrayList2) {
            System.out.println(o);
        }
        Iterator<Object> iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }

    }
}
class Car {
    String name;
    double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}