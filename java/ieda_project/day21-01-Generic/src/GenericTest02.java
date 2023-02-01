import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author ljw
 * @version 1.0
 */
public class GenericTest02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jack", 20000, new Employee.MyDate(2000, 11, 7)));
        employees.add(new Employee("Tom", 20000, new Employee.MyDate(2001, 12, 8)));
        employees.add(new Employee("Tom", 20000, new Employee.MyDate(2000, 12, 6)));
        employees.add(new Employee("Alice", 20000, new Employee.MyDate(2002, 8, 6)));
        employees.add(new Employee("Alice", 40000, new Employee.MyDate(2003, 8, 6)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(employees);
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private double sal;
    private MyDate date;

    @Override
    public int compareTo(Employee emp1) {
        int i = this.getName().compareTo(emp1.getName());
        if (i != 0) {
            return i;
        }
        return emp1.getDate().compareTo(this.getDate());
    }

    static class MyDate implements Comparable<MyDate> {
        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            setYear(year);
            setMonth(month);
            setDay(day);
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}' + "\n";
        }

        @Override
        public int compareTo(MyDate date1) {
            int yearMinus = date1.getYear() - this.getYear();
            if (yearMinus != 0) {
                return yearMinus;
            }
            int monthMinus = date1.getMonth() - this.getMonth();
            if (monthMinus != 0) {
                return monthMinus;
            }
            return date1.getDay() - this.getDay();
        }
    }

    public Employee(String name, double sal, MyDate date) {
        setName(name);
        setDate(date);
        setSal(sal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", date=" + date +
                '}' + "\n";
    }

}