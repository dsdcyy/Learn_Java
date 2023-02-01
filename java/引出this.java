public class 引出this {
    public static void main(String[] args) {
        // this的注意事项和细节
        /*
         * 1.this关键字可以用来访问本类的属性，方法，构造器
         * 2.this用于区分当前类的属性和局部变量
         * 3.访问成员方法的语法 this.方法名(参数列表)
         * 4.访问构造器语法 this(参数列表) 注意 只能在构造器中使用
         * 5.this不能在类定义的外部使用，只能在类定义的方法中使用
         */
        Dog dog = new Dog("jack", 5);
        Dog dog2 = new Dog("jerry", 3);
        dog.info();
        System.out.println(dog.hashCode());
        dog2.info();
        System.out.println(dog2.hashCode());
        dog.f2();
        Dog dog3 = new Dog();
        dog3.info();
        dog3.f3();
        System.out.println(dog3.compare(dog2));
        System.out.println(dog3.compare(dog3));

    }
}

class Dog {
    String name;
    int age;

    // 不想改变构造器形参与属性不一致 this 对象本身
    public Dog() {
        // 构造器访问构造器
        // 这里去访问Dog(String name, int age) 这句语句必须放在第一条
        this("jack", 10);
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(this.hashCode());

    }

    public void info() {
        System.out.println(name + "\t" + age + "\t");
    }

    public void f1() {
        System.out.println("f1方法被调用");
    }

    public void f2() {
        System.out.println("f2方法被调用");
        // 直接调用
        f1();
        // 通过this调用
        this.f1();
    }

    public void f3() {
        // this访问属性
        String name = "Hello World";
        // 就近寻找
        System.out.println(name + "\t" + age + "\t");
        // 明确指定找的就是属性
        System.out.println(this.name + "\t" + this.age + "\t");

    }

    public Boolean compare(Dog outher) {
        return this.name.equals(outher.name) && this.age == outher.age;
  

    }
}