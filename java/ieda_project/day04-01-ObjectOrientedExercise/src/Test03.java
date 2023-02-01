public class Test03 {
    public static void main(String[] args) {
        Professor jack = new Professor("Jack", 30, "教授", 40000);
        jack.introduce();
    }
}

class Teacher {
    String name;
    int age;
    String post;
    double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("教师信息\n姓名：" + name + "\n年龄: " + age + "\n职称: " + post + "\n工资: " + salary);
    }
}

class Professor extends Teacher {
    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("教师信息\n姓名：" + name + "\n年龄: " + age + "\n职称: " + post + "\n工资: " + salary * 1.3);
    }
}

class AssociateProfessor extends Teacher {
    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("教师信息\n姓名：" + name + "\n年龄: " + age + "\n职称: " + post + "\n工资: " + salary * 1.2);
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    public void introduce() {
        System.out.println("教师信息\n姓名：" + name + "\n年龄: " + age + "\n职称: " + post + "\n工资: " + salary * 1.1);
    }
}