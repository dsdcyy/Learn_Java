import java.util.Random;
import java.util.Scanner;

public class 面向对象_test02 {
    public static void main(String[] args) {
        // 7
        Dog dog = new Dog("Jack", "黑色", 3);
        dog.show();
        // 8. count1=10;count1=9;count1=10;
        // 9
        Music music = new Music("晴天", 100);
        music.paly();
        music.getinfo();
        // 10. i = 101; j = 100; 101,101
        // 11
        Tets test = new Tets();
        double res = test.method(test.method(10, 20), 100);
        System.out.println(res);
        // 12
        Employee emp1 = new Employee("John", '男', 22, "经理", 10000);
        Employee emp2 = new Employee("John", '男', 22);
        Employee emp3 = new Employee("经理", 10000);
        // 13
        PassObject p1 = new PassObject();
        Circle c = new Circle(10);
        p1.printAreas(c, 10);

         // 14
         Person person = new Person("张三");
         person.mora();
    }
}

// 7.设计Dog类，有名字，颜色，年龄属性，定义方法show,输出其信息
class Dog {
    String name;
    String color;
    int age;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show() {
        System.out.println("name: " + name + " color: " + color + " age: " + age);
    }
}

// 9.定义Music类，有属性音乐名name，歌曲时长times,并有播放方法play,获取歌曲信息方法getinfo
class Music {
    String name;
    double times;

    public Music(String name, double times) {
        this.name = name;
        this.times = times;
    }

    public void paly() {
        System.out.println("音乐:" + name + "开始播放！");
    }

    public void getinfo() {
        System.out.println("歌曲名称: " + name + "\t" + "歌曲时长： " + times + "秒");
    }
}

// 11.在测试类定义method方法 method(method(10,20),100)
class Tets {
    public double method(double n, double m) {
        return n + m;
    }

    public static void main(String[] args) {
        // new Tets 是匿名对象，使用后就无法使用了
        // new Tets.method 匿名对象调用方法
        new Tets().method(0, 0);

    }
}

// 12.创建一个Employee类 属性有(名字,性别,年龄,职业,薪水),提供3个构造方法,
// （1）可以初始化 (名字,性别,年龄,职业,薪水)
// （2）(名字,性别,年龄)
// （3） (职业,薪水)
class Employee {
    String name;
    char gender;
    int age;
    String position;
    double salary;

    public Employee(String name, char gender, int age, String position, double salary) {
        this(name, gender, age);
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }
}

// 13
class Circle {
    double redius;

    public Circle(double redius) {
        this.redius = redius;
    }
    public Circle() {

    }

    public double findArea() {
        return redius * redius * Math.PI;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }
}

class PassObject {
    public void printAreas(Circle c, int items) {
        System.out.println("Redius\tArea");
        for (int i = 1; i <= items; i++) {
            c.setRedius(i);
            System.out.println(c.redius + "\t" + c.findArea());
        }
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public int mora() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        while (true) {
            System.out.println("玩家" + name + "获胜: " + count + "场");
            System.out.println("请选择您出拳类型(0 石头 1 剪刀 2 布 3 退出 ):");
            int choose = scanner.nextInt();
            int robot_points = random.nextInt(3);
            if (choose < 3) {
                if (choose == robot_points) {
                    print_result(robot_points, choose);
                    System.out.println("此局平局");
                } else {
                    if ((choose == 0 && robot_points == 1) || (choose == 1 && robot_points == 2)
                            || (choose == 2 && robot_points == 0)) {
                        print_result(robot_points, choose);
                        System.out.println("玩家获胜,胜场+1");
                        count++;
                    } else {
                        print_result(robot_points, choose);
                        System.out.println("玩家失败!");
                    }
                }
            } else {
                System.out.println("退出游戏");
                break;
            }
        }
        return count;
    }

    public String punch_type(int number) {
        if (number == 0) {
            return "石头";
        } else if (number == 1) {
            return "剪刀";
        } else {
            return "布";
        }
    }

    public void print_result(int r, int c) {
        System.out.println("电脑: " + punch_type(r) + "\t" + "玩家" + this.name + ": " + punch_type(c));

    }
}