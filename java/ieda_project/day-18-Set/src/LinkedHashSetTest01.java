import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author ljw
 * @version 1.0
 */
public class LinkedHashSetTest01 {
    public static void main(String[] args) {
        LinkedHashSet<Object> set = new LinkedHashSet<>();
        set.add(new Car("奥迪",100000));
        set.add(new Car("奥拓",1000));
        set.add(new Car("奥迪",1000));
        System.out.println(set.add(new Car("奥迪", 1000)));
        System.out.println(set);
    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return car.name.equals(this.name) && car.price == this.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}