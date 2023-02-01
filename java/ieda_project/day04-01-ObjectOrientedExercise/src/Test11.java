public class Test11 {
    public static void main(String[] args) {
        // 向上转型
        Person11 p = new Student();
        p.eat();
        p.run();
        // 向下转型
        Student student = (Student)p;
        student.run();
        student.eat();
        student.study();
    }
}
class Person11{
    public void run(){
        System.out.println("person running...");
    }
    public void eat(){
        System.out.println("person eat...");
    }
}
class Student extends Person11{
    public void run(){
        System.out.println("student running...");
    }
    public void study(){
        System.out.println("student study...");
    }
}