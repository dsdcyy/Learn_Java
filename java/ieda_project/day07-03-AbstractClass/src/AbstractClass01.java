public class AbstractClass01 {
    public static void main(String[] args) {

    }
}
// 抽象类
abstract class Animal{
    private final String name;

    public Animal(String name) {
        this.name = name;
    }
//    public void eat() {
//        System.out.println("这是个动物，但是不知道它吃什么...");
//    }
    // 抽象方法
    public abstract void eat();
}