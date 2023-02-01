public class 面向对象test02 {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "John";
        p.age = 20;
        Mytools p2 = new Mytools();
        Person p3 = p2.copyPerson(p);
        System.out.println(p + "\t" + p3);//输出内存地址
        System.out.println(p == p3); //直接判断两个是否为同一个对象
        System.out.println(p3.name + "\t" + p3.age);
    }
}

class Person {
    String name;
    int age;
}

class Mytools {
    public Person copyPerson(Person p) {
        Person p2 = new Person();
        p2.name = p.name;
        p2.age = p.age;
        return p2;
    }
}