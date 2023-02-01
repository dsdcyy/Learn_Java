public class 创建对象 {
    public static void main(String[] args){
        //1.先声明在创建
        Person person1;
        person1 = new Person();
        //2.直接创建
        Person person2 = new Person();
    }

}
class Person{
    int age ;
    String name;
    double sal;
    boolean isPass;
}
/*
 * java创建对象的流程简单分析
 * 1.先加载Person类信息(属性和方法信息，只会加载一次)
 * 2.在堆中分配内存地址，进行默认初始化
 * 3.把地址赋给person1,person2指向对象
 * 4.进行指定初始化
 */