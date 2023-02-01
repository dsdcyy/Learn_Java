public class Singleton {
    public static void main(String[] args) {
        System.out.println(SingletonFullMan.getGirlfriend());
        System.out.println(SingletonFullMan.getGirlfriend());
        // 在调用其它静态属性时也会创建对象
        System.out.println(SingletonFullMan.age);
        // 在调用其它静态属性时并不会创建对象
        System.out.println(SingletonLazyMan.n1);
        System.out.println(SingletonLazyMan.getCat());
        System.out.println(SingletonLazyMan.getCat());
    }

}

// 饱汉式
class SingletonFullMan {
    private String name;

    static int age = 99;

    // 构造器私有化
    private SingletonFullMan(String name) {
        System.out.println("SingletonFullMan...");
        this.name = name;
    }

    // 在类中创建对象
    private static SingletonFullMan girlfriend = new SingletonFullMan("温雅宝贝");

    // 通过公共方法返回创建的对象
    public static SingletonFullMan getGirlfriend() {
        System.out.println("1111");
        return girlfriend;
    }

    @Override
    public String toString() {
        return "SingletonFullMan{" +
                "name='" + name + '\'' +
                '}';
    }
}

// 饿汗式
class SingletonLazyMan {
    private String name;
    static int n1 = 999;
    private static SingletonLazyMan cat;

    private SingletonLazyMan(String name) {
        System.out.println("singleton lazy man ...");
        this.name = name;
    }

    public static SingletonLazyMan getCat() {
        if (cat == null) {
            cat = new SingletonLazyMan("小可爱");

        }
        return cat;
    }

    @Override
    public String toString() {
        return "SingletonLazyMan{" +
                "name='" + name + '\'' +
                '}';
    }
}