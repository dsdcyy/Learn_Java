import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author ljw
 * @version 1.0
 */
public class HashSetTest02 {
    public static void main(String[] args) {
        HashSet<Employee02> set = new HashSet<>();
        set.add(new Employee02("张飞", 1000, new Employee02.MyDate(2000, 12, 10)));
        set.add(new Employee02("刘备", 5000, new Employee02.MyDate(2001, 12, 10)));
        System.out.println(set.add(new Employee02("张飞", 10000, new Employee02.MyDate(2000, 12, 10))));
        for (Object o :set) {
            System.out.println(o);
        }


    }
}

class Employee02 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee02(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    static class MyDate {
        private int year;
        private int month;
        private int day;

        MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof MyDate) {
                MyDate that = (MyDate) o;
                return  that.getYear() == this.getYear() &&
                        that.getMonth() == this.getMonth() &&
                        that.getDay() == this.getDay();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
        if (!(o instanceof Employee02)) return false;
        Employee02 that = (Employee02) o;
        return this.name.equals(that.name) && this.getBirthday().equals(that.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee02{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}