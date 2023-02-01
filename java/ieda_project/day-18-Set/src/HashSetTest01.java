import java.util.HashSet;
import java.util.Objects;

/**
 * @author ljw
 * @version 1.0
 */
public class HashSetTest01 {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<>();
        System.out.println(set.add(new Employee("John", 20)));
        System.out.println(set.add(new Employee("Jerry", 24)));
        System.out.println(set.add(new Employee("John", 20)));
        System.out.println(set);

    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}