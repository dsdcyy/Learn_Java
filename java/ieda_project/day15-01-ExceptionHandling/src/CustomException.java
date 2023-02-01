/**
 * @author ljw
 * @version 1.0
 */

/*
* 当我们接收Person对象年龄时，要求范围在18－120之间，否则抛出一个
自定义异常（要求继承RuntimeException），并给出提示信息。
*/
public class CustomException {
    public static void main(String[] args) {
        Person2 p = new Person2("ljw",20);
        System.out.println(p);
        p.setAge(121);

    }
}

class Person2 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            // 抛出异常
            throw new AgeException("年龄必须在0-120岁之间");
        }

    }

    public Person2(String name, int age) {
        setAge(age);
        setName(name);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}